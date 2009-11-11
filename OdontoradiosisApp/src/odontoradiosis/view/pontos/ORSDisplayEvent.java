
package odontoradiosis.view.pontos;

import java.util.EventObject;
import odontoradiosis.model.analises.Ponto;

/**
 *
 * @author Beto
 */
public class ORSDisplayEvent extends EventObject {

    private Ponto ponto;

    public ORSDisplayEvent(ORSDisplayJAI source) {
        super(source);
    }

    public ORSDisplayEvent(ORSDisplayJAI source, Ponto ponto) {
        super(source);
        this.ponto = ponto;
    }

    public Ponto getPonto() {
        return ponto;
    }
    
}
