
package odontoradiosis.menu.abas;

import com.thoughtworks.xstream.XStream;
import java.awt.Component;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import odontoradiosis.model.analises.Analise;
import odontoradiosis.model.analises.AnalisesJuntas;
import odontoradiosis.model.analises.Ponto;
import odontoradiosis.view.pontos.ORSDisplayEvent;
import odontoradiosis.view.pontos.ORSDisplayListener;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;

/**
 *
 * @author Beto
 */
public class PanelAnalises extends javax.swing.JPanel implements ORSDisplayListener {

    private Collection <PanelAnalisesListener> analisesListeners = new ArrayList<PanelAnalisesListener>();

    private final String filePref = "src/odontoradiosis/resources/analises/preferencias.txt";
    private final String fileBD = "src/odontoradiosis/resources/analises/XmlBaseDados.xml";

    private ObjectInputStream prefInputStream;
    private ObjectOutputStream prefOutputStream;
    private ArrayList<String> preferencias = new ArrayList<String>();
    private FileInputStream fileBaseDados;
    private AnalisesJuntas analises;

    
    public PanelAnalises() {
        initComponents();

        pontosPanel.setVisible(false);
        pontosTable.getColumnModel().getColumn(0).setCellRenderer(new MyTableCellRenderer());
        
        carregarAnalisesPreferencias();
    }

