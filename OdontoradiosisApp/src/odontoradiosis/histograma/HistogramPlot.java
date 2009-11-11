/*
 * HistogramaPlot.java
 *
 * Created on 9 de Agosto de 2008, 09:05
 */

package odontoradiosis.histograma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.Histogram;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import org.jfree.chart.demo.BarChartDemo1;

/**
 *
 * @author beto
 */
public class HistogramPlot extends JComponent {
    
    private int[] data;
    private int max;
    
       

    
    public HistogramPlot() {
        super();
        setLayout(new GridLayout());
    }
    
    
    private void setData(int[] array) {
        data = new int[array.length];
        max = -1;

        for ( int i = 0; i < array.length; i++ ) {
            data[i] = array[i];

            if ( data[i] > max ) {
                max = data[i];
            }
        }
    }

    
    public void plot(int[] array) {
        setData(array);
        repaint();
    }
    
    
    public synchronized void paintComponent(Graphics g) {

        Graphics2D g2D = null;
        if (g instanceof Graphics2D) {
            g2D = (Graphics2D)g;
        } else {
            return;
        }

        int width = getSize().width;
        int height = getSize().height;

        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, width, height);
        
        g2D.setColor(Color.BLACK);
        g2D.fillRect(5, 5, width-10, height-10);
        g2D.setColor(Color.white);
        
        if ( data == null ) return;

        int length = data.length;
        float slope_x = (float) width / (float) length;
        float slope_y = (float) height / (float) max;

        for ( int i = 0; i < length; i++ ) {
           int x = (int) ((float)i*slope_x);
           int y = (int) ((float)data[i]*slope_y);
           g.drawLine(x, height, x, height - y);
        }
    }
    
    public static int[] getHistogram(PlanarImage image) {
        
        int numBits = image.getColorModel().getPixelSize();
        int numCanais = image.getColorModel().getNumComponents();
        int numBitsPorPixel = numBits / numCanais;
        double pixelComponent = Math.pow(2, numBitsPorPixel);
                
        int[] bins = { (int) pixelComponent };
        double[] low = { 0.0D };
        double[] high = { pixelComponent };

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(image);
        pb.add(null);
        pb.add(1);
        pb.add(1);
        pb.add(bins);
        pb.add(low);
        pb.add(high);

        RenderedOp op = JAI.create("histogram", pb, null);
        Histogram histogram = (Histogram) op.getProperty("histogram");

        // captura conteudo do histograma
        int[] local_array = new int[histogram.getNumBins(0)];
        for ( int i = 0; i < histogram.getNumBins(0); i++ ) {
            local_array[i] = histogram.getBinSize(0, i);
        }

        return local_array;
    }
    
    public int limiarOtimo(PlanarImage imagem)
    {

        int [] bitsPorCor = imagem.getColorModel().getComponentSize();
        int [] hist = new int[(int)Math.pow(2,bitsPorCor[0]) - 1];
        hist = getHistogram(imagem);
        int comprimento = imagem.getWidth();
        int largura = imagem.getHeight();
        double quantidadePixels = comprimento * largura;
        double mediaTotal = 0;
        double W0,W1,media0,media1;
        double variQuad = 0;
        double maxVariQuad = 0;
        int limiarOtimo =0;

        for(int i = 0;i<hist.length;i++)
        {
            mediaTotal = mediaTotal + i*(hist[i]);///quantidadePixels);//Cálculo de média total
        }

        mediaTotal = mediaTotal /quantidadePixels;

        for(int limiar =1; limiar < hist.length - 1;limiar++)
        {
            W0 = W1 = media0 = media1 = 0;

            for(int i = 0;i< limiar;i++)
            {
                W0 = W0 + hist[i];///quantidadePixels;//Somatório da primeira classe
            }

            W0 = W0 / quantidadePixels;

            for(int j = limiar;j< hist.length;j++)
            {
               W1 = W1 + hist[j];///quantidadePixels;//Somatório da segunda classe
            }

            W1 = W1 / quantidadePixels;

            for(int i = 0;i< limiar;i++)
            {
               media0 = media0 +(i*(hist[i]));///quantidadePixels))/W0;//Média da primeira classe
            }

            media0 = media0 / quantidadePixels / W0;

            for(int j = limiar;j< hist.length;j++)
            {
               media1 = media1 +(j*(hist[j]));///quantidadePixels))/W1;//Média da segunda classe
            }

            media1 = media1 / quantidadePixels / W1;

            variQuad = W0*(Math.pow((media0 - mediaTotal),2)) +
                       W1*(Math.pow((media1 - mediaTotal),2));//Cálculo da variância ao quadrado

            if(variQuad > maxVariQuad)//Verifica a maximização da variância
            {
                limiarOtimo = limiar;
                maxVariQuad = variQuad;
            }

        }

        return limiarOtimo;   
        
    }
    
    public int limiarOtimo(PlanarImage imagem, JProgressBar barra)
    {
        int [] bitsPorCor = imagem.getColorModel().getComponentSize();
        int [] hist = new int[(int)Math.pow(2,bitsPorCor[0]) - 1];
        hist = getHistogram(imagem);
        int comprimento = imagem.getWidth();
        int largura = imagem.getHeight();
        double quantidadePixels = comprimento * largura;
        double mediaTotal = 0;
        double W0,W1,media0,media1;
        double variQuad = 0;
        double maxVariQuad = 0;
        int limiarOtimo =0;
        
        
        for(int i = 0;i<hist.length;i++)
        {
            mediaTotal = mediaTotal + i*(hist[i]/quantidadePixels);//Cálculo de média total
        }
        
        for(int limiar =1; limiar < hist.length - 1;limiar++)
        {
            W0 = W1 = media0 = media1 = 0;

            for(int i = 0;i< limiar;i++)
            {
                W0 = W0 + hist[i]/quantidadePixels;//Somatório da primeira classe
            }
            
            for(int j = limiar;j< hist.length;j++)
            {
               W1 = W1 + hist[j]/quantidadePixels;//Somatório da segunda classe 
            }
              
            for(int i = 0;i< limiar;i++)
            {
               media0 = media0 +(i*(hist[i]/quantidadePixels))/W0;//Média da primeira classe
            }
            
            for(int j = limiar;j< hist.length;j++)
            {
               media1 = media1 +(j*(hist[j]/quantidadePixels))/W1;//Média da segunda classe
            }
            
            variQuad = W0*(Math.pow((media0 - mediaTotal),2)) + 
                       W1*(Math.pow((media1 - mediaTotal),2));//Cálculo da variância ao quadrado
            
            if(variQuad > maxVariQuad)//Verifica a maximização da variância
            {
                limiarOtimo = limiar;
                maxVariQuad = variQuad;
            }
            barra.setValue(limiar);
            barra.updateUI();
        }
        
        return limiarOtimo;
        
        
        
        
    }
    
}
