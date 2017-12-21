/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class hosteldataentry  implements Runnable{
    
    String studentname,studentphone,studentdept,studentroomtype;int roomno,flag;ResultSet rs=null;
    boolean status;
    public hosteldataentry(int flag,String studentname,String studentphone,String studentdept,String studentroomtype){
        this.studentdept=studentdept;
        this.studentname=studentname;
        this.studentphone=studentphone;
        this.studentroomtype=studentroomtype;
        this.flag=flag;
    }
    public  boolean returnstatus(){
       return status;
    }
    
    
    @Override
    public void run(){
        try{
         
   // Class.forName("java.sql.DriverManager");
    Connection Con=(Connection)DriverManager.getConnection("jdbc:mysql//localhost:3306/network","root","12345");
    PreparedStatement ps =null,ps1=null;
    if(flag==0){
    ps= Con.prepareStatement("UPDATE TABLE HOSTEL SET NAME=?,BRANCH=?,PHONENO=?,ROOMTYPE=?"
            + " where ROOMNO=?;");
      
    
    //if(flag==1){
        ps1=Con.prepareStatement("call findseat(?);");
        ps1.setInt(1,roomno);
    //}
        rs=ps1.executeQuery();
        rs.next();
        roomno=rs.getInt(1);
        
        roomno=roomno+1;
         ps.setInt(1,roomno);
       ps.setString(2, studentdept);
       int phone=Integer.parseInt(studentphone);
        ps.setInt(3,phone);
        ps.setString(4,studentroomtype);
        ps.setInt(5,roomno);
                int rs=ps.executeUpdate();
                if(rs==1){
                    this.status =Boolean.TRUE;
                }else{
                    this.status=Boolean.FALSE;
                }
    }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
}
