
package odontoradiosis.model.analises;

import java.util.ArrayList;

/** 
 * Esta classe é responsável por guardar em um ArrayList os nomes dos pontos
 * das análises a serem feitas e o nome da própria análise.
 */

public class Analise {

    private String nomeAnalise;
    private ArrayList<Ponto> conjuntoPontos;

    public Analise(String nomeAnalise) {
        conjuntoPontos = new ArrayList<Ponto>();
        this.nomeAnalise = nomeAnalise;
    }

    public String getNomeAnalise() {
        return nomeAnalise;
    }

    public ArrayList<Ponto> getPontos() {
        return conjuntoPontos;
    }

    public void setConjuntoPontos(ArrayList<Ponto> conjuntoPontos) {
        this.conjuntoPontos = conjuntoPontos;
    }
}