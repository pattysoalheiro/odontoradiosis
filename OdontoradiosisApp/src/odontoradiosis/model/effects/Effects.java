
package odontoradiosis.model.effects;

import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;
import odontoradiosis.histograma.HistogramPlot;

/**
 *
 * @author Beto
 */
public class Effects {

    public static PlanarImage negative(PlanarImage source) {
        
        return JAI.create("invert", source);
    }
    
    public static PlanarImage borderDetection(PlanarImage source) {

        return JAI.create("gradientmagnitude", source, KernelJAI.GRADIENT_MASK_SOBEL_HORIZONTAL,
                KernelJAI.GRADIENT_MASK_SOBEL_VERTICAL);
    }
    
    public static PlanarImage equalization(PlanarImage source) {

        int[] hitograma = HistogramPlot.getHistogram(source);//histograma da imagem
        double[] histogramaNormalizado = new double[hitograma.length];//histograma normalizado
        double[] pixels;
        int height = source.getHeight();
        int width = source.getWidth();
        int dim = height*width;

        histogramaNormalizado[0] = hitograma[0]/dim;
        for(int i = 1;i<hitograma.length;i++)
        {
            hitograma[i] = hitograma[i] + hitograma[i-1];// Fazendo o histograma acumulado
            histogramaNormalizado[i] = (double)hitograma[i]/dim;//Fazendo o histograma normalizado
        }

        /*Processo de construção da nova imagem*/

        SampleModel sm = source.getSampleModel();
        int nbands = sm.getNumBands();
        
        Raster inputRaster = source.getData();
        ColorModel c = source.getColorModel();
        int pixelSize = (c.getPixelSize()/nbands);
        WritableRaster outputRaster = inputRaster.createCompatibleWritableRaster();
        pixels = new double[nbands * width * height];//pixels alterados

        /*Fazendo vetor de pixels da imagem original*/
        int[] pixelsImagemOriginal = new int[nbands*height*width];
        inputRaster.getPixels(0,0,width,height,pixelsImagemOriginal);
        
        /*construindo novo vetor de pixels equalizados*/
        for(int i =0;i<dim;i++)
        {
            pixels[i] = (double)histogramaNormalizado[pixelsImagemOriginal [i]]*(Math.pow(2, pixelSize) - 1);            
        }

        outputRaster.setPixels(0, 0, width, height, pixels);

        TiledImage ti = new TiledImage(source, width, height);

        
        ti.setData(outputRaster);

        return ti;
 
    }
    
    public static PlanarImage modifyBrightness(PlanarImage source, float percentValue) {

        int width = source.getWidth();
        int height = source.getHeight();
        int nbands = source.getSampleModel().getNumBands();

        Raster inputRaster = source.getData();
        ColorModel c = source.getColorModel();

        long pixelSize = (c.getPixelSize() / nbands);
        long valorMaxPixel = (long) (Math.pow(2, pixelSize) - 1);
        WritableRaster outputRaster = inputRaster.createCompatibleWritableRaster();
        double[] pixels = new double[nbands * width * height];
        inputRaster.getPixels(0, 0, width, height, pixels);

        int value = (int) Math.floor(valorMaxPixel * percentValue/100);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = (int) (value + (pixels[i]));
            if (pixels[i] < 0) {
                pixels[i] = 0;
            } else {
                if (pixels[i] > valorMaxPixel) {
                    pixels[i] = valorMaxPixel;
                }
            }
        }

        outputRaster.setPixels(0, 0, width, height, pixels);
        TiledImage ti = new TiledImage(source, width, height);
        ti.setData(outputRaster);

        return ti;
    }

    public static PlanarImage binarization(PlanarImage source, int percentThreshold) {

        source = convertColorToGray(source);
        long pixelSize = (source.getColorModel().getPixelSize() / source.getNumBands());
        long valorMaxPixel = (long) (Math.pow(2, pixelSize) - 1);
        int threshold = (int) Math.floor(valorMaxPixel * percentThreshold / 100);
        
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(source);
        pb.add(1.0 * threshold);

        PlanarImage output = JAI.create("binarize", pb);

        return output;
    }

    public static PlanarImage convertColorToGray(PlanarImage source) {

        if(source.getNumBands() == 3) {
            double[][] matrix = {   { .114D, 0.587D, 0.299D, 0 },
                                    { .114D, 0.587D, 0.299D, 0 },
                                    { .114D, 0.587D, 0.299D, 0 }
                                };

            if ( source != null ) {
                ParameterBlock pb = new ParameterBlock();
                pb.addSource(source);
                pb.add(matrix);
                source = JAI.create("bandcombine", pb, null);
            }
        }

        return source;
    }
       
}
