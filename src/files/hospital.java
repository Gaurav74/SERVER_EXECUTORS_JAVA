/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class hospital extends javax.swing.JFrame {

    Socket s = null;
    int port = 1500;
    ObjectInputStream din = null;
    ObjectOutputStream dout = null;

    public hospital() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jc1 = new javax.swing.JComboBox<>();
        jc2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        vtuf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JC3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("CHECK IN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 20, 340, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("NAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 190, 70, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("YEAR");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 270, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("HOSTEL/DAY_SCHOLAR");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 340, 190, 30);

        tf1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf1.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(tf1);
        tf1.setBounds(280, 180, 250, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("DIAGNOSIS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 490, 150, 30);

        tf3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf3.setForeground(new java.awt.Color(255, 51, 51));
        tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf3ActionPerformed(evt);
            }
        });
        getContentPane().add(tf3);
        tf3.setBounds(280, 410, 250, 40);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(650, 160, 90, 80);

        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(650, 310, 90, 90);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("DISEASES");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 410, 100, 30);

        jc1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jc1.setForeground(new java.awt.Color(255, 51, 51));
        jc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE ACCOMODATION", "DAY_SCHOLAR", "PRINCE_HOSTEL", "LORDS_HOSTEL", "INTERNATIONAL_HOSTEL", "QUEENS _HOSTEL", " " }));
        jc1.setToolTipText("SELECT");
        jc1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jc1);
        jc1.setBounds(280, 340, 250, 30);

        jc2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jc2.setForeground(new java.awt.Color(255, 51, 51));
        jc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TYPE MEDICOS", "MEDICATION", "REFERRED" }));
        getContentPane().add(jc2);
        jc2.setBounds(280, 490, 240, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("VTU-NO");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 110, 130, 30);

        vtuf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vtufActionPerformed(evt);
            }
        });
        getContentPane().add(vtuf);
        vtuf.setBounds(330, 110, 200, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("VTU-");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(290, 110, 50, 30);

        JC3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE YEAR", "FIRST YEAR", "SECOND YEAR", "THIRD YEAR", "FOURTH YEAR" }));
        getContentPane().add(JC3);
        JC3.setBounds(290, 270, 230, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String name, year, disease, accom, diagnosis;
            int vtu;

            if ((name = tf1.getText()).equals("")) {
                throw new Exception("ENTER THE NAME");
            }

            if ((year = (String) JC3.getSelectedItem()).equals("CHOOSE YEAR")) {
                throw new Exception("ENTER THE YEAR");
            }
            if ((disease = tf3.getText()).equals("")) {
                throw new Exception("ENTER THE DISEASE");
            }
            if ((accom = (String) jc1.getSelectedItem()).equals("CHOOSE ACCOMODATION")) {
                throw new Exception("ENTER THE CORRECT ACCOMODATION ");
            }

            if ((diagnosis = (String) jc2.getSelectedItem()).equals("TYPE MEDICOS")) {
                throw new Exception("ENTER THE CORRECT MEDICATION");
            }
            String data = name + "-" + year + "-" + disease + "-" + accom + "-" + diagnosis;
            s = new Socket(InetAddress.getLocalHost(), port);
            dout = new ObjectOutputStream(s.getOutputStream());
            din = new ObjectInputStream(s.getInputStream());
            dout.writeInt(1);
            dout.flush();
            dout.writeUTF(data);
            dout.flush();
            if ((din.readUTF().equals("ok"))) {
                JOptionPane.showMessageDialog(rootPane, "DATA ENTERED CORRECTLY");
                tf1.setText("");
                JC3.setSelectedIndex(0);
                tf3.setText("");
                jc1.setSelectedIndex(0);
                jc2.setSelectedIndex(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "HOSPITAL" + e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tf1.setText("");
        JC3.setSelectedIndex(0);
        tf3.setText("");
        jc1.setSelectedIndex(0);
        jc2.setSelectedIndex(0);
        vtuf.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void vtufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vtufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vtufActionPerformed

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
            java.util.logging.Logger.getLogger(hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hospital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JC3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> jc1;
    private javax.swing.JComboBox<String> jc2;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField vtuf;
    // End of variables declaration//GEN-END:variables
}
