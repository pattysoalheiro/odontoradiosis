
/*
 * Preferencias.java
 *
 * Created on 14/07/2009, 09:50:49
 */

package odontoradiosis.menu.barra.preferencias;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author Beto
 */
public class Preferencias extends javax.swing.JFrame {

    private Preferencias_Analises analises;
    private final Color selectedColor = new Color(210, 230, 255);

    public Preferencias() {
        initComponents();

        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2);

        analisesButtonActionPerformed(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        analisesButton = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preferências");
        setAlwaysOnTop(true);
        setResizable(false);

        toolBar.setBackground(new java.awt.Color(255, 255, 255));
        toolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        analisesButton.setBackground(new java.awt.Color(255, 255, 255));
        analisesButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        analisesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/Analises 32x32.png"))); // NOI18N
        analisesButton.setText("Análises");
        analisesButton.setFocusable(false);
        analisesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        analisesButton.setMaximumSize(new java.awt.Dimension(70, 70));
        analisesButton.setMinimumSize(new java.awt.Dimension(70, 70));
        analisesButton.setPreferredSize(new java.awt.Dimension(70, 70));
        analisesButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        analisesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analisesButtonActionPerformed(evt);
            }
        });
        toolBar.add(analisesButton);

        getContentPane().add(toolBar, java.awt.BorderLayout.NORTH);

        panelMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelMain.setMaximumSize(new java.awt.Dimension(600, 465));
        panelMain.setMinimumSize(new java.awt.Dimension(600, 465));
        panelMain.setPreferredSize(new java.awt.Dimension(600, 465));
        panelMain.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analisesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analisesButtonActionPerformed
        analises = new Preferencias_Analises(this);
        panelMain.add(analises);
        analisesButton.setBackground(selectedColor);
        analisesButton.setBorder(new LineBorder(Color.DARK_GRAY, 1));
    }//GEN-LAST:event_analisesButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analisesButton;
    private javax.swing.JPanel panelMain;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

}
