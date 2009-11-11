package odontoradiosis.model.analises.tracado;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import odontoradiosis.model.analises.Ponto;
import odontoradiosis.model.analises.relatorio.MedidaBean;
import odontoradiosis.model.analises.relatorio.ReportFactory;
import odontoradiosis.view.pontos.AnaliseSettings;


public class AnaliseHarvold extends Tracado {

    private double dENAGn, dENAATM, dPgnATM;
    private double distrealENAATM, distrealPgnATM, distrealENAgn;


    public AnaliseHarvold(ArrayList<Ponto> pontos, int PCms) {
        super(pontos, PCms);
    }

    public void executarTracado() {
        // Organiza Pontos
        pontosOrdenados.addAll(pontos);

        for (int i = 0; i < pontos.size(); i++) {
            Ponto ponto = pontos.get(i);

            if(ponto.getSigla().equals("ENA"))
                pontosOrdenados.set(0, ponto);
            else if(ponto.getSigla().equals("Gn"))
                pontosOrdenados.set(1, ponto);
            else if(ponto.getSigla().equals("PGn"))
                pontosOrdenados.set(2, ponto);
            else if(ponto.getSigla().equals("ATM"))
                pontosOrdenados.set(3, ponto);
        }

        // Calcula Distancias
        dENAGn = Math.sqrt(Math.pow(pontosOrdenados.get(0).y - pontosOrdenados.get(1).y, 2) +
                Math.pow(pontosOrdenados.get(0).x - pontosOrdenados.get(1).x, 2));
        dENAATM = Math.sqrt(Math.pow(pontosOrdenados.get(0).y - pontosOrdenados.get(2).y, 2) +
                Math.pow(pontosOrdenados.get(0).x - pontosOrdenados.get(2).x, 2));
        dPgnATM = Math.sqrt(Math.pow(pontosOrdenados.get(3).y - pontosOrdenados.get(2).y, 2) +
                Math.pow(pontosOrdenados.get(3).x - pontosOrdenados.get(2).x, 2));

        distrealENAgn = ((dENAGn / PCms) * 2) * 10;
        distrealENAATM = ((dENAATM / PCms) * 2) * 10;
        distrealPgnATM = ((dPgnATM / PCms) * 2) * 10;

        this.tracadoCalculado = true;        
    }

    public String gerarRelatorio() {

        ReportFactory factory = new ReportFactory();
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(dfs);
        factory.addElement(new MedidaBean("Distância ENA-Gn", Double.parseDouble(decimalFormat.format(distrealENAgn)), "mm"));
        factory.addElement(new MedidaBean("Distância ENA-ATM", Double.parseDouble(decimalFormat.format(distrealENAATM)), "mm"));
        factory.addElement(new MedidaBean("Distância PGn-ATM", Double.parseDouble(decimalFormat.format(distrealPgnATM)), "mm"));

        return factory.createReportBean();
    }

    public void paintTracado(Graphics g) {

        if(isTracadoCalculado()) {
            float escala = AnaliseSettings.getInstance().getEscala();

            g.setColor(Color.RED);

            g.drawLine((int) (pontosOrdenados.get(0).x * escala), (int) (pontosOrdenados.get(0).y * escala),
                    (int) (pontosOrdenados.get(1).x * escala), (int) (pontosOrdenados.get(1).y * escala)); //ENA - Gn
            g.drawLine((int) (pontosOrdenados.get(0).x * escala), (int) (pontosOrdenados.get(0).y * escala),
                    (int) (pontosOrdenados.get(3).x * escala), (int) (pontosOrdenados.get(3).y * escala)); //ENA - ATM
            g.drawLine((int) (pontosOrdenados.get(3).x * escala), (int) (pontosOrdenados.get(3).y * escala),
                    (int) (pontosOrdenados.get(2).x * escala), (int) (pontosOrdenados.get(2).y * escala)); //ATM - Pgn
        }
    }    
}
