/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class delete implements Runnable{
    
    int count=0;
    public void count(){
        count++;
    }
     @Override
    public synchronized void  run() {
       for(int i=0;i<200;i++){
           System.out.println("hi"+count++);
       }
    }

   
    public static void main(String args[]){
         
         try {
           /*  delete d=new delete();
             Thread thread = new Thread(d);
             //Thread.currentThread().setPriority(MAX_PRIORITY);
       
             thread.start();
System.out.println("work or not");       
//thread.join();
for(int y=0;y<9;y++)
System.out.println(5+7);*/
           byte b=(byte) 172;
           System.out.println((int)b);
         } catch (Exception ex) {
             Logger.getLogger(delete.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

   
   
}
