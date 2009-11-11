
/*
 * LupaInternalFrame.java
 *
 * Created on 23/07/2009, 09:57:27
 */

package odontoradiosis.view;

import com.sun.media.jai.widget.DisplayJAI;
import javax.swing.JInternalFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Beto
 */
public class LupaInternalFrame extends JInternalFrame {
    
    public LupaInternalFrame() {
        initComponents();
    }

    public DisplayJAI getDisplayImage() {
        return displayImage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sliderMagnification = new javax.swing.JSlider();
        displayImage = new com.sun.media.jai.widget.DisplayJAI();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lupa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Imagem da Lupa  ", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Zoom:");
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel3.add(jLabel1, java.awt.BorderLayout.WEST);

        sliderMagnification.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sliderMagnification.setMajorTickSpacing(1);
        sliderMagnification.setMaximum(4);
        sliderMagnification.setMinimum(2);
        sliderMagnification.setMinorTickSpacing(1);
        sliderMagnification.setPaintLabels(true);
        sliderMagnification.setSnapToTicks(true);
        sliderMagnification.setToolTipText("Mudar o zoom da Lupa");
        sliderMagnification.setValue(0);
        sliderMagnification.setFocusable(false);
        sliderMagnification.setPreferredSize(new java.awt.Dimension(150, 30));
        sliderMagnification.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderMagnificationStateChanged(evt);
            }
        });
        jPanel3.add(sliderMagnification, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        displayImage.setBackground(new java.awt.Color(255, 255, 255));
        displayImage.setMaximumSize(new java.awt.Dimension(300, 300));
        displayImage.setMinimumSize(new java.awt.Dimension(300, 300));
        displayImage.setPreferredSize(new java.awt.Dimension(300, 300));
        displayImage.setLayout(new java.awt.BorderLayout());
        jPanel1.add(displayImage, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderMagnificationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderMagnificationStateChanged
        sliderMagnificationAction(evt);
    }//GEN-LAST:event_sliderMagnificationStateChanged

    protected void sliderMagnificationAction(ChangeEvent evt) {    }

    public JSlider getSliderMagnification() {
        return sliderMagnification;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.sun.media.jai.widget.DisplayJAI displayImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider sliderMagnification;
    // End of variables declaration//GEN-END:variables
   
}
