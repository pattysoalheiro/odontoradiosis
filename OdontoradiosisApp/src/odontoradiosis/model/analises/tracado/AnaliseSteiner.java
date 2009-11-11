
package odontoradiosis.model.analises.tracado;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import odontoradiosis.model.analises.Ponto;
import odontoradiosis.view.pontos.AnaliseSettings;
import odontoradiosis.view.pontos.ORSDisplayJAI;

/**
 *
 */
public class AnaliseSteiner extends Tracado {

    private double coeficienteNA,  coeficienteNS,  coeficienteNB,  coeficienteND,  coeficienteSN,  coeficienteGoGn,  coeficiente1NA,  coeficientePO,  coeficiente1Or,  coeficiente1linhaD,  coeficiente1NB;
    private double valorSNA,  valorSNB,  valorANB,  valorSND;
    private double valorGoGnSn,  valor1NA,  valorSNPO,  valorIntercisal,  valor1NB;
    private double dPogNB,  distrealPogNB,  dSL,  distrealSL,  dSE,  distrealSE,  d1NA,  distRealNA,  distReal6NA,  d6NA,  distRealNB,  d1NB;
    private ORSDisplayJAI contentDisplay;

    public AnaliseSteiner(ArrayList<Ponto> pontos, int PCms, ORSDisplayJAI contentDisplay) {
        super(pontos, PCms);
        this.contentDisplay = contentDisplay;
    }

    @Override
    public void executarTracado() {
        pontosOrdenados.addAll(pontos);

        for (int i = 0; i < pontos.size(); i++) {
            Ponto ponto = pontos.get(i);

            if (ponto.getSigla().equals("N")) {
                pontosOrdenados.set(0, ponto);
            } else if (ponto.getSigla().equals("A")) {
                pontosOrdenados.set(1, ponto);
            } else if (ponto.getSigla().equals("B")) {
                pontosOrdenados.set(2, ponto);
            } else if (ponto.getSigla().equals("D")) {
                pontosOrdenados.set(3, ponto);
            } else if (ponto.getSigla().equals("S")) {
                pontosOrdenados.set(4, ponto);
            } else if (ponto.getSigla().equals("Go")) {
                pontosOrdenados.set(5, ponto);
            } else if (ponto.getSigla().equals("Gn")) {
                pontosOrdenados.set(6, ponto);
            } else if (ponto.getSigla().equals("PM1")) {
                pontosOrdenados.set(7, ponto);
            } else if (ponto.getSigla().equals("PM2")) {
                pontosOrdenados.set(8, ponto);
            } else if (ponto.getSigla().equals("PMx")) {
                pontosOrdenados.set(9, ponto);
            } else if (ponto.getSigla().equals("Me")) {
                pontosOrdenados.set(10, ponto);
            } else if (ponto.getSigla().equals("PontoMedioNasal")) {
                pontosOrdenados.set(11, ponto);
            } else if (ponto.getSigla().equals("Pn")) {
                pontosOrdenados.set(12, ponto);
            } else if (ponto.getSigla().equals("L")) {
                pontosOrdenados.set(13, ponto);
            } else if (ponto.getSigla().equals("E")) {
                pontosOrdenados.set(14, ponto);
            } else if (ponto.getSigla().equals("CMS")) {
                pontosOrdenados.set(15, ponto);
            } else if (ponto.getSigla().equals("CMI")) {
                pontosOrdenados.set(16, ponto);
            } else if (ponto.getSigla().equals("Or")) {
                pontosOrdenados.set(17, ponto);
            } else if (ponto.getSigla().equals("Ponto 1")) {
                pontosOrdenados.set(18, ponto);
            } else if (ponto.getSigla().equals("Ponto 6")) {
                pontosOrdenados.set(19, ponto);
            } else if (ponto.getSigla().equals("Po1")) {
                pontosOrdenados.set(20, ponto);
            } else if (ponto.getSigla().equals("Po2")) {
                pontosOrdenados.set(21, ponto);
            } else if (ponto.getSigla().equals("1'")) {
                pontosOrdenados.set(22, ponto);
            }
        }

        calculaDistancias();
        calculaAngulos();
    }

