
package odontoradiosis.model.analises.relatorio;

import java.io.Serializable;

/**
 *
 * @author Beto
 */
public class MedidaBean implements Serializable {

    private String nome;
    private double valor;
    private String unidade;

    public MedidaBean(String nome, double valor, String unidade) {
        this.nome = nome;
        this.valor = valor;
        this.unidade = unidade;
    }

    public MedidaBean() {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
