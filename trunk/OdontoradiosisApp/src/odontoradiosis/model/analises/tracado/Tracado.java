
package odontoradiosis.model.analises.tracado;

import java.awt.Graphics;
import java.util.ArrayList;
import odontoradiosis.model.analises.Ponto;

/**
 *
 * @author Beto
 */
public abstract class Tracado {

    protected ArrayList<Ponto> pontos, pontosOrdenados;
    protected int PCms;
    protected boolean tracadoCalculado;

    public Tracado(ArrayList<Ponto> pontos, int PCms) {
        this.pontos = pontos;
        this.PCms = PCms;
        this.tracadoCalculado = false;
        this.pontosOrdenados = new ArrayList<Ponto>();
    }

    public int getPCms() {
        return PCms;
    }

    public void setPCms(int PCms) {
        this.PCms = PCms;
    }

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }

    public boolean isTracadoCalculado() {
        return tracadoCalculado;
    }

    public void setTracadoCalculado(boolean tracadoCalculado) {
        this.tracadoCalculado = tracadoCalculado;
    }
    
    public abstract void executarTracado();
    public abstract void paintTracado(Graphics g);
    public abstract String gerarRelatorio();
    
}
