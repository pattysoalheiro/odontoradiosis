
package odontoradiosis.model.effects;

import java.util.EventListener;

/**
 *
 * @author Beto
 */
public interface LupeSettingsListener extends EventListener {

    public void atualizarImagemLupa(LupeSettingsEvent evt);

}
