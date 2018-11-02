package br.com.fatec.view;

import br.com.fatec.config.Config;
import br.com.fatec.controller.LeilaoController;
import br.com.fatec.model.Item;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FRMMenu extends javax.swing.JFrame {
    LeilaoController controller = new LeilaoController();

    public FRMMenu() {
        initComponents();
        
        List<Item> itens = null;
        try {
            itens = controller.listar();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, Config.Texts.Error.REMOTE_EXCEPTION);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblItens.getModel();
        
        for(Item item : itens){
            String [] row = new String[] {item.getDescricao(), item.getValoMinimo() + "", item.getValorAtual() + ""};
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        cadastrarItem = new javax.swing.JMenu();
        darLance = new javax.swing.JMenu();
        encerrarLeilao = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        cadastrarItem.setText("Cadastrar Item");
        cadastrarItem.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                cadastrarItemMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        cadastrarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastrarItemMouseClicked(evt);
            }
        });
        cadastrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarItemActionPerformed(evt);
            }
        });
        jMenuBar1.add(cadastrarItem);

        darLance.setText("Dar Lance");
        darLance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                darLanceMouseClicked(evt);
            }
        });
        darLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darLanceActionPerformed(evt);
            }
        });
        jMenuBar1.add(darLance);

        encerrarLeilao.setText("Encerrar Leilão");
        encerrarLeilao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encerrarLeilaoMouseClicked(evt);
            }
        });
        encerrarLeilao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encerrarLeilaoActionPerformed(evt);
            }
        });
        jMenuBar1.add(encerrarLeilao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 529, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarItemActionPerformed

       
    }//GEN-LAST:event_cadastrarItemActionPerformed

    private void darLanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darLanceActionPerformed
        
    }//GEN-LAST:event_darLanceActionPerformed

    private void encerrarLeilaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encerrarLeilaoActionPerformed
        
    }//GEN-LAST:event_encerrarLeilaoActionPerformed

    private void cadastrarItemMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_cadastrarItemMenuKeyPressed

    }//GEN-LAST:event_cadastrarItemMenuKeyPressed

    private void cadastrarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarItemMouseClicked
        show(new FRMCadastrarItem());
    }//GEN-LAST:event_cadastrarItemMouseClicked

    private void darLanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_darLanceMouseClicked
        show(new FRMDarLance());
    }//GEN-LAST:event_darLanceMouseClicked

    private void encerrarLeilaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encerrarLeilaoMouseClicked
        show(new FRMEncerrarLeilao());
    }//GEN-LAST:event_encerrarLeilaoMouseClicked

    private void show(javax.swing.JFrame frame){
        frame.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRMMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cadastrarItem;
    private javax.swing.JMenu darLance;
    private javax.swing.JMenu encerrarLeilao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblItens;
    // End of variables declaration//GEN-END:variables
}
