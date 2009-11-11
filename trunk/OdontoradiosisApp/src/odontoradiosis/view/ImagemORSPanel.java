/*
 * ImagemORSPanel.java
 *
 * Created on 16/07/2009, 10:42:30
 */

package odontoradiosis.view;

import java.awt.Point;
import javax.media.jai.PlanarImage;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import odontoradiosis.menu.abas.PanelLupa;
import odontoradiosis.util.Resizer;
import odontoradiosis.view.pontos.AnaliseSettings;
import odontoradiosis.view.pontos.ORSDisplayJAI;

/**
 *
 * @author Beto
 */
public class ImagemORSPanel extends javax.swing.JPanel {

    private ORSDisplayJAI displayJAI;
    private PlanarImage original;
    private Magnifier magGlass;
    private PanelLupa panelLupa;
    private JPanel panelAux;
    private boolean isLupaVisible;


    
    public ImagemORSPanel(PanelLupa panelLupa, Magnifier magnifier) {
        initComponents();

        this.panelLupa = panelLupa;
        this.magGlass = magnifier;
        this.displayJAI = new ORSDisplayJAI();
        this.panelAux   = new JPanel();

        // Zoom Inicial eh 100%
        AnaliseSettings.getInstance().setEscala(1.0F);
    }

    public void setMagnifier(Magnifier magnifier) {
        this.magGlass = magnifier;
    }

    public void setImage(PlanarImage image) {
        this.original = image;

        displayJAI.set(original);
        panelAux.setSize(original.getWidth(), original.getHeight());
        panelAux.add(displayJAI);
        centralizar();

        String resolution = image.getWidth() + " x " + image.getHeight();
        resolutionLabel.setText(resolution);
    }

    public JScrollPane getImageScrollPane() {
        return imageScrollPane;
    }

    public ORSDisplayJAI getDisplayJAI() {
        return displayJAI;
    }
    
    public JLabel getResolutionLabel() {
        return resolutionLabel;
    }

    public JComboBox getZoomComboBox() {
        return zoomComboBox;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage = new javax.swing.JPanel();
        imageScrollPane = new javax.swing.JScrollPane();
        panelImagemAuxiliar = new javax.swing.JPanel();
        toolbar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        resolutionLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        zoomComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(213, 213, 213));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        panelImage.setBackground(new java.awt.Color(204, 204, 204));
        panelImage.setLayout(new java.awt.BorderLayout());

        imageScrollPane.setBackground(new java.awt.Color(204, 204, 204));
        imageScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        imageScrollPane.setOpaque(false);

        javax.swing.GroupLayout panelImagemAuxiliarLayout = new javax.swing.GroupLayout(panelImagemAuxiliar);
        panelImagemAuxiliar.setLayout(panelImagemAuxiliarLayout);
        panelImagemAuxiliarLayout.setHorizontalGroup(
            panelImagemAuxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );
        panelImagemAuxiliarLayout.setVerticalGroup(
            panelImagemAuxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        imageScrollPane.setViewportView(panelImagemAuxiliar);

        panelImage.add(imageScrollPane, java.awt.BorderLayout.CENTER);

        add(panelImage, java.awt.BorderLayout.CENTER);

        toolbar.setBackground(new java.awt.Color(235, 235, 251));
        toolbar.setPreferredSize(new java.awt.Dimension(847, 28));
        toolbar.setLayout(new java.awt.BorderLayout(50, 0));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        resolutionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resolutionLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        resolutionLabel.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel2.add(resolutionLabel, java.awt.BorderLayout.EAST);

        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        toolbar.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout(10, 0));

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        zoomComboBox.setMaximumRowCount(10);
        zoomComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "800%", "400%", "200%", "150%", "100%", "75%", "50%", "25%", "Ajustar" }));
        zoomComboBox.setSelectedIndex(4);
        zoomComboBox.setToolTipText("Zoom");
        zoomComboBox.setEnabled(false);
        zoomComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomComboBoxActionPerformed(evt);
            }
        });
        jPanel7.add(zoomComboBox, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel7, java.awt.BorderLayout.EAST);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Zoom:");
        jPanel4.add(jLabel1, java.awt.BorderLayout.CENTER);

        toolbar.add(jPanel4, java.awt.BorderLayout.EAST);

        add(toolbar, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    public void centralizar() {
        int x = (imageScrollPane.getWidth() - panelAux.getWidth())/2;
        int y = (imageScrollPane.getHeight() - panelAux.getHeight())/2;
        panelAux.setLocation(x, y);
        imageScrollPane.setViewportView(panelAux);
        imageScrollPane.getViewport().setViewPosition(new Point(0, 0));
    }

    private void ajustarZoomImagem() {
        double scaleWidth = (double) original.getWidth() / (imageScrollPane.getWidth() - 20);
        double scaleHeight = (double) original.getHeight() / (imageScrollPane.getHeight() - 20);

        PlanarImage showedImage;

        if(scaleWidth > 1 || scaleHeight > 1) {
            double scale = (double) (1 / Math.max(scaleWidth, scaleHeight));
            // int zoomValue = (int) (scale * 100);

            showedImage = Resizer.resize(original, (float) scale);
            displayJAI.set(showedImage);
            AnaliseSettings.getInstance().setEscala((float) scale);
        }
        else {
            showedImage = original;
            displayJAI.set(original);
        }

        panelAux.setSize(showedImage.getWidth(), showedImage.getHeight());
        panelAux.add(displayJAI);
        centralizar();
    }
    
    private void zoomComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomComboBoxActionPerformed
        if(displayJAI.getSource() != null) {

            if(zoomComboBox.getSelectedItem().equals("Ajustar"))
                ajustarZoomImagem();

            else {
                double zoomValue = Double.valueOf(((String)zoomComboBox.getSelectedItem()).split("%")[0]);

                if(zoomValue <= 10)
                    zoomValue = 10;
                else if(zoomValue >= 800)
                    zoomValue = 800;

                AnaliseSettings.getInstance().setEscala((float) (zoomValue / 100));

                PlanarImage imageAux = Resizer.resize(original, (float) (zoomValue / 100));
                displayJAI.set(imageAux);
                panelAux.setSize(imageAux.getWidth(), imageAux.getHeight());
                panelAux.add(displayJAI);
                centralizar();
            }

            setVisibleLupa(isLupaVisible);
            
        }
}//GEN-LAST:event_zoomComboBoxActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        centralizar();
    }//GEN-LAST:event_formComponentResized

    public void setVisibleLupa(boolean value) {

        isLupaVisible = value;

        if(value) {            
            // Adicionar o Magnifier
            magGlass.setSource(displayJAI);
            magGlass.setDisplay(panelLupa.getDisplayImage());
            magGlass.setMagnification(panelLupa.getSliderMagnification().getValue());
            displayJAI.add(magGlass);
            magGlass.setLocation(0, 0);
            magGlass.repaint();
        }

        else {
            if(magGlass.isVisible()) {
                displayJAI.remove(magGlass);
                displayJAI.repaint();
            }            
        }
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane imageScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel panelImage;
    private javax.swing.JPanel panelImagemAuxiliar;
    private javax.swing.JLabel resolutionLabel;
    private javax.swing.JPanel toolbar;
    private javax.swing.JComboBox zoomComboBox;
    // End of variables declaration//GEN-END:variables

}
