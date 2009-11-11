
package odontoradiosis.model.analises;

import java.util.ArrayList;

/**
 * Esta classe é a responsável pela conversão do xml para objeto.
 * Ela se resume em um ArrayList do tipo da classe AnalisesdePontos para que no fim,
 * após a deserialização do Xml tenhamos um objeto que se restringe a um arraylist
 * de fácil leitura e manipulação
 */

public class AnalisesJuntas {

    ArrayList<Analise> analisesPontos;

    public AnalisesJuntas() {
        analisesPontos = new ArrayList<Analise>();
    }

    public int getNumAnalises() {
        return this.analisesPontos.size();
    }

    public Analise getAnalise(int index) {
        if (index < this.analisesPontos.size()) {
            return this.analisesPontos.get(index);
        } else {
            return null;
        }
    }

    public Analise getAnalise(String nomeAnalise) {
        for(int i = 0; i < analisesPontos.size(); i++)
            if(analisesPontos.get(i).getNomeAnalise().equals(nomeAnalise))
                return analisesPontos.get(i);

        return null;
    }

    public void setAnalisesPontos(ArrayList<Analise> analisesPontos) {
        this.analisesPontos = analisesPontos;
    }

    public ArrayList<Analise> getAnalisesPontos() {
        return analisesPontos;
    }
}
