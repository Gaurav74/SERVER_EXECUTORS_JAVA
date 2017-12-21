/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class data_find_hospital extends javax.swing.JFrame implements Serializable {
Socket s=null;
ObjectOutputStream dout=null;
ObjectInputStream din=null;
int port=1500;
  Object set=null;boolean rowexist=true;
    String hostel,disease,diagnosis;
  
  
    public data_find_hospital() {
        initComponents();
        name.setEditable(false);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PATIENT ENTRY DATA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 40, 280, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("VTU_NO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 130, 150, 30);
        getContentPane().add(tf1);
        tf1.setBounds(330, 130, 180, 30);

        jButton1.setText("FIND");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(643, 130, 80, 70);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HOSTEL", "DISEASE", "DIAGNOSIS"
            }
        ));
        table.setRowHeight(20);
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 270, 830, 280);

        jLabel3.setText("VTU-");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 140, 60, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("NAME");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 210, 70, 30);
        getContentPane().add(name);
        name.setBounds(330, 210, 190, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        // TODO add your handling code here:
          int vtu = 0;
       /* DefaultTableModel tablemodel=(DefaultTableModel) table.getModel();
        for(int t=0;t<table.getRowCount();t++)
    tablemodel.removeRow(t);//error for table clearing*/
        
        String i;
       if((i=tf1.getText()).equals("")||i.length()!=4)
               throw new IOException(" :ENTER CORRECT VTU NO");
      try{ 
           vtu=Integer.parseInt(i);
      }
    catch(NumberFormatException e){
    JOptionPane.showMessageDialog(this," :ENTER THE CORRECT VTU NO");
    tf1.setText("");
    }
    s=new Socket(InetAddress.getLocalHost(),port);
    dout=new ObjectOutputStream(s.getOutputStream());
    dout.writeObject((Object)2);
    dout.flush();
    dout.writeObject((Object)vtu);
    dout.flush();
    din=new ObjectInputStream(s.getInputStream()); 
    String names=(String) din.readObject();name.setText(names);
    System.out.println("here find data");
    Object obj;
    DefaultTableModel tablemodel=(DefaultTableModel) table.getModel();
        for(int t=table.getRowCount()-1;t>=0;t--){
    tablemodel.removeRow(t);}
        int size=(int)din.readObject();System.out.println(size+"of server");
        if(size>0){
    for(int loop=0;loop<size;loop++){
       if(rowexist) rowexist=false;
       String[] value=((String)din.readObject()).split("-");System.out.println("in the loop0");
    hostel=value[0];disease=value[1];diagnosis=value[2];
    tablemodel.addRow(new String[]{hostel.toUpperCase(),disease.toUpperCase(),diagnosis.toUpperCase()});}
    }System.out.println("in the loop0254");
    if(rowexist){
        JOptionPane.showMessageDialog(this,"CHECK VTU NO OR NO ENTRY ON THIS VTU");
        name.setText(null);tf1.setText(null);
    rowexist=true;
    }
     s.close();
    } 
    catch (Exception e) {
        JOptionPane.showMessageDialog(this,"PROBLEM IN CONNECTION OR INPUT");
         try{
            s.close();
        }
        catch(Exception ei){}
         
        this.dispose();new data_find_hospital().setVisible(true);
    //name.setText(null);
    //tf1.setText("");
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
            java.util.logging.Logger.getLogger(data_find_hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_find_hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_find_hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_find_hospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_find_hospital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
