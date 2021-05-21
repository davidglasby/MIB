/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataLayer.InfoDB;
import Models.IInfo;
import javax.swing.JOptionPane;
import meninblack.InfoHantering;

/**
 *
 * @author hp
 */
public class RegistreraUtrustning extends javax.swing.JFrame {

     private IInfo infoService = new InfoHantering(new InfoDB());
    /**
     * Creates new form RegistreraUtrustning
     */
    public RegistreraUtrustning() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ckbxKommunikation = new javax.swing.JCheckBox();
        ckbxTeknik = new javax.swing.JCheckBox();
        ckbxVapen = new javax.swing.JCheckBox();
        btnSpara = new javax.swing.JButton();
        txtKaliber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtKraftkalla = new javax.swing.JTextField();
        txtOverforingsTeknik = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBenamning = new javax.swing.JTextField();
        btnTillbaka = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ckbxKommunikation.setText("Kommunikation");

        ckbxTeknik.setText("Teknik");

        ckbxVapen.setText("Vapen");

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        txtKaliber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKaliberActionPerformed(evt);
            }
        });

        jLabel1.setText("Kaliber");

        jLabel2.setText("KraftK�lla");

        jLabel3.setText("�verf�ringsteknik");

        jLabel4.setText("V�lj Utrustningsben�mning");

        btnTillbaka.setText("Tillbaka");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Registrera ny utrustning");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ckbxVapen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(ckbxTeknik, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtBenamning))
                                            .addGap(44, 44, 44)
                                            .addComponent(jLabel3)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtOverforingsTeknik, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtKraftkalla, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtKaliber, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTillbaka)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                                .addComponent(btnSpara)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ckbxKommunikation)
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbxKommunikation)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOverforingsTeknik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtBenamning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(ckbxTeknik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKraftkalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(ckbxVapen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKaliber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSpara)
                    .addComponent(btnTillbaka))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKaliberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKaliberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKaliberActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        // TODO add your handling code here:
        int utrustningsID = infoService.getMaxIDFromUtrustning();
        String benamning = txtBenamning.getText();
        
        
        if(ckbxKommunikation.isSelected() && ckbxTeknik.isSelected() && ckbxVapen.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Du kan endast v�lja en utrustningstyp av Vapen, Teknik & Kommunikation");
            return;
        }
        if(ckbxKommunikation.isSelected() && ckbxTeknik.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Du kan endast v�lja en utrustningstyp av Vapen, Teknik & Kommunikation");
            return;
        }
        if(ckbxKommunikation.isSelected() && ckbxVapen.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Du kan endast v�lja en utrustningstyp av Vapen, Teknik & Kommunikation");
            return;
        }
        if(ckbxTeknik.isSelected() && ckbxVapen.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Du kan endast v�lja en utrustningstyp av Vapen, Teknik & Kommunikation");
            return;
        }
        else if(ckbxKommunikation.isSelected())
        {
            infoService.registreraNyUtrustning(utrustningsID, benamning);
            var overforingsTeknik = txtOverforingsTeknik.getText();
            infoService.registreraUtrustningSomKommunikation(utrustningsID, overforingsTeknik);
            
        }
        else if(ckbxTeknik.isSelected())
        {
            infoService.registreraNyUtrustning(utrustningsID, benamning);
            var kraftkalla = txtKraftkalla.getText();
            infoService.registreraUtrustningSomTeknik(utrustningsID, kraftkalla);
        }
        else if(ckbxVapen.isSelected())
        {
            infoService.registreraNyUtrustning(utrustningsID, benamning);
            int kaliber = Integer.parseInt(txtKaliber.getText());
            infoService.registreraUtrustningSomVapen(utrustningsID, kaliber);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Du m�ste v�lja typ av utrustning(Vapen, Teknik eller Kommunikation");
        }
                
    }//GEN-LAST:event_btnSparaActionPerformed

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
            java.util.logging.Logger.getLogger(RegistreraUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistreraUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistreraUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistreraUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistreraUtrustning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JCheckBox ckbxKommunikation;
    private javax.swing.JCheckBox ckbxTeknik;
    private javax.swing.JCheckBox ckbxVapen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBenamning;
    private javax.swing.JTextField txtKaliber;
    private javax.swing.JTextField txtKraftkalla;
    private javax.swing.JTextField txtOverforingsTeknik;
    // End of variables declaration//GEN-END:variables
}
