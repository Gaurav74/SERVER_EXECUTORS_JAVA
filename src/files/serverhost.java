/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.*;

/**
 *
 * @author HP
 */
public class serverhost implements Runnable{
    ServerSocket server=null;
    Socket s=null,sobj=null;
    DataInputStream din=null;
    DataOutputStream dout=null;
    ObjectOutputStream out=null;
    boolean keepalive=true;
    int count=0;
    
    public void makedie(){
        this.keepalive=false;
    }
    
    
    @Override
    public void run(){
      
       
      }    }