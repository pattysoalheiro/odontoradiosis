/*
 * PanelLupa.java
 *
 * Created on 07/07/2009, 10:13:06
 */

package odontoradiosis.menu.abas;

import com.sun.media.jai.widget.DisplayJAI;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.MouseInputAdapter;
import odontoradiosis.model.effects.LupeSettings;

/**
 *
 * @author Beto
 */
public class PanelLupa extends JPanel implements PanelAnalisesListener {

    private LupeSettings lupeSettings;
    private MarcarPontoListener marcarPontoListener;
    private int oldLimiarValue;

    public PanelLupa(LupeSettings lupeSettings) {
        initComponents();
        this.lupeSettings = lupeSettings;
        this.marcarPontoListener = new MarcarPontoListener();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sliderMagnification = new javax.swing.JSlider();
        displayImage = new com.sun.media.jai.widget.DisplayJAI();
        jTaskPaneGroup1 = new com.l2fprod.common.swing.JTaskPaneGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        limiarSlider = new javax.swing.JSlider();
        limiarSpinner = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        brightnessSlider = new javax.swing.JSlider();
        brightnessSpinner = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        contrastSlider = new javax.swing.JSlider();
        contrastSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jTaskPaneGroup2 = new com.l2fprod.common.swing.JTaskPaneGroup();
        jPanel6 = new javax.swing.JPanel();
        negativeEffectButton = new javax.swing.JToggleButton();
        borderEffectButton = new javax.swing.JToggleButton();
        equalizeEffectButton = new javax.swing.JToggleButton();
        binarizeEffectButton = new javax.swing.JToggleButton();

        jXTitledPanel1.setBackground(new java.awt.Color(234, 233, 237));
        jXTitledPanel1.setTitle(" Tratamento de Imagem");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 1, 11));
        jXTitledPanel1.setBorder(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Imagem da Lupa  ", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Zoom:");
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel5.add(jLabel1, java.awt.BorderLayout.WEST);

        sliderMagnification.setFont(new java.awt.Font("Tahoma", 1, 11));
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
        jPanel5.add(sliderMagnification, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

        displayImage.setBackground(new java.awt.Color(255, 255, 255));
        displayImage.setMaximumSize(new java.awt.Dimension(300, 300));
        displayImage.setMinimumSize(new java.awt.Dimension(300, 300));
        displayImage.setLayout(new java.awt.BorderLayout());
        jPanel1.add(displayImage, java.awt.BorderLayout.CENTER);

        jTaskPaneGroup1.setCollapsable(false);
        jTaskPaneGroup1.setTitle("Brilho e Contraste");
        jTaskPaneGroup1.setFont(new java.awt.Font("Tahoma", 1, 12));
        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setGap(4);
        percentLayout1.setOrientation(1);
        jTaskPaneGroup1.getContentPane().setLayout(percentLayout1);

        jPanel2.setPreferredSize(new java.awt.Dimension(258, 25));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(" Limiar  ");
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 14));
        jPanel2.add(jLabel2, java.awt.BorderLayout.WEST);

        limiarSlider.setMinimum(-100);
        limiarSlider.setValue(0);
        limiarSlider.setPreferredSize(new java.awt.Dimension(220, 25));
        limiarSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                limiarSliderStateChanged(evt);
            }
        });
        jPanel2.add(limiarSlider, java.awt.BorderLayout.CENTER);

        limiarSpinner.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limiarSpinner.setPreferredSize(new java.awt.Dimension(50, 18));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, limiarSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), limiarSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel2.add(limiarSpinner, java.awt.BorderLayout.EAST);

        jTaskPaneGroup1.getContentPane().add(jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(258, 25));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText(" Brilho  ");
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 14));
        jPanel3.add(jLabel3, java.awt.BorderLayout.WEST);

        brightnessSlider.setMajorTickSpacing(1);
        brightnessSlider.setMinimum(-100);
        brightnessSlider.setMinorTickSpacing(1);
        brightnessSlider.setSnapToTicks(true);
        brightnessSlider.setValue(0);
        brightnessSlider.setPreferredSize(new java.awt.Dimension(220, 25));
        brightnessSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brightnessSliderStateChanged(evt);
            }
        });
        jPanel3.add(brightnessSlider, java.awt.BorderLayout.CENTER);

        brightnessSpinner.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        brightnessSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -100, 100, 1));
        brightnessSpinner.setPreferredSize(new java.awt.Dimension(50, 18));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, brightnessSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), brightnessSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel3.add(brightnessSpinner, java.awt.BorderLayout.EAST);

        jTaskPaneGroup1.getContentPane().add(jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(258, 25));
        jPanel4.setLayout(new java.awt.BorderLayout());

        contrastSlider.setMajorTickSpacing(1);
        contrastSlider.setMinimum(-100);
        contrastSlider.setMinorTickSpacing(1);
        contrastSlider.setValue(0);
        contrastSlider.setPreferredSize(new java.awt.Dimension(220, 25));
        contrastSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                contrastSliderStateChanged(evt);
            }
        });
        jPanel4.add(contrastSlider, java.awt.BorderLayout.CENTER);

        contrastSpinner.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        contrastSpinner.setModel(new javax.swing.SpinnerNumberModel(0, -100, 100, 1));
        contrastSpinner.setPreferredSize(new java.awt.Dimension(50, 18));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, contrastSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), contrastSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel4.add(contrastSpinner, java.awt.BorderLayout.EAST);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText(" Contraste");
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 14));
        jPanel4.add(jLabel4, java.awt.BorderLayout.WEST);

        jTaskPaneGroup1.getContentPane().add(jPanel4);

        jTaskPaneGroup2.setCollapsable(false);
        jTaskPaneGroup2.setTitle("Efeitos");
        jTaskPaneGroup2.setFont(new java.awt.Font("Tahoma", 1, 12));
        com.l2fprod.common.swing.PercentLayout percentLayout2 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout2.setGap(2);
        percentLayout2.setOrientation(1);
        jTaskPaneGroup2.getContentPane().setLayout(percentLayout2);

        jPanel6.setPreferredSize(new java.awt.Dimension(294, 60));
        jPanel6.setLayout(new java.awt.GridLayout(1, 4, 4, 5));

        negativeEffectButton.setFont(new java.awt.Font("Tahoma", 0, 10));
        negativeEffectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/efeito_negativo.PNG"))); // NOI18N
        negativeEffectButton.setText("Negativo");
        negativeEffectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        negativeEffectButton.setIconTextGap(2);
        negativeEffectButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        negativeEffectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        negativeEffectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativeEffectButtonActionPerformed(evt);
            }
        });
        jPanel6.add(negativeEffectButton);

        borderEffectButton.setFont(new java.awt.Font("Tahoma", 0, 10));
        borderEffectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/efeito_bordas.PNG"))); // NOI18N
        borderEffectButton.setText("Bordas");
        borderEffectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borderEffectButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        borderEffectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borderEffectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borderEffectButtonActionPerformed(evt);
            }
        });
        jPanel6.add(borderEffectButton);

        equalizeEffectButton.setFont(new java.awt.Font("Tahoma", 0, 10));
        equalizeEffectButton.setText("Equalização");
        equalizeEffectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equalizeEffectButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        equalizeEffectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        equalizeEffectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalizeEffectButtonActionPerformed(evt);
            }
        });
        jPanel6.add(equalizeEffectButton);

        binarizeEffectButton.setFont(new java.awt.Font("Tahoma", 0, 10));
        binarizeEffectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/efeito_binarize.png"))); // NOI18N
        binarizeEffectButton.setText("Binarização");
        binarizeEffectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        binarizeEffectButton.setMargin(new java.awt.Insets(2, 5, 2, 5));
        binarizeEffectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        binarizeEffectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binarizeEffectButtonActionPerformed(evt);
            }
        });
        jPanel6.add(binarizeEffectButton);

        jTaskPaneGroup2.getContentPane().add(jPanel6);

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel1Layout.createSequentialGroup()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXTitledPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXTitledPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTaskPaneGroup2, 0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXTitledPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTaskPaneGroup1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTaskPaneGroup1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTaskPaneGroup2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void limiarSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_limiarSliderStateChanged
        lupeSettings.setLimiarAtualValue((int) ((limiarSlider.getValue() + 100)/2));
    }//GEN-LAST:event_limiarSliderStateChanged

    private void brightnessSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brightnessSliderStateChanged
        lupeSettings.setBrightnessValue((float) brightnessSlider.getValue());
    }//GEN-LAST:event_brightnessSliderStateChanged

    private void contrastSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_contrastSliderStateChanged
        lupeSettings.setFatorContrastValue((float) (contrastSlider.getValue() + 100)/100);
    }//GEN-LAST:event_contrastSliderStateChanged

    private void negativeEffectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativeEffectButtonActionPerformed
        if(negativeEffectButton.isSelected())
            lupeSettings.setNegativeActived(true);
        else
            lupeSettings.setNegativeActived(false);
}//GEN-LAST:event_negativeEffectButtonActionPerformed

    private void borderEffectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borderEffectButtonActionPerformed
        if(borderEffectButton.isSelected())
            lupeSettings.setBorderActived(true);
        else
            lupeSettings.setBorderActived(false);
}//GEN-LAST:event_borderEffectButtonActionPerformed

    private void equalizeEffectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalizeEffectButtonActionPerformed
        if(equalizeEffectButton.isSelected())
            lupeSettings.setEqualizationActived(true);
        else
            lupeSettings.setEqualizationActived(false);
    }//GEN-LAST:event_equalizeEffectButtonActionPerformed

    private void binarizeEffectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binarizeEffectButtonActionPerformed
        if(binarizeEffectButton.isSelected()) {
            brightnessSlider.setEnabled(false);
            brightnessSpinner.setEnabled(false);
            contrastSlider.setEnabled(false);
            contrastSpinner.setEnabled(false);
            negativeEffectButton.setEnabled(false);
            borderEffectButton.setEnabled(false);
            equalizeEffectButton.setEnabled(false);

            oldLimiarValue = limiarSlider.getValue();
            limiarSlider.setValue(0);
            lupeSettings.setLimiarAtualValue((int) ((limiarSlider.getValue() + 100)/2));
            lupeSettings.setBinarizationActived(true);
        }
        else {
            brightnessSlider.setEnabled(true);
            brightnessSpinner.setEnabled(true);
            contrastSlider.setEnabled(true);
            contrastSpinner.setEnabled(true);
            negativeEffectButton.setEnabled(true);
            borderEffectButton.setEnabled(true);
            equalizeEffectButton.setEnabled(true);

            limiarSlider.setValue(oldLimiarValue);
            lupeSettings.setLimiarAtualValue((int) ((limiarSlider.getValue() + 100)/2));
            lupeSettings.setBinarizationActived(false);
        }
    }//GEN-LAST:event_binarizeEffectButtonActionPerformed

    private void sliderMagnificationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderMagnificationStateChanged
        lupeSettings.setMagnificationValue((float) sliderMagnification.getValue());        
    }//GEN-LAST:event_sliderMagnificationStateChanged

    public DisplayJAI getDisplayImage() {
        return displayImage;
    }

    public JSlider getSliderMagnification() {
        return sliderMagnification;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton binarizeEffectButton;
    private javax.swing.JToggleButton borderEffectButton;
    private javax.swing.JSlider brightnessSlider;
    private javax.swing.JSpinner brightnessSpinner;
    private javax.swing.JSlider contrastSlider;
    private javax.swing.JSpinner contrastSpinner;
    private com.sun.media.jai.widget.DisplayJAI displayImage;
    private javax.swing.JToggleButton equalizeEffectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup1;
    private com.l2fprod.common.swing.JTaskPaneGroup jTaskPaneGroup2;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JSlider limiarSlider;
    private javax.swing.JSpinner limiarSpinner;
    private javax.swing.JToggleButton negativeEffectButton;
    private javax.swing.JSlider sliderMagnification;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


    public void iniciarMarcarPontos(PanelAnalisesEvent event) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void marcarPonto(PanelAnalisesEvent event) {
        if(event.isMarcacaoAtiva()) {
            displayImage.addMouseListener(marcarPontoListener);
        }
        else {
            displayImage.removeMouseListener(marcarPontoListener);
        }
    }

    public void moverPontos(PanelAnalisesEvent event) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void salvarPontos(PanelAnalisesEvent event) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cancelarMarcarPontos(PanelAnalisesEvent event) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void gerarTracado(PanelAnalisesEvent event) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


    private class MarcarPontoListener extends MouseInputAdapter {

        public void mousePressed(MouseEvent e) {
            Point ponto = (Point) e.getPoint().clone();

            System.out.println(ponto);

            float escala = sliderMagnification.getValue();
            System.out.println(escala);

            System.out.println(
                    );
            
            ponto.x = (int) (ponto.x / escala + lupeSettings.getPontoAtual().x);
            ponto.y = (int) (ponto.y / escala + lupeSettings.getPontoAtual().y);

            System.out.println(ponto);
        }
    }

    
}
