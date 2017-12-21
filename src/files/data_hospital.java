/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class data_hospital implements Runnable{
    int  vtu;
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet s=null;
    boolean flagtest=true;
    data_hospital(int vtu){
        this.vtu=vtu;
    }
    public boolean flag(){
        return this.flagtest;
    }
    public ResultSet returnresult(){
        return this.s;
    }
    public void run(){
        try {
            //Class.forName("java.sql.DriverManager");
            con=(Connection)DriverManager.getConnection("jdbc:Mysql://localhost:3306/network","root","12345");
            ps=con.prepareStatement("select *from HOSPITAL where VTU=?");
             s=ps.executeQuery();
            flagtest=true;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        flagtest=false;
        }
        finally{
            try{
                if(!(con.isClosed()))
                    con.close();
                if(!(ps.isClosed()))
                    ps.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"DATA_HOSPITAL"+e.getMessage());
            }
        }
    }
}
