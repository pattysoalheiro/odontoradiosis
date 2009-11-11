/*
 * Odontoradiosis.java
 *
 * Created on 07/07/2009, 09:27:00
 */

package odontoradiosis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.media.jai.PlanarImage;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import odontoradiosis.menu.abas.PanelLupa;
import odontoradiosis.menu.barra.preferencias.Preferencias;
import odontoradiosis.util.JAIImageReader;
import org.jdesktop.swingx.JXCollapsiblePane;

/**
 *
 * @author Beto
 */
public class Odontoradiosis extends javax.swing.JFrame {

    private ImagemORSPanel imagemORSPanel;
    private PanelLupa panelLupa;

    
    public Odontoradiosis(ImagemORSPanel imagemORSPanel, PanelLupa panelLupa) {
        this.imagemORSPanel = imagemORSPanel;
        this.panelLupa = panelLupa;
        
        initComponents();
        iniciarAplicativo();
    }

    private void iniciarAplicativo() {
        panelCentralCenter.add(imagemORSPanel);
        jXCollapsiblePane.add(this.panelLupa);
        
        panelInicio.getOpenImageButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirImagemButtonActionPerformed(e);
            }
        });

        panelAnalises.addAnalisesListener(imagemORSPanel.getDisplayJAI());
        panelAnalises.addAnalisesListener(this.panelLupa);
        imagemORSPanel.getDisplayJAI().addListener(panelAnalises);
        ferramentasTabbedPane.setEnabledAt(1, false);
        jXCollapsiblePane.setCollapsed(true);
        
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusPanel = new javax.swing.JPanel();
        panelCentro = new javax.swing.JPanel();
        panelAbas1 = new javax.swing.JPanel();
        ferramentasTabbedPane = new javax.swing.JTabbedPane();
        panelInicio = new odontoradiosis.menu.abas.PanelInicio();
        panelAnalises = new odontoradiosis.menu.abas.PanelAnalises();
        panelCentral = new javax.swing.JPanel();
        panelCentralCenter = new javax.swing.JPanel();
        panelCentralTop = new javax.swing.JPanel();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomePacienteLabel = new javax.swing.JLabel();
        idadePacienteLabel = new javax.swing.JLabel();
        panelAbas2 = new javax.swing.JPanel();
        jXCollapsiblePane = new org.jdesktop.swingx.JXCollapsiblePane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jToggleButton = new javax.swing.JToggleButton();
        jPanel9 = new javax.swing.JPanel();
        toolBar1 = new javax.swing.JToolBar();
        abrirImagemButton = new javax.swing.JButton();
        lupaToggleButton = new javax.swing.JToggleButton();
        jMenuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuModificar = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        efeitos_modificarMenu = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        menuOpcoes = new javax.swing.JMenu();
        preferenciasMenuItem5 = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Odontoradiosis");
        setBackground(new java.awt.Color(153, 153, 153));
        setExtendedState(MAXIMIZED_HORIZ);
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("frame"); // NOI18N

        statusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusPanel.setPreferredSize(new java.awt.Dimension(1024, 25));

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        panelCentro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        panelCentro.setLayout(new java.awt.BorderLayout(5, 10));

        panelAbas1.setLayout(new java.awt.BorderLayout());

        ferramentasTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        ferramentasTabbedPane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        ferramentasTabbedPane.setFocusable(false);

        panelInicio.setBackground(new java.awt.Color(234, 233, 237));
        ferramentasTabbedPane.addTab("Início", new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/house.png")), panelInicio); // NOI18N

        panelAnalises.setBackground(new java.awt.Color(234, 233, 237));
        ferramentasTabbedPane.addTab("Análises", new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/aba_analises.png")), panelAnalises); // NOI18N

        panelAbas1.add(ferramentasTabbedPane, java.awt.BorderLayout.CENTER);

        panelCentro.add(panelAbas1, java.awt.BorderLayout.WEST);

        panelCentral.setLayout(new java.awt.BorderLayout(0, 5));

        panelCentralCenter.setBackground(new java.awt.Color(153, 153, 153));
        panelCentralCenter.setLayout(new java.awt.BorderLayout());
        panelCentral.add(panelCentralCenter, java.awt.BorderLayout.CENTER);

        panelCentralTop.setPreferredSize(new java.awt.Dimension(1300, 80));
        panelCentralTop.setLayout(new java.awt.BorderLayout());

        jXTitledPanel1.setBackground(new java.awt.Color(234, 233, 237));
        jXTitledPanel1.setOpaque(true);
        jXTitledPanel1.setTitle("Dados do Paciente");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 1, 11));
        jXTitledPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome: ");

        jLabel2.setText("Idade:");

        nomePacienteLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        nomePacienteLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomePacienteLabel.setText(" ");

        idadePacienteLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        idadePacienteLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        idadePacienteLabel.setText(" ");

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomePacienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idadePacienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(898, Short.MAX_VALUE))
        );

        jXTitledPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomePacienteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idadePacienteLabel))
                .addContainerGap())
        );

        jXTitledPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        panelCentralTop.add(jXTitledPanel1, java.awt.BorderLayout.CENTER);

        panelCentral.add(panelCentralTop, java.awt.BorderLayout.PAGE_START);

        panelCentro.add(panelCentral, java.awt.BorderLayout.CENTER);

        panelAbas2.setLayout(new java.awt.BorderLayout());

        jXCollapsiblePane.setAnimated(false);
        jXCollapsiblePane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jXCollapsiblePane.setDirection(org.jdesktop.swingx.JXCollapsiblePane.Direction.RIGHT);
        jXCollapsiblePane.getContentPane().setLayout(new java.awt.BorderLayout());
        panelAbas2.add(jXCollapsiblePane, java.awt.BorderLayout.CENTER);

        jPanel7.setPreferredSize(new java.awt.Dimension(16, 1190));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );

        jToggleButton.setAction(jXCollapsiblePane.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION));
        jToggleButton.setEnabled(false);
        jToggleButton.setFocusable(false);
        jToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jToggleButton.setPreferredSize(new java.awt.Dimension(16, 23));

        jPanel9.setPreferredSize(new java.awt.Dimension(15, 300));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Action toggleAction = jXCollapsiblePane.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION);
        toggleAction.putValue(JXCollapsiblePane.COLLAPSE_ICON,new ImageIcon(getClass().getResource("/odontoradiosis/resources/seta_direita.png")));
        toggleAction.putValue(JXCollapsiblePane.EXPAND_ICON,new ImageIcon(getClass().getResource("/odontoradiosis/resources/seta_esquerda.png")));

        panelAbas2.add(jPanel7, java.awt.BorderLayout.WEST);

        panelCentro.add(panelAbas2, java.awt.BorderLayout.EAST);

        toolBar1.setFloatable(false);
        toolBar1.setRollover(true);

        abrirImagemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/folder1.png"))); // NOI18N
        abrirImagemButton.setToolTipText("Abrir");
        abrirImagemButton.setFocusable(false);
        abrirImagemButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrirImagemButton.setPreferredSize(new java.awt.Dimension(47, 25));
        abrirImagemButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        abrirImagemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirImagemButtonActionPerformed(evt);
            }
        });
        toolBar1.add(abrirImagemButton);

        lupaToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/zoom.png"))); // NOI18N
        lupaToggleButton.setToolTipText("Abrir Lupa");
        lupaToggleButton.setEnabled(false);
        lupaToggleButton.setFocusable(false);
        lupaToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lupaToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lupaToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lupaToggleButtonActionPerformed(evt);
            }
        });
        toolBar1.add(lupaToggleButton);

        menuArquivo.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Abrir");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(150, 22));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirImagemButtonActionPerformed(evt);
            }
        });
        menuArquivo.add(jMenuItem1);

        jMenuItem5.setText("Abrir Módulo Administrativo");
        menuArquivo.add(jMenuItem5);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Sair");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(150, 22));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        menuArquivo.add(jMenuItem2);

        jMenuBar.add(menuArquivo);

        menuModificar.setText("Modificar");
        menuModificar.setEnabled(false);

        jMenuItem4.setText("Resetar Imagem");
        menuModificar.add(jMenuItem4);

        efeitos_modificarMenu.setText("Efeitos");
        efeitos_modificarMenu.setPreferredSize(new java.awt.Dimension(150, 22));

        jCheckBoxMenuItem1.setText("Detecção de Bordas");
        jCheckBoxMenuItem1.setPreferredSize(new java.awt.Dimension(150, 22));
        efeitos_modificarMenu.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setText("Equalização");
        jCheckBoxMenuItem2.setPreferredSize(new java.awt.Dimension(150, 22));
        efeitos_modificarMenu.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setText("Negativo");
        jCheckBoxMenuItem3.setPreferredSize(new java.awt.Dimension(150, 22));
        efeitos_modificarMenu.add(jCheckBoxMenuItem3);

        menuModificar.add(efeitos_modificarMenu);

        jMenuBar.add(menuModificar);

        menuOpcoes.setText("Opções");

        preferenciasMenuItem5.setText("Preferências");
        preferenciasMenuItem5.setPreferredSize(new java.awt.Dimension(113, 19));
        preferenciasMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferenciasMenuItem5ActionPerformed(evt);
            }
        });
        menuOpcoes.add(preferenciasMenuItem5);

        jMenuBar.add(menuOpcoes);

        menuAjuda.setText("Ajuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem3.setText("Sobre");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(150, 22));
        menuAjuda.add(jMenuItem3);

        jMenuBar.add(menuAjuda);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1536, Short.MAX_VALUE)
            .addComponent(panelCentro, javax.swing.GroupLayout.DEFAULT_SIZE, 1536, Short.MAX_VALUE)
            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1536, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentro, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void lupaToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lupaToggleButtonActionPerformed
        if(lupaToggleButton.isSelected()) {
            imagemORSPanel.setVisibleLupa(true);
            jXCollapsiblePane.setCollapsed(false);
            jToggleButton.setSelected(true);
        }
        
        else {
            imagemORSPanel.setVisibleLupa(false);
            jXCollapsiblePane.setCollapsed(true);
            jToggleButton.setSelected(false);
        }
}//GEN-LAST:event_lupaToggleButtonActionPerformed

    private void abrirImagemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirImagemButtonActionPerformed

        if(lupaToggleButton.isSelected()) {
            imagemORSPanel.setVisibleLupa(false);
            jXCollapsiblePane.setCollapsed(true);
            jToggleButton.setSelected(false);
        }

        PlanarImage image = abrirImagem();

        if(image != null) {
            imagemORSPanel.getZoomComboBox().setEnabled(true);            
            ferramentasTabbedPane.setEnabledAt(1, true);
            lupaToggleButton.setEnabled(true);
            menuModificar.setEnabled(true);
            jToggleButton.setEnabled(true);
            imagemORSPanel.setImage(image);
            panelAnalises.setEnabled(true);
        }
    }//GEN-LAST:event_abrirImagemButtonActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void preferenciasMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferenciasMenuItem5ActionPerformed
        Preferencias preferencias = new Preferencias();        
        preferencias.setVisible(true);
}//GEN-LAST:event_preferenciasMenuItem5ActionPerformed

    private PlanarImage abrirImagem() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Abrir Imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Imagens TIFF", "tif", "tiff"));
        
        int result = fileChooser.showOpenDialog(this);

        if(result == JFileChooser.APPROVE_OPTION) {
            File choosedFile = fileChooser.getSelectedFile();
            PlanarImage image = null;

            if (choosedFile != null) {
                try {
                    image = JAIImageReader.readImage(choosedFile.getAbsolutePath());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

                return image;
            }
        }

        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirImagemButton;
    private javax.swing.JMenu efeitos_modificarMenu;
    private javax.swing.JTabbedPane ferramentasTabbedPane;
    private javax.swing.JLabel idadePacienteLabel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JToggleButton jToggleButton;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JToggleButton lupaToggleButton;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuModificar;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JLabel nomePacienteLabel;
    private javax.swing.JPanel panelAbas1;
    private javax.swing.JPanel panelAbas2;
    private odontoradiosis.menu.abas.PanelAnalises panelAnalises;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelCentralCenter;
    private javax.swing.JPanel panelCentralTop;
    private javax.swing.JPanel panelCentro;
    private odontoradiosis.menu.abas.PanelInicio panelInicio;
    private javax.swing.JMenuItem preferenciasMenuItem5;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JToolBar toolBar1;
    // End of variables declaration//GEN-END:variables

}
