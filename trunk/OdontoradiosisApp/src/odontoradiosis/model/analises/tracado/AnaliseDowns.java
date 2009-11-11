
package odontoradiosis.model.analises.tracado;

import java.awt.Graphics;
import java.util.LinkedList;
import odontoradiosis.model.analises.Ponto;
import odontoradiosis.view.pontos.ORSDisplayJAI;

/**
 *
 * @author luiz
 */
public class AnaliseDowns {

    private double valorPoPontoPog;
    private double coeficientePontoPog;
    private double coeficientePoPonto;
    private Ponto point;
    private LinkedList<Ponto> pontosMarcados;
    private int b;
    private int a;
    private double angular;
    private int b1;
    private int a1;
    private double angular2;
    private int x;
    private int y;
    private double linear;
    private double teste;
    private double linear2;
    private int coeficienteNA;
    private int coeficienteNPog;
    private double valorNAPog;
    private double angularPoOr;
    private double linearPoOr;
    private double angularNPog;
    private double linearNpog;
    private double angularAB;
    private double linearAB;
    private int x1;
    private int y1;
    private int a2;
    private int b2;
    private int b3;
    private double angularNPog2;
    private double linearNpog2;
    private int a3;
    private int coeficienteNPonto;
    private int coeficientePontoA;
    private double valorPoABNPog;


    public void tracaAnalise(LinkedList<Ponto> listaPontos, ORSDisplayJAI painel, Graphics g) {

        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("S")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }

        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("N")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }

        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("Or")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }

        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("Po")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }

        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("A")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }
        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("B")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }
        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("Gn")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }

        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("Me")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }
        for (int i = 0; i < listaPontos.size(); i++) {
            if (listaPontos.get(i).getNome().equals("Pog")) {
                pontosMarcados.add(listaPontos.get(i));
            }
        }

//          // Cálculo do angulo facial

        a = (pontosMarcados.get(2).y - pontosMarcados.get(3).y);
        b = (pontosMarcados.get(2).x - pontosMarcados.get(3).x);

        angularPoOr = (double) a / b;
        linearPoOr = (double) (pontosMarcados.get(3).y - (angularPoOr * pontosMarcados.get(3).x));

        a1 = (pontosMarcados.get(8).y - pontosMarcados.get(1).y);
        b1 = (pontosMarcados.get(8).x - pontosMarcados.get(1).x);

        angularNPog = (double) a1 / b1;
        linearNpog = (double) (pontosMarcados.get(8).y - (angularNPog * pontosMarcados.get(8).x));

        x = (int) ((linearPoOr - linearNpog) / (-angularPoOr - (-angularNPog)));
        y = (int) (angularPoOr * x + linearPoOr);

        // Ângulo do PLano A-B

        a2 = (pontosMarcados.get(4).y - pontosMarcados.get(5).y);
        b2 = (pontosMarcados.get(4).x - pontosMarcados.get(5).x);

        angularAB = (double) a2 / b2;
        linearAB = (double) (pontosMarcados.get(5).y - (angularAB * pontosMarcados.get(5).x));

        x1 = (int) ((linearAB - linearNpog) / (-angularAB - (-angularNPog)));
        y1 = (int) (angularAB * x1 + linearAB);
//////////////////////////////////////////////////////////////////////////////////////////////////

        coeficientePoPonto = (pontosMarcados.get(3).y - y) / (pontosMarcados.get(3).x - x);
        coeficientePontoPog = (pontosMarcados.get(8).y - y) / (pontosMarcados.get(8).x - x);

        coeficienteNPonto = (pontosMarcados.get(1).y - y1) / (pontosMarcados.get(1).x - x1);
        coeficientePontoA = (pontosMarcados.get(4).y - y1) / (pontosMarcados.get(4).x - x1);

        coeficienteNA = (pontosMarcados.get(1).y - pontosMarcados.get(4).y) / (pontosMarcados.get(1).x - pontosMarcados.get(4).x);
        coeficienteNPog = (pontosMarcados.get(8).y - pontosMarcados.get(4).y) / (pontosMarcados.get(8).x - pontosMarcados.get(4).x);

        valorPoPontoPog = Math.toDegrees(Math.abs(Math.atan(coeficientePoPonto))) + Math.toDegrees(Math.abs(Math.atan(coeficientePontoPog))); // ângulo facial
        valorNAPog = 90 - (Math.toDegrees(Math.abs(Math.atan(coeficienteNA))) + Math.toDegrees(Math.abs(Math.atan(coeficienteNPog)))) / 2;
        valorPoABNPog = -(90 - (Math.toDegrees(Math.abs(Math.atan(coeficienteNPonto))) + Math.toDegrees(Math.abs(Math.atan(coeficientePontoA)))) / 2);


        System.out.println("Valor do angulo PoPontoPog: " + valorPoPontoPog);
        System.out.println("Valor do angulo NAPog: " + valorNAPog);
        System.out.println("Valor do angulo AB-NPog: " + valorPoABNPog);

        g.fillOval(x, y, 6, 6);
        g.fillOval(x1, y1, 6, 6);

        g.drawLine(pontosMarcados.get(3).x, pontosMarcados.get(3).y, pontosMarcados.get(2).x, pontosMarcados.get(2).y); //Po-Or
        g.drawLine(pontosMarcados.get(8).x, pontosMarcados.get(8).y, pontosMarcados.get(1).x, pontosMarcados.get(1).y); //Plano facial (N-Pog)
        g.drawLine(pontosMarcados.get(0).x, pontosMarcados.get(0).y, pontosMarcados.get(6).x, pontosMarcados.get(6).y); // Eixo Y (S-Gn)
        g.drawLine(pontosMarcados.get(1).x, pontosMarcados.get(1).y, pontosMarcados.get(4).x, pontosMarcados.get(4).y); //N-A
        g.drawLine(pontosMarcados.get(4).x, pontosMarcados.get(4).y, pontosMarcados.get(8).x, pontosMarcados.get(8).y); //A-Pog
        g.drawLine(pontosMarcados.get(4).x, pontosMarcados.get(4).y, pontosMarcados.get(5).x, pontosMarcados.get(5).y); //A-B

    }

    public void calculaDistancia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void calculaAngulos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
