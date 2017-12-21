/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author HP
 */
public class login_verify implements Runnable{

    String name,pass,dept;
    public login_verify(String name,String pass,String dept){
        this.pass=pass;
        this.name=name;
        this.dept=dept;
    }
    boolean bool;
    protected boolean confirm(){
        return this.bool;
    }
    
    @Override
    public void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=
        (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/network","root","12345");
       PreparedStatement sql=
 con.prepareStatement("select count(*) as total from login where name=? and pass=sha(?) and dept=?");
         sql.setString(1,name);
         sql.setString(2,pass);
         sql.setString(3,dept);
            ResultSet rs;
            rs = sql.executeQuery();
       rs.next();
         
            int result=rs.getInt("total");
            if(result==1){
           this.bool=Boolean.TRUE;
            }
            else{
                  this.bool=Boolean.FALSE;
                     
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
   
}
