
package odontoradiosis.model.effects;

import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;

/**
 *
 * @author Beto
 */
public class Contrast {

    public static TiledImage imageContrast(PlanarImage source, int percentLimiar, float fcontrast) {

        SampleModel sampleModel = source.getSampleModel();
        Raster inputRaster = source.getData();
        ColorModel colorModel = source.getColorModel();
        WritableRaster outputRaster = inputRaster.createCompatibleWritableRaster();

        int width = source.getWidth();
        int height = source.getHeight();
        int nbands = sampleModel.getNumBands();
        int pixelSize = (colorModel.getPixelSize()/nbands);
        int valorMaxPixel = (int) (Math.pow(2, pixelSize) - 1);
        
        double[] pixels = new double[nbands * width * height];
        inputRaster.getPixels(0, 0, width, height, pixels);

        int limiar = valorMaxPixel * percentLimiar/100;

        for (int i = 0; i < pixels.length; i++) {

            pixels[i] = round(limiar + (pixels[i] - limiar) * fcontrast);

            if (pixels[i] < 0)
                pixels[i] = 0;

            else if (pixels[i] > valorMaxPixel)
                pixels[i] = valorMaxPixel;
        }

        outputRaster.setPixels(0, 0, width, height, pixels);
        TiledImage ti = new TiledImage(source, width, height);
        ti.setData(outputRaster);
        
        return ti;
    }

    private static int round(double value) {

        int aux = (int) value;
        value = value - aux;

        if (value > 0.5)
            return (1 + aux);
        else
            return (aux);
    }
}
