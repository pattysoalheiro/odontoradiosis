
package odontoradiosis.menu.abas;

import java.util.EventObject;
import odontoradiosis.model.analises.Ponto;

/**
 *
 * @author Beto
 */
public class PanelAnalisesEvent extends EventObject {

    private String  nomeAnalise;
    
    private Ponto   ponto;
    private boolean marcacaoAtiva;
    private boolean moverAtivo;

    public PanelAnalisesEvent(PanelAnalises source) {
        super(source);
    }

    public PanelAnalisesEvent(PanelAnalises source, boolean marcacaoAtiva, Ponto ponto) {
        super(source);
        this.marcacaoAtiva = marcacaoAtiva;
        this.ponto = ponto;
    }

    public PanelAnalisesEvent(PanelAnalises source, String nomeAnalise) {
        super(source);
        this.nomeAnalise = nomeAnalise;
    }

    public PanelAnalisesEvent(Object source, boolean moverAtivo) {
        super(source);
        this.moverAtivo = moverAtivo;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public boolean isMarcacaoAtiva() {
        return marcacaoAtiva;
    }

    public void setMarcacaoAtiva(boolean marcacaoAtiva) {
        this.marcacaoAtiva = marcacaoAtiva;
    }

    public boolean isMoverAtivo() {
        return moverAtivo;
    }

    public void setMoverAtivo(boolean moverAtivo) {
        this.moverAtivo = moverAtivo;
    }
        
    public String getNomeAnalise() {
        return nomeAnalise;
    }

    public void setNomeAnalise(String nomeAnalise) {
        this.nomeAnalise = nomeAnalise;
    }
    
}
