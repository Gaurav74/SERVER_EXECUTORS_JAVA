/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class navigator_frame extends javax.swing.JFrame {  
    public navigator_frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        idno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 600));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("DEPARTMENTS  LOGIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 40, 370, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(600, 210, 80, 70);

        jc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEPARTMENTS", "HOSPITAL", "HOSTEL", "SCHEDULE", "FACULTY_SEARCH" }));
        getContentPane().add(jc);
        jc.setBounds(250, 320, 200, 30);

        jLabel2.setText("ID_NO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 170, 32, 14);

        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 250, 57, 14);
        getContentPane().add(password);
        password.setBounds(250, 240, 200, 30);
        getContentPane().add(idno);
        idno.setBounds(250, 160, 200, 30);

        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 330, 66, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       try{
           String idinput,dept;char[] pas;
           if((idinput=idno.getText()).equals("")){
           throw new Exception("PLEASE ENTER THE ID-NO");
       }
     
           pas=password.getPassword();
           String pass=new String(pas);
           if((pass).equals("")){
              throw new Exception ("PASSWORD FIELD IS EMPTY");
           }
           if((dept=(String)jc.getSelectedItem()).equals("DEPARTMENTS")){
               throw new Exception("CHOOSE YOUR DEPARTMENT");
           }
           login_verify login=new login_verify(idinput,pass,dept);
           Thread t=new Thread(login);
           t.setDaemon(true);
           t.start();
           t.join();
           boolean bool=login.confirm();
           System.out.println(bool);
           if(bool){
               JOptionPane.showMessageDialog(this,"VERIFIED");
               this.dispose();
               new startserver().setVisible(true);
           }else{
               JOptionPane.showMessageDialog(this,"WRONG INITIALS");
           }
           
           
           
       } 
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage());
       }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(navigator_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(navigator_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(navigator_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(navigator_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new navigator_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> jc;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