    private void calculaDistancias() {

        dPogNB = Math.sqrt(Math.pow(pontosOrdenados.get(0).y - pontosOrdenados.get(1).y, 2) + Math.pow(pontosOrdenados.get(0).x - pontosOrdenados.get(1).x, 2));
        dSL = Math.sqrt(Math.pow(pontosOrdenados.get(4).y - pontosOrdenados.get(13).y, 2) + Math.pow(pontosOrdenados.get(4).x - pontosOrdenados.get(13).x, 2));
        dSE = Math.sqrt(Math.pow(pontosOrdenados.get(4).y - pontosOrdenados.get(14).y, 2) + Math.pow(pontosOrdenados.get(4).x - pontosOrdenados.get(14).x, 2));
        d1NA = distRetaPonto(pontosOrdenados.get(0), pontosOrdenados.get(1), pontosOrdenados.get(18));
        d1NB = distRetaPonto(pontosOrdenados.get(0), pontosOrdenados.get(2), pontosOrdenados.get(22));
        d6NA = distRetaPonto(pontosOrdenados.get(0), pontosOrdenados.get(1), pontosOrdenados.get(19));

        distReal6NA = ((d6NA / PCms) * 2) * 10;
        distRealNA = ((d1NA / PCms) * 2) * 10;
        distrealPogNB = ((dPogNB / PCms) * 2) * 10;
        distrealSL = ((dSL / PCms) * 2) * 10;
        distrealSE = ((dSE / PCms) * 2) * 10;
        distRealNB = ((d1NB / PCms) * 2) * 10;

        System.out.println("-------------------------");
        System.out.println("Distância 6-NA " + distReal6NA + " mm");
        System.out.println("Distância 1-NA " + distRealNA + " mm");
        System.out.println("Distância 1'-NB " + distRealNB + " mm");
        System.out.println("Distância P-NB " + distrealPogNB + " mm");
        System.out.println("Distância S-L " + distrealSL + " mm");
        System.out.println("Distância S-E " + distrealSE + " mm");
        System.out.println("-------------------------");
    }

