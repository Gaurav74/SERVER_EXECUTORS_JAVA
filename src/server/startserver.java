/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author GAURAV
 */
public class startserver extends javax.swing.JFrame implements Runnable {

    ServerSocket server = (ServerSocket) null;

    boolean keepalive = true;
    startserver serv;

    public startserver() {
        initComponents();
        info.setText("SERVER IS OFF");
        stop.setVisible(false);
    }
    protected ExecutorService threadpool
            = Executors.newFixedThreadPool(10);

    Runtime r = Runtime.getRuntime();

    @Override
    public synchronized void run() {

        try {
            server = new ServerSocket(1500);
       
             server.setReuseAddress(true);
            

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "serverhost:\n" + e.getMessage());
        }
        while (keepalive && server != null) {
            try {
                Socket s = server.accept();
                this.threadpool.execute(new serverhostimp(s));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "serversocket:\n" + e.getMessage());
                keepalive = false;
            }

        }
        //this.threadpool.shutdown();
        try {
            if (!(server.isClosed())) {
                server.close();
            }
            info.setText("SERVER IS OFF");

        } catch (Exception e) {
           // JOptionPane.showMessageDialog(rootPane, "");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 102));
        jLabel1.setText("SERVER PAGE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 40, 280, 50);

        start.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        start.setText("START");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start);
        start.setBounds(150, 200, 100, 70);

        stop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stop.setText("STOP");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        getContentPane().add(stop);
        stop.setBounds(420, 200, 100, 70);

        info.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        info.setForeground(new java.awt.Color(255, 0, 0));
        info.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(info);
        info.setBounds(490, 50, 220, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        try {
            serv = new startserver();
            new Thread((Runnable) serv).start();
            info.setText("SERVER IS ON");
            stop.setVisible(true);
            start.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR IN STARTING SERVER");
        }
    }//GEN-LAST:event_startActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        synchronized (this) {
            serv.keepalive = false;
            this.threadpool.shutdown();
            if (!(threadpool.isTerminated())) {
                try {
                    threadpool.awaitTermination(1, TimeUnit.SECONDS);
                    if (!(threadpool.isTerminated())) {
                        threadpool.shutdownNow();
                    }
                    if (!(server.isClosed())) {
                        this.server.close();
                    }
                } catch (IOException | InterruptedException e) {
                    threadpool.shutdownNow();
                }
            }
            info.setText("SERVER IS OFF");
            start.setVisible(true);
            stop.setVisible(false);

            r.gc();
        }
    }//GEN-LAST:event_stopActionPerformed

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
            java.util.logging.Logger.getLogger(startserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(startserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(startserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(startserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new startserver().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
