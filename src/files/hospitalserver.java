/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class hospitalserver implements Runnable {
    String name,year,disease,hostel,diagnosis;
    Connection con=null;
      PreparedStatement ps=null;
      boolean flagtest=true;
   hospitalserver(String name,String year,String disease,String hostel,String diagnosis){
       this.name=name;
       this.year=year;
       this.diagnosis=diagnosis;
       this.disease=disease;
       this.hostel=hostel;
       }
   public boolean flag(){
       return this.flagtest;
   }
   public void run() {
         try {
            
            Class.forName("java.sql.DriverManager");
             con=(Connection)DriverManager.getConnection("jdbc:Mysql://localhost:3306/network","root","12345");
        ps=con.prepareStatement("INSERT INTO HOSPITAL(PATIENT_NAME,PATIENT_YEAR,HOSTEL,DISEASE,DIAGNOSIS)"
                + " VALUES(?,?,?,?,?);");
        ps.setString(0, name);
        ps.setString(1, year);
        ps.setString(2, hostel);
        ps.setString(3, disease);
        ps.setString(4, diagnosis);
        int status=ps.executeUpdate();
        if(status<0){
            JOptionPane.showMessageDialog(null,"DATA NOT ENTERED\nCHECK THE INPUT CORRECTLY");
        flagtest=false;
        }
        else{
            JOptionPane.showMessageDialog(null,"DATA ENTERED CORRECTLY");
        }
        flagtest=true;
        
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"HOSPITALSERVER"+ex.getMessage());
        }
         finally{
             try{
             if(!(con.isClosed()))
                 con.close();
             if(!(ps.isClosed()))
                 ps.close();
             }
             catch(Exception e){
                 e.printStackTrace();
             }
         }
   }
   public static void main(String args[]){
      
   }
}