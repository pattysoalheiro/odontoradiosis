
package odontoradiosis.model.analises;

import java.awt.Point;

/*
 *
 * @author ph
 */
public class Ponto extends Point {
    
    private String sigla;
    private String nome;
    
    public Ponto(String sigla, String nome, int x, int y) {
        super(x, y);
        this.sigla = sigla;
        this.nome = nome;
    }

    public Ponto(String sigla, String nome) {
        super();
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