    private void carregarAnalisesPreferencias() {

        XStream xStream = new XStream();
        
        try {
            fileBaseDados = new FileInputStream(fileBD);
            prefInputStream = new ObjectInputStream(new FileInputStream(filePref));
            analises = (AnalisesJuntas) xStream.fromXML(fileBaseDados);

            //Le as preferencias do arquivo e guarda no array;
            preferencias = (ArrayList<String>) prefInputStream.readObject();

            DefaultListModel listModel = new DefaultListModel();

            for (int i = 0; i < preferencias.size(); i++)
                listModel.add(i, preferencias.get(i));

            analisesList.setModel(listModel);
        }
        
        catch(Exception e) { }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        analisesPanel = new com.l2fprod.common.swing.JTaskPaneGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        analisesList = new javax.swing.JList();
        jToolBar1 = new javax.swing.JToolBar();
        addAnaliseButton = new javax.swing.JButton();
        removeAnaliseButton = new javax.swing.JButton();
        selectAnaliseButton = new javax.swing.JButton();
        pontosPanel = new com.l2fprod.common.swing.JTaskPaneGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        pontosTable = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        marcarPontoToggleButton = new javax.swing.JToggleButton();
        moverPontosToggleButton = new javax.swing.JToggleButton();
        SalvarAnaliseButton = new javax.swing.JButton();
        gerarTracadoButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        voltarButton = new javax.swing.JButton();

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jXTitledPanel1.setTitle("Análises Cefalométricas");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 1, 11));
        jXTitledPanel1.setBorder(null);

        analisesPanel.setCollapsable(false);
        analisesPanel.setTitle("Análises");
        analisesPanel.setFont(new java.awt.Font("Tahoma", 1, 12));
        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setGap(2);
        percentLayout1.setOrientation(1);
        analisesPanel.getContentPane().setLayout(percentLayout1);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(258, 220));

        analisesList.setFont(new java.awt.Font("Verdana", 0, 12));
        analisesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        analisesList.setEnabled(false);
        analisesList.setFocusable(false);
        analisesList.setSelectionBackground(new java.awt.Color(153, 204, 255));
        analisesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analisesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(analisesList);

        analisesPanel.getContentPane().add(jScrollPane1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        addAnaliseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/add.png"))); // NOI18N
        addAnaliseButton.setToolTipText("Adicionar Nova Análise");
        addAnaliseButton.setEnabled(false);
        addAnaliseButton.setFocusable(false);
        addAnaliseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addAnaliseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(addAnaliseButton);

        removeAnaliseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/remove.png"))); // NOI18N
        removeAnaliseButton.setToolTipText("Remover Análise");
        removeAnaliseButton.setEnabled(false);
        removeAnaliseButton.setFocusable(false);
        removeAnaliseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeAnaliseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeAnaliseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnaliseButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(removeAnaliseButton);

        selectAnaliseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/accept.png"))); // NOI18N
        selectAnaliseButton.setToolTipText("Resgatar Pontos da Análise");
        selectAnaliseButton.setEnabled(false);
        selectAnaliseButton.setFocusable(false);
        selectAnaliseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        selectAnaliseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        selectAnaliseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAnaliseButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(selectAnaliseButton);

        analisesPanel.getContentPane().add(jToolBar1);

        pontosPanel.setCollapsable(false);
        pontosPanel.setTitle("Pontos");
        pontosPanel.setFont(new java.awt.Font("Tahoma", 1, 12));
        com.l2fprod.common.swing.PercentLayout percentLayout4 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout4.setGap(2);
        percentLayout4.setOrientation(1);
        pontosPanel.getContentPane().setLayout(percentLayout4);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 220));

        pontosTable.setFont(new java.awt.Font("Tahoma", 0, 12));
        pontosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ponto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pontosTable.setFocusable(false);
        pontosTable.setSelectionBackground(new java.awt.Color(153, 204, 255));
        pontosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        pontosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pontosTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pontosTable);

        pontosPanel.getContentPane().add(jScrollPane2);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        marcarPontoToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/pencil.png"))); // NOI18N
        marcarPontoToggleButton.setToolTipText("Marcar Ponto");
        marcarPontoToggleButton.setFocusable(false);
        marcarPontoToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        marcarPontoToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        marcarPontoToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarPontoToggleButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(marcarPontoToggleButton);

        moverPontosToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/arrow_out.png"))); // NOI18N
        moverPontosToggleButton.setToolTipText("Mover Pontos");
        moverPontosToggleButton.setFocusable(false);
        moverPontosToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        moverPontosToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        moverPontosToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverPontosToggleButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(moverPontosToggleButton);

        SalvarAnaliseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/analise_save.png"))); // NOI18N
        SalvarAnaliseButton.setToolTipText("Salvar Análise");
        SalvarAnaliseButton.setFocusable(false);
        SalvarAnaliseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SalvarAnaliseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SalvarAnaliseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarAnaliseButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(SalvarAnaliseButton);

        gerarTracadoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/tracado.png"))); // NOI18N
        gerarTracadoButton.setToolTipText("Gerar Traçado");
        gerarTracadoButton.setEnabled(false);
        gerarTracadoButton.setFocusable(false);
        gerarTracadoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gerarTracadoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gerarTracadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarTracadoButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(gerarTracadoButton);

        jSeparator2.setSeparatorSize(new java.awt.Dimension(20, 20));
        jToolBar2.add(jSeparator2);

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontoradiosis/resources/seta_esquerda2.png"))); // NOI18N
        voltarButton.setToolTipText("Voltar");
        voltarButton.setFocusable(false);
        voltarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        voltarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(voltarButton);

        pontosPanel.getContentPane().add(jToolBar2);

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pontosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(analisesPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analisesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pontosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void removeAnaliseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAnaliseButtonActionPerformed
        DefaultListModel model = (DefaultListModel) analisesList.getModel();
        String analiseSelected = (String) analisesList.getSelectedValue();
        model.removeElement(analiseSelected);

        preferencias.remove(analiseSelected);
        try {
            prefOutputStream = new ObjectOutputStream(new FileOutputStream(filePref));
            prefOutputStream.writeObject(preferencias);
            prefOutputStream.close();
        }
        catch(Exception e) { e.printStackTrace(); }

        analisesList.setModel(model);
}//GEN-LAST:event_removeAnaliseButtonActionPerformed

    private void selectAnaliseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAnaliseButtonActionPerformed

        analisesPanel.setVisible(false);
        
        Analise analise = analises.getAnalise((String)analisesList.getSelectedValue());
        DefaultTableModel modelo = (DefaultTableModel)pontosTable.getModel();
        modelo.setRowCount(0);

        for(int i = 0; i < analise.getPontos().size(); i++)
            modelo.addRow(new Object[] {analise.getPontos().get(i).getSigla(),
                                        analise.getPontos().get(i).getNome()} );

        pontosTable.setModel(modelo);
        pontosPanel.setVisible(true);        

        disparaIniciarMarcarPontos(analise.getNomeAnalise());
    }//GEN-LAST:event_selectAnaliseButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        disparaCancelarMarcarPontos();        
}//GEN-LAST:event_voltarButtonActionPerformed

    private void moverPontosToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverPontosToggleButtonActionPerformed
        
        if(moverPontosToggleButton.isSelected()) {
            if(marcarPontoToggleButton.isSelected())
                marcarPontoToggleButton.setSelected(false);

            pontosTable.setEnabled(false);
            disparaMoverPontos(true);
        }
        else {
            pontosTable.setEnabled(true);
            disparaMoverPontos(false);
        }
}//GEN-LAST:event_moverPontosToggleButtonActionPerformed

    private void analisesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analisesListMouseClicked
        if (evt.getClickCount() == 2)            
            selectAnaliseButtonActionPerformed(null);        
    }//GEN-LAST:event_analisesListMouseClicked

    private void marcarPontoToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarPontoToggleButtonActionPerformed

        if(pontosTable.getSelectedRow() != -1) {

            if(marcarPontoToggleButton.isSelected()) {
                DefaultTableModel modelo = (DefaultTableModel)pontosTable.getModel();
                disparaMarcarPonto(new Ponto((String) modelo.getValueAt(pontosTable.getSelectedRow(), 0), ""), true);
            }
            else
                disparaMarcarPonto(null, false);

            pontosTable.setEnabled(!marcarPontoToggleButton.isSelected());
        }
        else {
            marcarPontoToggleButton.setSelected(false);
            JOptionPane.showMessageDialog(null, "Escolha um ponto antes de marcar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_marcarPontoToggleButtonActionPerformed

    private void gerarTracadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarTracadoButtonActionPerformed
        disparaGerarTracado();
    }//GEN-LAST:event_gerarTracadoButtonActionPerformed

    private void SalvarAnaliseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarAnaliseButtonActionPerformed
        disparaSalvarPontos();
}//GEN-LAST:event_SalvarAnaliseButtonActionPerformed

    private void pontosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pontosTableMouseClicked

        if(pontosTable.getSelectedRow() != -1) {

            marcarPontoToggleButton.setSelected(true);

            if(marcarPontoToggleButton.isSelected()) {
                DefaultTableModel modelo = (DefaultTableModel)pontosTable.getModel();
                disparaMarcarPonto(new Ponto((String) modelo.getValueAt(pontosTable.getSelectedRow(), 0), ""), true);
            }
            else
                disparaMarcarPonto(null, false);

            pontosTable.setEnabled(!marcarPontoToggleButton.isSelected());
        }
        else {
            marcarPontoToggleButton.setSelected(false);
            JOptionPane.showMessageDialog(null, "Escolha um ponto antes de marcar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pontosTableMouseClicked

    public synchronized void addAnalisesListener(PanelAnalisesListener l) {
        if(!analisesListeners.contains(l))
            analisesListeners.add(l);
    }

    public synchronized void removeAnalisesListener(PanelAnalisesListener l) {
        analisesListeners.remove(l);
    }

    private synchronized void disparaIniciarMarcarPontos(String nomeAnalise) {
        for(PanelAnalisesListener listeners : this.analisesListeners)
            listeners.iniciarMarcarPontos(new PanelAnalisesEvent(this, nomeAnalise));
    }

    private synchronized void disparaMarcarPonto(Ponto p, boolean ativo) {
        for(PanelAnalisesListener listeners : this.analisesListeners)
            listeners.marcarPonto(new PanelAnalisesEvent(this, ativo, p));
    }

    private synchronized void disparaMoverPontos(boolean ativo) {
        for(PanelAnalisesListener listeners : this.analisesListeners)
            listeners.moverPontos(new PanelAnalisesEvent(this, ativo));
    }

    private synchronized void disparaSalvarPontos() {
        for(PanelAnalisesListener listeners : this.analisesListeners)
            listeners.salvarPontos(new PanelAnalisesEvent(this));        
    }

    private synchronized void disparaCancelarMarcarPontos() {
        for(PanelAnalisesListener listeners : this.analisesListeners)
            listeners.cancelarMarcarPontos(new PanelAnalisesEvent(this));       
    }

    private synchronized void disparaGerarTracado() {
        for(PanelAnalisesListener listeners : this.analisesListeners)
            listeners.gerarTracado(new PanelAnalisesEvent(this));
    }

    public void marcouPonto(ORSDisplayEvent event) {
        Ponto p = event.getPonto();

        DefaultTableModel modelo = (DefaultTableModel)pontosTable.getModel();
        for(int i = 0; i < modelo.getRowCount(); i++)
            if(modelo.getValueAt(i, 0).equals(p.getSigla())) {
                modelo.removeRow(i);
                break;
            }

        pontosTable.setEnabled(true);
        marcarPontoToggleButton.setSelected(false);

        if(pontosTable.getRowCount() == 0)
            gerarTracadoButton.setEnabled(true);
    }

    public void cancelouAnalise(ORSDisplayEvent event) {
        pontosPanel.setVisible(false);
        analisesPanel.setVisible(true);
    }

    @Override
    public void setEnabled(boolean enabled) {
        analisesList.setEnabled(enabled);
        addAnaliseButton.setEnabled(enabled);
        removeAnaliseButton.setEnabled(enabled);
        selectAnaliseButton.setEnabled(enabled);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SalvarAnaliseButton;
    private javax.swing.JButton addAnaliseButton;
    private javax.swing.JList analisesList;
    private com.l2fprod.common.swing.JTaskPaneGroup analisesPanel;
    private javax.swing.JButton gerarTracadoButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JToggleButton marcarPontoToggleButton;
    private javax.swing.JToggleButton moverPontosToggleButton;
    private com.l2fprod.common.swing.JTaskPaneGroup pontosPanel;
    private javax.swing.JTable pontosTable;
    private javax.swing.JButton removeAnaliseButton;
    private javax.swing.JButton selectAnaliseButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables

    class MyTableCellRenderer extends DefaultTableRenderer {

        public Component getTableCellRendererComponent (JTable table, Object value,
                            boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setFont(new Font("Verdana", Font.BOLD, 12));
            c.setHorizontalAlignment(JLabel.CENTER);

            return c;
        }        
    }

}
