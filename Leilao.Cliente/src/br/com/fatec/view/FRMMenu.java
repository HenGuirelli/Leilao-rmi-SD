package br.com.fatec.view;

import br.com.fatec.controller.LeilaoController;

public class FRMMenu extends javax.swing.JFrame {
    LeilaoController controller = new LeilaoController();
        
    public FRMMenu() {
        initComponents();
        
        controller.preencheTabelaAsync(tblItens);
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
