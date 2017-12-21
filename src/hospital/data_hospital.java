/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class data_hospital implements Runnable{
    int  vtu;String name="";
    Connection con=null;
    PreparedStatement ps=null,ps1=null;
    ResultSet s=null,rs=null;
    boolean flagtest=true;
    ArrayList<detail_patient> array;
    public data_hospital(int vtu){
        this.vtu=vtu;
    }
    public boolean flag(){
        return this.flagtest;
    }
    public ArrayList returnresult(){
        return this.array;
    }
    public String name() {
        return this.name;
    }
    boolean nameinput=true;
    
    
    public synchronized void run(){
        try {
            Class.forName("java.sql.DriverManager");
            con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/network","root","12345");
            ps=con.prepareStatement("select PATIENT_NAME,HOSTEL,DISEASE,DIAGNOSIS from HOSPITAL where VTU=?");
                              ps.setInt(1, vtu);    
                              s=ps.executeQuery();
                            
         
           
            System.out.println("9");
           // boolean resultset= s.first();
             array=new ArrayList<>();
             while(s.next()){
                 detail_patient dp=new detail_patient();
                 if(nameinput){
                 name=s.getString("PATIENT_NAME");
                 nameinput=false;
                 }
                 dp.hostel=s.getString("HOSTEL");
                 dp.disease=s.getString("DISEASE");
                 dp.diagnosis=s.getString("DIAGNOSIS");
                 array.add(dp);
             }System.out.println("2");System.out.println("size "+array.size());
             
            flagtest=true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "dat hospital\n"+ex.getMessage());
        flagtest=false;
        }
        finally{
            try{
                if(!(con.isClosed()))
                    con.close();
                if(!(ps.isClosed()))
                    ps.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"DATA_HOSPITAL"+e.getMessage());
            }
        }
    }
}
