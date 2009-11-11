
package odontoradiosis.model.analises.tracado;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import odontoradiosis.model.analises.Ponto;
import odontoradiosis.view.pontos.ORSDisplayJAI;


public class AnaliseWylie extends Tracado {

    private int coeficienteGoMe;
    private int coeficienteGoCd;
    private double valorGoGn;
    private double dFGS, dGoMe, dGoCd, dENAN, dNMe, dSPtm;
    private double distrealdFGS, distrealdGoMe, distrealdGoCd,
                   distrealdENAN, distrealdNMe, distrealdSPtm;

    public AnaliseWylie(ArrayList<Ponto> pontos, int PCms) {
        super(pontos, PCms);
    }


    public void executarTracado() {

        // Organiza Pontos
        pontosOrdenados.addAll(pontos);

        for (int i = 0; i < pontos.size(); i++) {
            Ponto ponto = pontos.get(i);

            if(ponto.getSigla().equals("Po"))
                pontosOrdenados.set(0, ponto);
            else if(ponto.getSigla().equals("Or"))
                pontosOrdenados.set(1, ponto);
            else if(ponto.getSigla().equals("N"))
                pontosOrdenados.set(2, ponto);
            else if(ponto.getSigla().equals("Me"))
                pontosOrdenados.set(3, ponto);
            else if(ponto.getSigla().equals("Go"))
                pontosOrdenados.set(4, ponto);
            else if(ponto.getSigla().equals("Cd"))
                pontosOrdenados.set(5, ponto);
            else if(ponto.getSigla().equals("S"))
                pontosOrdenados.set(6, ponto);
            else if(ponto.getSigla().equals("PMS"))
                pontosOrdenados.set(7, ponto);
            else if(ponto.getSigla().equals("ENA"))
                pontosOrdenados.set(8, ponto);
            else if(ponto.getSigla().equals("Ptm"))
                pontosOrdenados.set(9, ponto);
            else if(ponto.getSigla().equals("FS"))
                pontosOrdenados.set(10, ponto);
            else if(ponto.getSigla().equals("FI"))
                pontosOrdenados.set(11, ponto);
            else if(ponto.getSigla().equals("PN"))
                pontosOrdenados.set(12, ponto);
        }

        calculaAngulos();
        calculaDistancias();
        setTracadoCalculado(true);
    }

    private void calculaAngulos() {
        
        coeficienteGoMe = (pontosOrdenados.get(4).y - pontosOrdenados.get(3).y)/(pontosOrdenados.get(4).x - pontosOrdenados.get(3).x); //SNA
        coeficienteGoCd = (pontosOrdenados.get(5).y - pontosOrdenados.get(4).y)/(pontosOrdenados.get(5).x - pontosOrdenados.get(4).x); //GoCd
        valorGoGn = 180 - (Math.toDegrees(Math.abs(Math.atan(coeficienteGoMe))) + Math.toDegrees(Math.abs(Math.atan(coeficienteGoCd)))); //ângulo GoGn

        System.out.println("ângulo GoGn "+ valorGoGn);
    }

