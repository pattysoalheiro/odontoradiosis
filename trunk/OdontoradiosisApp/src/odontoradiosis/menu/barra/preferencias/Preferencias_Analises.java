/*
 * Preferencias_Analises.java
 *
 * Created on 14/07/2009, 10:00:59
 */

package odontoradiosis.menu.barra.preferencias;

import com.thoughtworks.xstream.XStream;
import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import odontoradiosis.model.analises.Analise;
import odontoradiosis.model.analises.AnalisesJuntas;

/**
 *
 * @author Beto
 */
public class Preferencias_Analises extends javax.swing.JPanel {

    private JFrame parent;

    private final String filePref = "src/odontoradiosis/resources/analises/preferencias.txt";
    private ObjectInputStream prefInputStream;
    private ObjectOutputStream prefOutputStream;
    private ArrayList<String> preferencias = new ArrayList<String>();

    private XStream xStream = new XStream();
    private FileInputStream fileBaseDados;
    private AnalisesJuntas analises;

    public Preferencias_Analises(JFrame parent) {
        this.parent = parent;
        initComponents();
        carregarDados();
    }

    private void carregarDados() {
        try {
            fileBaseDados = new FileInputStream("src/odontoradiosis/resources/analises/XmlBaseDados.xml");
            prefInputStream = new ObjectInputStream(new FileInputStream(filePref));
            analises = (AnalisesJuntas) xStream.fromXML(fileBaseDados);
            preferencias = (ArrayList<String>) prefInputStream.readObject();

            DefaultListModel analisesListModel = new DefaultListModel();            
            for (int i = 0; i < analises.getAnalisesPontos().size(); i++) {
                String nomeAnalise = ((Analise)analises.getAnalisesPontos().get(i)).getNomeAnalise();
                if(!preferencias.contains(nomeAnalise))
                    analisesListModel.addElement(nomeAnalise);
            }
            analisesList.setModel(analisesListModel);


            DefaultListModel prefListModel = new DefaultListModel();
            for (int i = 0; i < preferencias.size(); i++)
                prefListModel.add(i, preferencias.get(i));
            preferenciaList.setModel(prefListModel);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        analisesList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        preferenciaList = new javax.swing.JList();
        removeAllButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        OKButton = new javax.swing.JButton();
        addAllButton = new javax.swing.JButton();

        analisesList.setFont(new java.awt.Font("Tahoma", 0, 12));
        analisesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        analisesList.setToolTipText("");
        jScrollPane1.setViewportView(analisesList);

        addButton.setText("Adicionar  >");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("<  Remover");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        preferenciaList.setFont(new java.awt.Font("Tahoma", 0, 12));
        preferenciaList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(preferenciaList);

        removeAllButton.setText("<<  Remover Tudo");
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        addAllButton.setText("Adicionar Tudo  >>");
        addAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(addAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(removeAllButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addGap(27, 27, 27)
                        .addComponent(addAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeAllButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(OKButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String analiseSelected = (String) analisesList.getSelectedValue();

        if(analiseSelected != null && !analiseSelected.equals("")) {
            DefaultListModel modelAnalises = (DefaultListModel) analisesList.getModel();
            modelAnalises.removeElement(analiseSelected);

            DefaultListModel modelPref = (DefaultListModel) preferenciaList.getModel();
            modelPref.addElement(analiseSelected);

            preferencias.add(analiseSelected);
            analisesList.setModel(modelAnalises);
            preferenciaList.setModel(modelPref);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        String analiseSelected = (String) preferenciaList.getSelectedValue();

        if(analiseSelected != null && !analiseSelected.equals("")) {
            DefaultListModel modelAnalises = (DefaultListModel) analisesList.getModel();
            modelAnalises.addElement(analiseSelected);

            DefaultListModel modelPref = (DefaultListModel) preferenciaList.getModel();
            modelPref.removeElement(analiseSelected);

            preferencias.remove(analiseSelected);
            analisesList.setModel(modelAnalises);
            preferenciaList.setModel(modelPref);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAllButtonActionPerformed
        DefaultListModel modelAnalises = (DefaultListModel) analisesList.getModel();
        DefaultListModel modelPref = (DefaultListModel) preferenciaList.getModel();
        
        int size = modelAnalises.getSize();
        for(int i = 0; i < size; i++) {
            modelPref.addElement(modelAnalises.get(i));
            preferencias.add((String) modelAnalises.get(i));
        }

        modelAnalises.removeAllElements();
        analisesList.setModel(modelAnalises);
        preferenciaList.setModel(modelPref);
    }//GEN-LAST:event_addAllButtonActionPerformed

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed
        DefaultListModel modelAnalises = (DefaultListModel) analisesList.getModel();
        DefaultListModel modelPref = (DefaultListModel) preferenciaList.getModel();

        int size = modelPref.getSize();
        for(int i = 0; i < size; i++) {
            modelAnalises.addElement(modelPref.get(i));
            preferencias.remove((String) modelPref.get(i));
        }

        modelPref.removeAllElements();
        analisesList.setModel(modelAnalises);
        preferenciaList.setModel(modelPref);
    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        try {
            prefOutputStream = new ObjectOutputStream(new FileOutputStream(filePref));
            prefOutputStream.writeObject(preferencias);
            prefOutputStream.close();
        }
        catch(Exception e) {
            System.out.println("EXCEÇÃO: Erro ao salvar preferências.");
            e.printStackTrace();
        }

        cancelButtonActionPerformed(null);
    }//GEN-LAST:event_OKButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        parent.setVisible(false);
        parent.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JButton addAllButton;
    private javax.swing.JButton addButton;
    private javax.swing.JList analisesList;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList preferenciaList;
    private javax.swing.JButton removeAllButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

}