    private void calculaAngulos() {
        coeficienteNS = (double) (pontosOrdenados.get(4).y - pontosOrdenados.get(0).y) / (pontosOrdenados.get(4).x - pontosOrdenados.get(0).x); //SNA
        coeficienteNA = (double) (pontosOrdenados.get(1).y - pontosOrdenados.get(0).y) / (pontosOrdenados.get(1).x - pontosOrdenados.get(0).x);
        coeficienteNB = (double) (pontosOrdenados.get(2).y - pontosOrdenados.get(0).y) / (pontosOrdenados.get(2).x - pontosOrdenados.get(0).x);
        coeficienteND = (double) (pontosOrdenados.get(0).y - pontosOrdenados.get(3).y) / (pontosOrdenados.get(0).x - pontosOrdenados.get(3).x);
        coeficienteGoGn = (double) (pontosOrdenados.get(5).y - pontosOrdenados.get(6).y) / (pontosOrdenados.get(5).x - pontosOrdenados.get(6).x);
        coeficiente1NA = (double) (pontosOrdenados.get(18).y - pontosOrdenados.get(17).y) / (pontosOrdenados.get(18).x - pontosOrdenados.get(17).x);
        coeficientePO = (double) (pontosOrdenados.get(20).y - pontosOrdenados.get(21).y) / (pontosOrdenados.get(20).x - pontosOrdenados.get(21).x);
        coeficiente1Or = (double) (pontosOrdenados.get(17).y - pontosOrdenados.get(18).y) / (pontosOrdenados.get(17).x - pontosOrdenados.get(18).x);
        coeficiente1linhaD = (double) (pontosOrdenados.get(3).y - pontosOrdenados.get(22).y) / (pontosOrdenados.get(3).x - pontosOrdenados.get(22).x);
        coeficiente1NB = (double) (pontosOrdenados.get(17).y - pontosOrdenados.get(22).y) / (pontosOrdenados.get(17).x - pontosOrdenados.get(22).x);

        valor1NB = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeficienteSN))) - Math.toDegrees(Math.abs(Math.atan(coeficiente1NB)))); //SNPO
        valorIntercisal = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeficiente1linhaD))) - Math.toDegrees(Math.abs(Math.atan(coeficiente1Or)))); //SNPO
        valorSNPO = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeficienteNS))) - Math.toDegrees(Math.abs(Math.atan(coeficientePO)))); //SNPO
        valor1NA = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeficiente1NA))) - Math.toDegrees(Math.abs(Math.atan(coeficienteNA)))); //SNA
        valorSNA = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeficienteNA))) - Math.toDegrees(Math.abs(Math.atan(coeficienteNS)))); //SNA
        valorSNB = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeficienteNB))) - Math.toDegrees(Math.abs(Math.atan(coeficienteNS)))); //SNB
        valorSND = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeficienteND))) - Math.toDegrees(Math.abs(Math.atan(coeficienteNS)))); //SNB
        valorANB = valorSNA - valorSNB; //ANB
        valorGoGnSn = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeficienteGoGn))) - Math.toDegrees(Math.abs(Math.atan(coeficienteNS)))); //SNA;
    }

    @Override
    public void paintTracado(Graphics g) {

        float escala = AnaliseSettings.getInstance().getEscala();

        g.drawLine((int) (pontosOrdenados.get(0).x * escala), (int) (pontosOrdenados.get(0).y * escala), (int) (pontosOrdenados.get(1).x * escala), (int) (pontosOrdenados.get(1).y * escala)); //NA
        g.drawLine((int) (pontosOrdenados.get(0).x * escala), (int) (pontosOrdenados.get(0).y * escala), (int) (pontosOrdenados.get(2).x * escala), (int) (pontosOrdenados.get(2).y * escala)); //NB
        g.drawLine((int) (pontosOrdenados.get(0).x * escala), (int) (pontosOrdenados.get(0).y * escala), (int) (pontosOrdenados.get(3).x * escala), (int) (pontosOrdenados.get(3).y * escala)); //ND
        g.drawLine((int) (pontosOrdenados.get(0).x * escala), (int) (pontosOrdenados.get(0).y * escala), (int) (pontosOrdenados.get(4).x * escala), (int) (pontosOrdenados.get(4).y * escala)); //SN
        g.drawLine((int) (pontosOrdenados.get(5).x * escala), (int) (pontosOrdenados.get(5).y * escala), (int) (pontosOrdenados.get(6).x * escala), (int) (pontosOrdenados.get(6).y * escala)); //GoGn
        g.drawLine((int) (pontosOrdenados.get(7).x * escala), (int) (pontosOrdenados.get(7).y * escala), (int) (pontosOrdenados.get(8).x * escala), (int) (pontosOrdenados.get(8).y * escala)); //PM1-PM2
        g.drawLine((int) (pontosOrdenados.get(9).x * escala), (int) (pontosOrdenados.get(9).y * escala), (int) (pontosOrdenados.get(10).x * escala), (int) (pontosOrdenados.get(10).y * escala)); //PMx - Me
        g.drawLine((int) (pontosOrdenados.get(12).x * escala), (int) (pontosOrdenados.get(12).y * escala), (int) (pontosOrdenados.get(11).x * escala), (int) (pontosOrdenados.get(11).y * escala)); //PmédioNasal - PogMole
        g.drawLine((int) (pontosOrdenados.get(15).x * escala), (int) (pontosOrdenados.get(15).y * escala), (int) (pontosOrdenados.get(16).x * escala), (int) (pontosOrdenados.get(16).y * escala)); //S-L
        g.drawLine((int) (pontosOrdenados.get(20).x * escala), (int) (pontosOrdenados.get(20).y * escala), (int) (pontosOrdenados.get(21).x * escala), (int) (pontosOrdenados.get(21).y * escala));

        double AReta = (double) ((double) (pontosOrdenados.get(6).y - pontosOrdenados.get(5).y) / (pontosOrdenados.get(6).x - pontosOrdenados.get(5).x)); //A da Go-Gn
        double A = (double) ((double) (pontosOrdenados.get(4).y - pontosOrdenados.get(0).y) / (pontosOrdenados.get(4).x - pontosOrdenados.get(0).x)); //A da SN
        double B = (double) (pontosOrdenados.get(4).y - A * pontosOrdenados.get(4).x); //B da SN

        tracaRetaAngle(90, AReta, g);
        prolongaRetas(g);
        calculaAngulos();
        bissetriz(g);
        pontoAteReta(g, pontosOrdenados.get(18), pontosOrdenados.get(17), A, B);
        calculaDistancias();

        System.out.println("-------------------");
        System.out.println(valorSNA + " ângulo SNA");
        System.out.println(valorSNB + " ângulo SNB");
        System.out.println(valorANB + " ângulo ANB");
        System.out.println(valorSND + " ângulo SND");
        System.out.println(valorGoGnSn + " ângulo GoGnSn");
        System.out.println(valor1NA + " ângulo 1NA");
        System.out.println(valor1NB + " ângulo 1NB");
        System.out.println(valorSNPO + " ângulo SNPO");
        System.out.println(valorIntercisal + " ângulo Intercisal");
        System.out.println("-------------------");
    }

    @Override
    public String gerarRelatorio() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void bissetriz(Graphics g) {

        double coe1 = (double) (pontosOrdenados.get(8).y - pontosOrdenados.get(7).y) / (pontosOrdenados.get(8).x - pontosOrdenados.get(7).x);
        double coe2 = (double) (pontosOrdenados.get(10).y - pontosOrdenados.get(9).y) / (pontosOrdenados.get(10).x - pontosOrdenados.get(9).x);
        double angle = (double) (Math.abs(Math.toDegrees((Math.atan(coe2))) - Math.toDegrees((Math.atan(coe1)))));

        double A = (double) Math.tan((double) angle / 2 + (double) Math.atan(coe2));

        Point ponto = pontoComum(pontosOrdenados.get(7), pontosOrdenados.get(8), pontosOrdenados.get(9), pontosOrdenados.get(10));

        double Bbisse = Math.round((double) (ponto.y - A * ponto.x));
        Point ponto2 = new Point(300, (int) Math.round(A * 300 + Bbisse));



        g.drawLine(ponto.x, ponto.y, ponto2.x, ponto2.y); //NA

    }

    private void pontoAteReta(Graphics g, Point p1, Point p2, double A, double B) {

        double A1 = (double) ((double) (p2.y - p1.y) / (p2.x - p1.x));
        double B1 = (double) (p1.y - A1 * p1.x);

        Point ponto = pontoComum(A1, B1, A, B);

        g.drawLine(p1.x, p1.y, ponto.x, ponto.y);

    }

    private Point pontoComum(Point p1, Point p2, Point p3, Point p4) {

        Point ponto = new Point();

        double A1 = (double) ((double) (p2.y - p1.y) / (p2.x - p1.x));
        double A2 = (double) ((double) (p4.y - p3.y) / (p4.x - p3.x));

        double B1 = (double) (p1.y - A1 * p1.x);
        double B2 = (double) (p3.y - A2 * p3.x);

        ponto.x = (int) Math.round((double) (B2 - B1) / (A1 - A2));
        ponto.y = (int) Math.round((double) (A1 * ponto.x + B1));

        return ponto;
    }

    private Point pontoComum(Point p1, double A1, double A2, double B2) {

        Point ponto = new Point();

        double B1 = (double) (p1.y - A1 * p1.x);

        ponto.x = (int) Math.round((double) (B2 - B1) / (A1 - A2));
        ponto.y = (int) Math.round((double) (A1 * ponto.x + B1));
        return ponto;
    }

    private Point pontoComum(double A1, double B1, double A2, double B2) {

        Point ponto = new Point();

        ponto.x = (int) Math.round((double) (B2 - B1) / (A1 - A2));
        ponto.y = (int) Math.round((double) (A1 * ponto.x + B1));
        return ponto;
    }

    private int[] geraEqGeral(Point ponto1, Point ponto2) {

        int Cx = ponto1.x * ponto2.y - (ponto2.x * ponto1.y);
        int Bx = ponto1.x - ponto2.x;
        int Ax = ponto1.y - ponto2.y;

        int[] array = {Cx, Bx, Ax};

        return array;
    }

    private double distRetaPonto(Point p1, Point p2, Point ponto) {
        int[] Eq = geraEqGeral(p1, p2);

        double dist = Math.round(Math.abs(Eq[0] + Eq[1] * ponto.y + Eq[2] * ponto.x) / Math.sqrt(Math.pow(Eq[1], 2) + Math.pow(Eq[2], 2)));

        return dist;
    }

    private void tracaRetaAngle(int angle, double AReta, Graphics g) {

        double A2 = Math.atan(Math.tan(AReta) - 90);
        double B2 = (double) (pontosOrdenados.get(5).y - (double) AReta * pontosOrdenados.get(5).x);
        double B1 = (double) (pontosOrdenados.get(3).y - AReta * pontosOrdenados.get(3).x);

        Point ponto = pontoComum(pontosOrdenados.get(3), A2, AReta, B2);
        g.drawLine(pontosOrdenados.get(3).x, pontosOrdenados.get(3).y, ponto.x, ponto.y);
        
        contentDisplay.repaint();
    }

    private void prolongaRetas(Graphics g) {
        //prolongamento de um PM1 - PM2

        double A1 = (double) (pontosOrdenados.get(8).y - pontosOrdenados.get(7).y) / (pontosOrdenados.get(8).x - pontosOrdenados.get(7).x);
        double B1 = (double) pontosOrdenados.get(8).y - (A1) * pontosOrdenados.get(8).x;

        int ymin = contentDisplay.getHeight();
        int xmax = contentDisplay.getWidth();

        int varx = (int) Math.round((ymin - B1) / A1);
        int vary = (int) Math.round(A1 * xmax + B1);

        Point P1 = new Point(varx, ymin);
        Point P2 = new Point(xmax, vary);
        Point P3 = new Point();

        if (P1.getX() > xmax) {
            P3 = P2;
        } else {
            P3 = P1;
        }
        
        float escala = AnaliseSettings.getInstance().getEscala();
        
        g.drawLine((int) (pontosOrdenados.get(8).x * escala), (int) (pontosOrdenados.get(8).y * escala), (int) (P3.x * escala), (int) (P3.y * escala));


        double A2 = (double) (pontosOrdenados.get(9).y - pontosOrdenados.get(10).y) / (pontosOrdenados.get(9).x - pontosOrdenados.get(10).x);
        double B2 = (double) pontosOrdenados.get(10).y - (A2) * pontosOrdenados.get(10).x;

        int xmin = 0;
        int ymax = contentDisplay.getHeight();

        int varx2 = (int) Math.round((ymax - B2) / A2);
        int vary2 = (int) Math.round(A2 * xmin + B2);

        Point P4 = new Point(varx2, ymax);
        Point P5 = new Point(xmin, vary2);
        Point P6 = new Point();

        if (P4.getX() < ymin) {
            P6 = P5;
        } else {
            P6 = P4;
        }
        g.drawLine(pontosOrdenados.get(10).x, pontosOrdenados.get(10).y, P6.x, P6.y);

    }

}
