/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class entryframe extends javax.swing.JFrame {

    String studentname,studentphone,studentdept,studentroomtype;
    Socket s=null;
    int roomno;
    ObjectOutputStream out=null;
    ObjectInputStream in=null;
    
    public entryframe() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        room = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        dept = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("HOSTEL ENTRY");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 50, 250, 40);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 260, 80, 70);

        room.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE  ROOM", "SINGLE", "DOUBLE", "LARGE" }));
        room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomActionPerformed(evt);
            }
        });
        getContentPane().add(room);
        room.setBounds(240, 250, 200, 30);

        jLabel2.setText("NAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 180, 170, 30);

        jLabel3.setText("DEPARTMENT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 340, 90, 20);

        jLabel4.setText("ROOM-TYPE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 260, 80, 14);

        jLabel5.setText("PHONE NO.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 460, 150, 40);
        getContentPane().add(phone);
        phone.setBounds(230, 470, 200, 30);
        getContentPane().add(name);
        name.setBounds(240, 180, 200, 30);

        dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE DEPT", "CSE", "MECH", "AERO", "EEE", "ECE " }));
        getContentPane().add(dept);
        dept.setBounds(240, 340, 200, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{
        if((studentname=name.getText()).equals("")){
            throw new Exception("ENTER THE NAME");
        }
         if((studentphone=name.getText()).equals("")){
            throw new Exception("ENTER THE PHONE NUMBER CORRECTLY ");
        }
         if((studentdept=(String)dept.getSelectedItem()).equals("DEPARTMENT")){
             throw new Exception("CHOOSE VALID DEPARTMENT");
         }
         if((studentroomtype=(String)room.getSelectedItem()).equals("CHOOSE ROOM")){
             throw new Exception("CHOOSE VALID ROOM TYPE");
         }
            switch (studentroomtype) {
                case "SINGLE":
                    roomno=1;
                    break;
                case "DOUBLE":
                    roomno=2;
                    break;
                default:
                    roomno=3;
                    break;
            }
         s=new Socket(InetAddress.getLocalHost(),1500);
           out=new ObjectOutputStream(s.getOutputStream());
     in=new ObjectInputStream(s.getInputStream());
         out.writeObject((Object)3);
         out.flush();
         out.writeObject(roomno);out.flush();
         String str=studentname+"-"+studentphone+"-"+studentdept+"-"+studentroomtype;
         out.writeObject(str);
         out.flush();
         boolean bool=(boolean) in.readObject();
         if(bool){
             JOptionPane.showMessageDialog(this,"DATA ENTERD");
         }else{
             JOptionPane.showMessageDialog(this,"ENTRY FAILED");
         }
         
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
                }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomActionPerformed

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
            java.util.logging.Logger.getLogger(entryframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(entryframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(entryframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(entryframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new entryframe().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dept;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox<String> room;
    // End of variables declaration//GEN-END:variables
}
