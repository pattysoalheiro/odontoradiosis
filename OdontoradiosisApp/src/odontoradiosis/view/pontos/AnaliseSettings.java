
package odontoradiosis.view.pontos;

import odontoradiosis.model.analises.Analise;

/**
 *
 * @author Beto
 */
public class AnaliseSettings {

    private static AnaliseSettings instance;
    private Analise analise;
    private float escala;

    private AnaliseSettings() {

    }

    public static AnaliseSettings getInstance() {
        if(instance == null)
            instance = new AnaliseSettings();
        return instance;
    }

    public float getEscala() {
        return escala;
    }

    public void setEscala(float escala) {
        this.escala = escala;
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }
    
}
