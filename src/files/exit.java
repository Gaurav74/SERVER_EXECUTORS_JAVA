/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class exit implements Runnable {
    Socket s=null;
    DataOutputStream dout=null;
    public void run(){
        try {
            s=new Socket(InetAddress.getLocalHost(),1500);
            dout=new DataOutputStream(s.getOutputStream());
            dout.writeInt(9);
            dout.flush();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"EXIT:\n"+ex.getMessage());
        }
    }
}
