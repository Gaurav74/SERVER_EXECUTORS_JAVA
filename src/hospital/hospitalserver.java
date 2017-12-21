/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class hospitalserver implements Runnable {
    String name,year,disease,hostel,diagnosis;int vtu;
    Connection con=null;
      PreparedStatement ps=null;
      private int status;
   public hospitalserver(int vtu,String name,String year,String disease,String hostel,String diagnosis){
       this.vtu=vtu;
       this.name=name;
       this.year=year;
       this.diagnosis=diagnosis;
       this.disease=disease;
       this.hostel=hostel;
       }
   public int flag(){
       return this.status;
   }
    @Override
   public synchronized void run() {
         try {
            
            Class.forName("java.sql.DriverManager");
             con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/network","root","12345");
        ps=con.prepareStatement("INSERT INTO HOSPITAL(VTU,PATIENT_NAME,PATIENT_YEAR,HOSTEL,DISEASE,DIAGNOSIS)"
                + " VALUES(?,?,?,?,?,?);");
        ps.setInt(1,vtu);
        ps.setString(2, name);
        ps.setString(3, year);
        ps.setString(4, hostel);
        ps.setString(5, disease);
        ps.setString(6, diagnosis);
        status = ps.executeUpdate();
        } 
        catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"HOSPITALSERVER"+ex.getMessage());
        }
         finally{
             try{
             if(!(con.isClosed()))
                 con.close();
             if(!(ps.isClosed()))
                 ps.close();
             }
             catch(SQLException e){
             }
         }
   }
   public static void main(String args[]){
      
   }
}