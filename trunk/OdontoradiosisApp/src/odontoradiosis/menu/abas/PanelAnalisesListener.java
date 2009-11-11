
package odontoradiosis.menu.abas;

import java.util.EventListener;

/**
 *
 * @author Beto
 */
public interface PanelAnalisesListener extends EventListener {

    void iniciarMarcarPontos(PanelAnalisesEvent event);
    void marcarPonto(PanelAnalisesEvent event);
    void moverPontos(PanelAnalisesEvent event);
    void salvarPontos(PanelAnalisesEvent event);
    void cancelarMarcarPontos(PanelAnalisesEvent event);
    void gerarTracado(PanelAnalisesEvent event);

}
