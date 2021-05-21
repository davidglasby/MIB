/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Agent;

/**
 *
 * @author hp
 */
public class AdminFunktionerAgent extends javax.swing.JFrame {

    private Agent agent;
    /**
     * Creates new form AdminFunktionerAgent
     */
    public AdminFunktionerAgent(Agent agent) {
        initComponents();
        this.agent = agent;
    }

    private AdminFunktionerAgent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInformationAgent = new javax.swing.JLabel();
        btnRegistreraAgent = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        btnRaderaAgent = new javax.swing.JButton();
        btnGeAgentAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInformationAgent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblInformationAgent.setText("Information om Agenter");

        btnRegistreraAgent.setText("Registrera Agent");
        btnRegistreraAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreraAgentActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnRaderaAgent.setText("Radera Agent");
        btnRaderaAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaderaAgentActionPerformed(evt);
            }
        });

        btnGeAgentAdmin.setText("G�r Agent till Administrator");
        btnGeAgentAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeAgentAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistreraAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInformationAgent)
                            .addComponent(btnRaderaAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGeAgentAdmin))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblInformationAgent)
                .addGap(18, 18, 18)
                .addComponent(btnRegistreraAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRaderaAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGeAgentAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistreraAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistreraAgentActionPerformed
        // TODO add your handling code here:
        new RegistreraAgent().setVisible(true);
    }//GEN-LAST:event_btnRegistreraAgentActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnRaderaAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaderaAgentActionPerformed
        // TODO add your handling code here:
        new RaderaAgent(agent).setVisible(true);
    }//GEN-LAST:event_btnRaderaAgentActionPerformed

    private void btnGeAgentAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeAgentAdminActionPerformed
        // TODO add your handling code here:
        new GorAgentTillAdmin().setVisible(true);
    }//GEN-LAST:event_btnGeAgentAdminActionPerformed

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
            java.util.logging.Logger.getLogger(AdminFunktionerAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFunktionerAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFunktionerAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFunktionerAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFunktionerAgent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeAgentAdmin;
    private javax.swing.JButton btnRaderaAgent;
    private javax.swing.JButton btnRegistreraAgent;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel lblInformationAgent;
    // End of variables declaration//GEN-END:variables
}