
package odontoradiosis.view.pontos;

import java.util.EventListener;

/**
 *
 * @author Beto
 */
public interface ORSDisplayListener extends EventListener {

    void marcouPonto(ORSDisplayEvent event);
    void cancelouAnalise(ORSDisplayEvent event);


}
