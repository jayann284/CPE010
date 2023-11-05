
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermquiz2;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Rich
 */
public class ConnectionsMYSQL {
    public Connection conn;
    public Statement statement;
    
    public void CheckConnection(){
        String url="jdbc:mysql://localhost:3306/employeemanagementsystem";
        String user="root";
        String password="";
        try{
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(url,user,password);
             System.out.println("Connections Successful to the database"+url);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(" "+e);
        }
    }
    
   
    
    
    
}