    private void calculaDistancias () {

         // Analise Horizontal
         dFGS = Math.sqrt(Math.pow(pontosOrdenados.get(5).y-pontosOrdenados.get(6).y,2) +
                 Math.pow(pontosOrdenados.get(5).x-pontosOrdenados.get(6).x,2)); //Fossa Glenóide - Sela
         dSPtm = Math.sqrt(Math.pow(pontosOrdenados.get(8).y-pontosOrdenados.get(6).y,2) +
                 Math.pow(pontosOrdenados.get(8).x-pontosOrdenados.get(6).x,2)); //SPtm
         double AFs = (Math.sqrt(Math.pow(pontosOrdenados.get(10).y-pontosOrdenados.get(12).y,2) + 
                 Math.pow(pontosOrdenados.get(10).x-pontosOrdenados.get(12).x,2)) / Math.sqrt(Math.pow(pontosOrdenados.get(11).y-pontosOrdenados.get(12).y,2) +
                 Math.pow(pontosOrdenados.get(11).x-pontosOrdenados.get(12).x,2)))*100;

         distrealdFGS =((dFGS/PCms)*2)*10;
         distrealdSPtm =((dSPtm/PCms)*2)*10;

         
         // Analise Vertical
         dGoMe = Math.sqrt(Math.pow(pontosOrdenados.get(3).y-pontosOrdenados.get(4).y,2) +
                 Math.pow(pontosOrdenados.get(3).x-pontosOrdenados.get(4).x,2)); //GoMe
         dGoCd = Math.sqrt(Math.pow(pontosOrdenados.get(5).y-pontosOrdenados.get(4).y,2) +
                 Math.pow(pontosOrdenados.get(5).x-pontosOrdenados.get(4).x,2)); //GoCd
         dENAN = Math.sqrt(Math.pow(pontosOrdenados.get(2).y-pontosOrdenados.get(7).y,2) +
                 Math.pow(pontosOrdenados.get(2).x-pontosOrdenados.get(7).x,2));
         dNMe = Math.sqrt(Math.pow(pontosOrdenados.get(2).y-pontosOrdenados.get(3).y,2) +
                 Math.pow(pontosOrdenados.get(2).x-pontosOrdenados.get(3).x,2));

         distrealdGoMe =((dGoMe/PCms)*2)*10;
         distrealdGoCd =((dGoMe/PCms)*2)*10;
         distrealdENAN =((dENAN/PCms)*2)*10;
         distrealdNMe = ((dNMe/PCms)*2)*10;         
     }

    public void paintTracado(Graphics g) {

        if(isTracadoCalculado()) {
            g.setColor(Color.RED);
            g.drawLine(pontosOrdenados.get(0).x,pontosOrdenados.get(0).y, pontosOrdenados.get(1).x,pontosOrdenados.get(1).y); //Po - Or
            g.drawLine(pontosOrdenados.get(2).x,pontosOrdenados.get(2).y, pontosOrdenados.get(3).x,pontosOrdenados.get(3).y); //N - Me
            g.drawLine(pontosOrdenados.get(4).x,pontosOrdenados.get(4).y, pontosOrdenados.get(3).x,pontosOrdenados.get(3).y); //Go- Me
            g.drawLine(pontosOrdenados.get(5).x,pontosOrdenados.get(5).y, pontosOrdenados.get(4).x,pontosOrdenados.get(4).y); //Go- Cd
            //prolongaRetasHorizontais(g, contentDisplay, pontosOrdenados.get(4), pontosOrdenados.get(3));
            //prolongaRetasHorizontais(g, contentDisplay, pontosOrdenados.get(1), pontosOrdenados.get(0));
            //prolongaRetasVerticais(g, contentDisplay, pontosOrdenados.get(2), pontosOrdenados.get(3));
        }
    }


    public void prolongaRetasHorizontais (Graphics g, ORSDisplayJAI painel, Point p1, Point p2) {

            double A1 = (double)(p2.y - p1.y)/(p2.x - p1.x);
            double B1 = (double) p2.y - (A1)*p2.x;

            int ymin = painel.getHeight();
            int xmax = painel.getWidth();
            int xmin = 0;

            int varx = (int) Math.round((ymin-B1)/A1);
            int vary = (int)Math.round(A1*xmin+B1);

            Point P1 = new Point (varx,ymin);
            Point P2 = new Point (xmin, vary);
            Point P3 = new Point();

            if (P1.getX() > xmin)
            {
                P3 = P2;
            }
            else
            {
                P3 = P1;
            }
           g.drawLine(p2.x,p2.y, P3.x, P3.y);

    }

     public void prolongaRetasVerticais (Graphics g, ORSDisplayJAI painel, Point p1, Point p2) {

        double A2 = (double)(p1.y - p2.y)/(p1.x - p2.x);
        double B2 = (double) p2.y - (A2)*p2.x;

        int ymin = 0;
        int xmin = 0;
        int ymax = painel.getHeight();

        int varx2 = (int) Math.round((ymax-B2)/A2);
        int vary2 = (int) Math.round(A2*xmin+B2);

        Point P4 = new Point (varx2,ymax);
        Point P5 = new Point (xmin, vary2);
        Point P6 = new Point();

        if (P4.getX() < ymin)
        {
            P6 = P5;
        }
        else
        {
            P6 = P4;
        }
       g.drawLine(p2.x, p2.y, P6.x, P6.y);


    }

    @Override
    public String gerarRelatorio() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


