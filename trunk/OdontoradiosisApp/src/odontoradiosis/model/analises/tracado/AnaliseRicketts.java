//package odontoradiosis.model.analises.tracado;
//
//import java.awt.Graphics;
//import java.awt.Point;
//import java.util.LinkedList;
//import odontoradiosis.model.analises.Ponto;
//
///**
// *
// * @author ph
// */
//public class AnaliseRicketts {
//
//    private LinkedList<Ponto> pontosMarcados;
//    private double PCms;
//    private double EixoFacial;
//    private double coeBA_N;
//    private double coePt_Gn;
//    private double coeN_Pg;
//    private double coeOr_Po;
//    private double ProfundidadeFacial;
//    private double coeXi_Pm;
//    private double AlturaFacialTotal;
//    private double AlturaFacialInferior;
//    private double coeXi_ENA;
//    private double coeXi_DC;
//    private double ArcoMandibular;
//    private double coeN_A;
//    private double ProfundidadeMaxila;
//
//    public void tracaAnalise(LinkedList<Ponto> listaPontos, DisplayJAI2 painel, Graphics g) {
//        pontosMarcados = new LinkedList<Ponto>();
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("N")) {
//                pontosMarcados.add(listaPontos.get(i)); //0
//            }
//        }
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Or")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Po")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Ba")) {
//                pontosMarcados.add(listaPontos.get(i));//3
//            }
//        }
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Pt")) {
//                pontosMarcados.add(listaPontos.get(i));//4
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("ENA")) {
//                pontosMarcados.add(listaPontos.get(i));//5
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("ENP")) {
//                pontosMarcados.add(listaPontos.get(i));//6
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("A")) {
//                pontosMarcados.add(listaPontos.get(i));//7
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Pm")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Pg")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Me")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("EN")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("CL")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("LI")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("EM")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Go")) {
//                pontosMarcados.add(listaPontos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Gn")) {
//                pontosMarcados.add(listaPontos.get(i));//16
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("CC")) {
//                pontosMarcados.add(listaPontos.get(i)); //17
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("CF")) {
//                pontosMarcados.add(listaPontos.get(i)); //18
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("DC")) {
//                pontosMarcados.add(listaPontos.get(i)); //19
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("R1")) {
//                pontosMarcados.add(listaPontos.get(i)); //20
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("R2")) {
//                pontosMarcados.add(listaPontos.get(i)); //21
//            }
//        }
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("R3")) {
//                pontosMarcados.add(listaPontos.get(i)); //22
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("R4")) {
//                pontosMarcados.add(listaPontos.get(i)); //23
//            }
//        }
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("Xi")) {
//                pontosMarcados.add(listaPontos.get(i)); //24
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("AI_1")) {
//                pontosMarcados.add(listaPontos.get(i)); //25
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("AI_2")) {
//                pontosMarcados.add(listaPontos.get(i)); //26
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("RI_1")) {
//                pontosMarcados.add(listaPontos.get(i)); //27
//            }
//        }
//
//        for (int i = 0; i < listaPontos.size(); i++) {
//            if (listaPontos.get(i).getNome().equals("RI_2")) {
//                pontosMarcados.add(listaPontos.get(i)); //28
//            }
//        }
//
//        desenhaRetas(g, painel);
//    }
//
//    public void Bissetriz(Graphics g) {
//
//        double coe1 = (double) (pontosMarcados.get(8).y - pontosMarcados.get(7).y) / (pontosMarcados.get(8).x - pontosMarcados.get(7).x);
//        double coe2 = (double) (pontosMarcados.get(10).y - pontosMarcados.get(9).y) / (pontosMarcados.get(10).x - pontosMarcados.get(9).x);
//        double angle = (double) (Math.abs(Math.toDegrees((Math.atan(coe2))) - Math.toDegrees((Math.atan(coe1)))));
//
//        double A = (double) Math.tan((double) angle / 2 + (double) Math.atan(coe2));
//
//        Point ponto = pontoComum(pontosMarcados.get(7), pontosMarcados.get(8), pontosMarcados.get(9), pontosMarcados.get(10));
//
//        double Bbisse = Math.round((double) (ponto.y - A * ponto.x));
//        Point ponto2 = new Point(300, (int) Math.round(A * 300 + Bbisse));
//
//        g.drawLine(ponto.x, ponto.y, ponto2.x, ponto2.y); //NA
//
//    }
//
//    public void PontoAteReta(Graphics g, Point p1, Point p2, double A, double B) {
//
//        double A1 = (double) ((double) (p2.y - p1.y) / (p2.x - p1.x));
//        double B1 = (double) (p1.y - A1 * p1.x);
//
//        Point ponto = pontoComum(A1, B1, A, B);
//
//        g.drawLine(p1.x, p1.y, ponto.x, ponto.y);
//
//    }
//
//    public Point pontoComum(Point p1, Point p2, Point p3, Point p4) {
//        Point ponto = new Point();
//
//        double A1 = (double) ((double) (p2.y - p1.y) / (p2.x - p1.x));
//        double A2 = (double) ((double) (p4.y - p3.y) / (p4.x - p3.x));
//
//        double B1 = (double) (p1.y - A1 * p1.x);
//        double B2 = (double) (p3.y - A2 * p3.x);
//
//        ponto.x = (int) Math.round((double) (B2 - B1) / (A1 - A2));
//        ponto.y = (int) Math.round((double) (A1 * ponto.x + B1));
//
//        return ponto;
//    }
//
//    public Point pontoComum(Point p1, double A1, double A2, double B2) {
//        Point ponto = new Point();
//
//        double B1 = (double) (p1.y - A1 * p1.x);
//
//
//        ponto.x = (int) Math.round((double) (B2 - B1) / (A1 - A2));
//        ponto.y = (int) Math.round((double) (A1 * ponto.x + B1));
//        return ponto;
//    }
//
//    public Point pontoComum(double A1, double B1, double A2, double B2) {
//        Point ponto = new Point();
//
//        ponto.x = (int) Math.round((double) (B2 - B1) / (A1 - A2));
//        ponto.y = (int) Math.round((double) (A1 * ponto.x + B1));
//        return ponto;
//    }
//
//    public int[] geraEqGeral(Point ponto1, Point ponto2) {
//
//        int Cx = ponto1.x * ponto2.y - (ponto2.x * ponto1.y);
//        int Bx = ponto1.x - ponto2.x;
//        int Ax = ponto1.y - ponto2.y;
//
//        int[] array = {Cx, Bx, Ax};
//
//        return array;
//    }
//
//    public double distRetaPonto(Point p1, Point p2, Point ponto) {
//        int[] Eq = geraEqGeral(p1, p2);
//
//        double dist = Math.round(Math.abs(Eq[0] + Eq[1] * ponto.y + Eq[2] * ponto.x) / Math.sqrt(Math.pow(Eq[1], 2) + Math.pow(Eq[2], 2)));
//
//        return dist;
//    }
//
//    public void tracaRetaAngle(int angle, double AReta, Graphics g, DisplayJAI2 painel, Point point) {
//        double A2 = Math.atan(Math.tan(AReta) - 90);
//
//        double B2 = (double) (pontosMarcados.get(5).y - (double) AReta * pontosMarcados.get(5).x);
//
//        double B1 = (double) (pontosMarcados.get(3).y - AReta * pontosMarcados.get(3).x);
//
//        Point ponto = pontoComum(pontosMarcados.get(3), A2, AReta, B2);
//
//        g.drawLine(point.x, point.y, ponto.x, ponto.y);
//        painel.repaint();
//    }
//
//    public void prolongaRetasHorizontais(Graphics g, DisplayJAI2 painel, Point p1, Point p2) {
//
//        double A1 = (double) (p2.y - p1.y) / (p2.x - p1.x);
//        double B1 = (double) p2.y - (A1) * p2.x;
//
//        int ymin = painel.getHeight();
//        int xmax = painel.getWidth();
//        int xmin = 0;
//
//        int varx = (int) Math.round((ymin - B1) / A1);
//        int vary = (int) Math.round(A1 * xmin + B1);
//
//        Point P1 = new Point(varx, ymin);
//        Point P2 = new Point(xmin, vary);
//        Point P3 = new Point();
//
//        if (P1.getX() > xmin) {
//            P3 = P2;
//        } else {
//            P3 = P1;
//        }
//        g.drawLine(p2.x, p2.y, P3.x, P3.y);
//
//    }
//
//    public void prolongaRetasVerticais(Graphics g, DisplayJAI2 painel, Point p1, Point p2) {
//
//        double A2 = (double) (p1.y - p2.y) / (p1.x - p2.x);
//        double B2 = (double) p2.y - (A2) * p2.x;
//
//        int ymin = 0;
//        int xmin = 0;
//        int ymax = painel.getHeight();
//
//        int varx2 = (int) Math.round((ymax - B2) / A2);
//        int vary2 = (int) Math.round(A2 * xmin + B2);
//
//        Point P4 = new Point(varx2, ymax);
//        Point P5 = new Point(xmin, vary2);
//        Point P6 = new Point();
//
//        if (P4.getX() < ymin) {
//            P6 = P5;
//        } else {
//            P6 = P4;
//        }
//        g.drawLine(p2.x, p2.y, P6.x, P6.y);
//
//
//    }
//
//    public void setPCms(double PCms) {
//        this.PCms = PCms;
//    }
//
//    private void desenhaRetas(Graphics g, DisplayJAI2 painel) {
//        g.drawLine(pontosMarcados.get(2).x, pontosMarcados.get(2).y, pontosMarcados.get(1).x, pontosMarcados.get(1).y); //Po - Or
//        g.drawLine(pontosMarcados.get(0).x, pontosMarcados.get(0).y, pontosMarcados.get(3).x, pontosMarcados.get(3).y); //Ba - N
//        g.drawLine(pontosMarcados.get(0).x, pontosMarcados.get(0).y, pontosMarcados.get(9).x, pontosMarcados.get(9).y); //N-Pg
//        g.drawLine(pontosMarcados.get(11).x, pontosMarcados.get(11).y, pontosMarcados.get(14).x, pontosMarcados.get(14).y); //EN-EM
//        g.drawLine(pontosMarcados.get(4).x, pontosMarcados.get(4).y, pontosMarcados.get(16).x, pontosMarcados.get(16).y); //Pt-Gn
//        g.drawLine(pontosMarcados.get(7).x, pontosMarcados.get(7).y, pontosMarcados.get(9).x, pontosMarcados.get(9).y); //N-Pg
//        g.drawLine(pontosMarcados.get(19).x, pontosMarcados.get(19).y, pontosMarcados.get(24).x, pontosMarcados.get(24).y); //DC-Xi
//        g.drawLine(pontosMarcados.get(8).x, pontosMarcados.get(8).y, pontosMarcados.get(24).x, pontosMarcados.get(24).y); //Xi-Pm
//        g.drawLine(pontosMarcados.get(5).x, pontosMarcados.get(5).y, pontosMarcados.get(6).x, pontosMarcados.get(6).y); //ENA-ENP
//        g.drawLine(pontosMarcados.get(5).x, pontosMarcados.get(5).y, pontosMarcados.get(24).x, pontosMarcados.get(24).y); //ENA-Xi
//        g.drawLine(pontosMarcados.get(0).x, pontosMarcados.get(0).y, pontosMarcados.get(7).x, pontosMarcados.get(7).y); //N-Pg
//        g.drawLine(pontosMarcados.get(10).x, pontosMarcados.get(10).y, pontosMarcados.get(15).x, pontosMarcados.get(15).y); //Go-Me
//        g.drawLine(pontosMarcados.get(25).x, pontosMarcados.get(25).y, pontosMarcados.get(27).x, pontosMarcados.get(27).y); //AI_1-RI_1
//        g.drawLine(pontosMarcados.get(26).x, pontosMarcados.get(26).y, pontosMarcados.get(28).x, pontosMarcados.get(28).y); //AI_2-RI_2
//        g.drawLine(pontosMarcados.get(24).x, pontosMarcados.get(24).y, pontosMarcados.get(26).x, pontosMarcados.get(26).y); //Xi-AI_2
//    }
//
//    public void calculaDistancia() {
//        //convexidadedopontoA
//        //protrusãodoincisivoinferior
//    }
//
//    public void calculaAngulos() {
//        coeBA_N = (double) (pontosMarcados.get(0).y - pontosMarcados.get(3).y) / (pontosMarcados.get(0).x - pontosMarcados.get(3).x);
//        coePt_Gn = (double) (pontosMarcados.get(4).y - pontosMarcados.get(16).y) / (pontosMarcados.get(4).x - pontosMarcados.get(16).x);
//        coeN_Pg = (double) (pontosMarcados.get(0).y - pontosMarcados.get(9).y) / (pontosMarcados.get(0).x - pontosMarcados.get(9).x);
//        coeOr_Po = (double) (pontosMarcados.get(2).y - pontosMarcados.get(1).y) / (pontosMarcados.get(2).x - pontosMarcados.get(1).x);
//        coeXi_Pm = (double) (pontosMarcados.get(8).y - pontosMarcados.get(24).y) / (pontosMarcados.get(8).x - pontosMarcados.get(24).x);
//        coeXi_ENA = (double) (pontosMarcados.get(5).y - pontosMarcados.get(24).y) / (pontosMarcados.get(5).x - pontosMarcados.get(24).x);
//        coeXi_DC = (double) (pontosMarcados.get(19).y - pontosMarcados.get(24).y) / (pontosMarcados.get(19).x - pontosMarcados.get(24).x);
//        coeN_A = (double) (pontosMarcados.get(0).y - pontosMarcados.get(7).y) / (pontosMarcados.get(0).x - pontosMarcados.get(7).x);
//
//
//        EixoFacial = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeBA_N))) - Math.toDegrees(Math.abs(Math.atan(coePt_Gn))));
//        ProfundidadeFacial = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeN_Pg))) - Math.toDegrees(Math.abs(Math.atan(coeOr_Po))));
//        AlturaFacialTotal = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeBA_N))) - Math.toDegrees(Math.abs(Math.atan(coeXi_Pm))));
//        //planoMandibular
//        AlturaFacialInferior = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeXi_ENA))) - Math.toDegrees(Math.abs(Math.atan(coeXi_Pm))));
//        ArcoMandibular = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeXi_Pm))) - Math.toDegrees(Math.abs(Math.atan(coeXi_DC))));
//        ProfundidadeMaxila = Math.abs(Math.toDegrees(Math.abs(Math.atan(coeN_A))) - Math.toDegrees(Math.abs(Math.atan(coeOr_Po))));
//
//
//
//        System.out.println("---------------------------");
//        System.out.println("---------MANDÍBULA---------");
//
//        System.out.println("---------------------------");
//        System.out.println("----------MAXILA-----------");
//
//        System.out.println("---------------------------");
//        System.out.println("----------DENTES-----------");
//
//        System.out.println("---------------------------");
//    }
//}
