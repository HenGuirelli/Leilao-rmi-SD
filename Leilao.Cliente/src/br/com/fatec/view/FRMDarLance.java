/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

import br.com.fatec.config.Config;
import br.com.fatec.controller.LeilaoController;
import br.com.fatec.model.Item;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henrique1
 */
public class FRMDarLance extends javax.swing.JFrame {
    LeilaoController controller = new LeilaoController();

    /**
     * Creates new form FRMDarLance
     */
    public FRMDarLance() {
        initComponents();
        btnDarLance.setEnabled(false);
        
        controller.preencheTabelaAsync(tblItens);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        btnDarLance = new javax.swing.JButton();
        txtLance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Itens em leilão");

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor Inicial", "Maior lance"
            }
        ));
        jScrollPane1.setViewportView(tblItens);

        btnDarLance.setText("Dar Lance");
        btnDarLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarLanceActionPerformed(evt);
            }
        });

        txtLance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLanceKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Lance:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                        .addComponent(btnDarLance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLance))
                    .addComponent(jLabel2))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnDarLance, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unlockButton(){
        boolean enabled = !txtLance.getText().equals("");
        btnDarLance.setEnabled(enabled);
    }
    
    private void txtLanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLanceKeyReleased
        unlockButton();
    }//GEN-LAST:event_txtLanceKeyReleased

    private void btnDarLanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarLanceActionPerformed
        if (tblItens.getSelectedRow() == -1) { 
            JOptionPane.showMessageDialog(this, "Selecione uma linha");
        }
        float lance = 0;
        try {
            //item selecionado
            Item item = controller.listar().get(tblItens.getSelectedRow());
            System.out.println(item.getId());
            try{
                lance = Float.parseFloat(txtLance.getText());
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Valor do lance inválido");
            }
            
            if (lance <= item.getValorAtual()){
                JOptionPane.showMessageDialog(this, "Valor do lance deve ser maior que valor atual");
                return;
            }
            
            controller.darLance(item, lance);
            tblItens.clearSelection();
            JOptionPane.showMessageDialog(this, "Lance feito");
            
        } catch (RemoteException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, Config.Texts.Error.REMOTE_EXCEPTION);
        }
    }//GEN-LAST:event_btnDarLanceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDarLance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtLance;
    // End of variables declaration//GEN-END:variables
}
