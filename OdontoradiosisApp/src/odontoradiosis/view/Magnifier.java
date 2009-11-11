
package odontoradiosis.view;

/**
 *
 * @author Beto
 */
import odontoradiosis.model.effects.LupeSettingsListener;
import odontoradiosis.model.effects.LupeSettingsEvent;
import odontoradiosis.model.effects.LupeSettings;
import com.sun.media.jai.widget.DisplayJAI;
import java.awt.*;
import java.awt.image.renderable.*;
import java.awt.event.*;
import javax.media.jai.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import odontoradiosis.model.effects.Contrast;
import odontoradiosis.model.effects.Effects;
import odontoradiosis.util.Resizer;

/**
 * An output widget used as a magnifing glass derived from
 * javax.swing.JComponent, and can be used in any context
 * that calls for a JComponent.
 *
 * @author Dennis Sigel
 */
public class Magnifier extends JComponent implements LupeSettingsListener {

    private final Image lenteBG = new ImageIcon(getClass().
            getResource("/odontoradiosis/resources/lenteBG.png")).getImage();
    
    private PlanarImage image;
    private DisplayJAI parent = null;
    private DisplayJAI display_out = null;
    private float magnification;
    private LupeSettings magnLupeSettings;
    private int width, heigth;

    public Magnifier() {
        setOpaque(true);
        setLocation(0, 0);
        setBorder(new LineBorder(Color.white, 2));
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());        
    }

    public void setSource(DisplayJAI parent) {
        this.parent = parent;
        parent.addMouseListener(new MouseClickHandler());
        parent.addMouseMotionListener(new MouseMotionHandler());
        
        image = (PlanarImage) parent.getSource();
    }

    public void setDisplay(JComponent display) {
        if ( display instanceof DisplayJAI ) {
            this.display_out = (DisplayJAI) display;
            width = display_out.getWidth();
            heigth = display_out.getHeight();
        }
    }

    public synchronized void setMagnification(float f) {

        if (f < 0.005)
            magnification = 0.005F;

        else
            magnification = f;

        int w = (int) ((float) width / magnification) + 4;
        int h = (int) ((float) heigth / magnification) + 4;
        setSize(w, h);
        repaint();
    }


    public PlanarImage cropAndResizeImage() {

        PlanarImage croppedImg = null;
        Insets insets = parent.getInsets();
        Dimension lupeSize;

        if (image != null) {
            Point p = getLocation();
            lupeSize = getSize();

            int w = (int) getWidth();
            int h = (int) getHeight();
            int x = 0, y = 0;

            if ((parent.getWidth() == image.getWidth()) && (parent.getHeight() == image.getHeight())) {
                x = p.x + (lupeSize.width - w) / 2 - insets.left;
                y = p.y + (lupeSize.height - h) / 2 - insets.top;
            }

            else {
                x = p.x - (parent.getWidth() - image.getWidth()) / 2;
                y = p.y - (parent.getHeight() - image.getHeight()) / 2;
            }

            if (x < 0)
                x = 0;

            if (y < 0)
                y = 0;

            if ((x + w) > image.getWidth())
                w = image.getWidth() - x;

            if ((y + h) > image.getHeight())
                h = image.getHeight() - y;

            ParameterBlock pb = new ParameterBlock();
            pb.addSource(image);
            pb.add((float) x);
            pb.add((float) y);
            pb.add((float) w);
            pb.add((float) h);
            croppedImg = JAI.create("crop", pb, null);

            pb.removeParameters();
            pb.removeSources();
            pb.addSource(croppedImg);
            pb.add((float) -x);
            pb.add((float) -y);
            croppedImg = JAI.create("translate", pb, null);

            croppedImg = Resizer.resize(croppedImg, magnification);           
        }

        return croppedImg;
    }


    /**
     * Paint the image onto a Graphics object.  The painting is
     * performed tile-by-tile, and includes a grey region covering the
     * unused portion of image tiles as well as the general
     * background.
     */
    public synchronized void paintComponent(Graphics g) {

        Graphics2D g2D = null;
        if (g instanceof Graphics2D) {
            g2D = (Graphics2D)g;
        } else {
            System.err.println("not a Graphic2D");
            return;
        }
        
        g.drawImage(lenteBG, 0, 0, getWidth(), getHeight(), null);
        
        PlanarImage croppedImg = cropAndResizeImage();

        // APLICAR EFEITOS
        if(magnLupeSettings != null) {

            setMagnification(magnLupeSettings.getMagnificationValue());
            parent.repaint();
            
            if(magnLupeSettings.isBinarizationActived()) {
                croppedImg = Effects.binarization(croppedImg, magnLupeSettings.getLimiarAtualValue());
            }
            else {
                if(magnLupeSettings.isEqualizationActived())
                    croppedImg = Effects.equalization(croppedImg);
                if(magnLupeSettings.isBorderActived())
                    croppedImg = Effects.borderDetection(croppedImg);
                if(magnLupeSettings.isNegativeActived())
                    croppedImg = Effects.negative(croppedImg);

                croppedImg = Effects.modifyBrightness(croppedImg,
                        magnLupeSettings.getBrightnessValue());
                croppedImg = Contrast.imageContrast(croppedImg, magnLupeSettings.getLimiarAtualValue(),
                        (float) magnLupeSettings.getFatorContrastValue());
            }
        }
        
        display_out.set(croppedImg);        
    }

    public void atualizarImagemLupa(LupeSettingsEvent evt) {

        magnLupeSettings = (LupeSettings) evt.getSource();
        repaint();
    }

    // moves the slider box
    class MouseClickHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            
            int mods = e.getModifiers();
            Point p = e.getPoint();
            
            if ((mods & InputEvent.BUTTON1_MASK) != 0)
                moveit(p.x, p.y);
        }        
    }

    class MouseMotionHandler extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            
            Point p = e.getPoint();
            int mods = e.getModifiers();

            if ((mods & InputEvent.BUTTON1_MASK) != 0)
                moveit(p.x, p.y);
        }
    }

    private final void moveit(int px, int py) {

        Insets inset = parent.getInsets();
        Dimension dm = getSize();
        Dimension dp = new Dimension(image.getWidth(), image.getHeight());

        int pw = dm.width / 2;
        int ph = dm.height / 2;
        int x = px - pw;
        int y = py - ph;

        if (px < inset.left + pw) x = inset.left;
        if (py < inset.top + ph) y = inset.top;
        if (px >= (dp.width - pw - inset.right)) x = dp.width - 2 * pw - inset.right;
        if (py >= (dp.height - ph - inset.bottom)) y = dp.height - 2 * ph - inset.bottom;

        setLocation(x, y);
        
        if(magnLupeSettings != null)
            magnLupeSettings.setPontoAtual(this.getLocation());
    }
    
}
