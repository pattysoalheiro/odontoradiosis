
package odontoradiosis.util;

/**
 *
 * @author beto
 */
import javax.media.jai.*;
import javax.media.jai.operator.*;

/**
 * Uma classe usada para mudar o tamanho da imagem sem perda de qualidade
 */
public class Resizer {

    public static PlanarImage resize(PlanarImage image, float scale) {

        InterpolationBilinear interp = new InterpolationBilinear();

        Float scalef = new Float(scale);
        Float zerof = new Float(0.0F);
        PlanarImage scaled = (PlanarImage) ScaleDescriptor
                .create( image,
                        scalef,
                        scalef,
                         zerof,
                         zerof,
                        interp,
                        null);
       

        return scaled;
    }
}
