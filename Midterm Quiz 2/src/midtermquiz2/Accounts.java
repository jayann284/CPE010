/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermquiz2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rich
 */
public class Accounts {
    public int accnt_id;
    public int student_id;
    public String u_username;
    public String u_password;
    ArrayList<Accounts> itemsList = new ArrayList<>();
    
    public Accounts(int accnt_id, int student_id,String u_username ,String u_password){
        this.accnt_id=accnt_id;
        this.student_id=student_id;
        this.u_username=u_username;
        this.u_password=u_password;
    }
    
    public ArrayList<Accounts> itemsList()       
    {
        ConnectionsMYSQL cM = new ConnectionsMYSQL();
        //ArrayList<Accounts> itemsList = new ArrayList<>();
            try{
            cM.CheckConnection();
            String query1="Select * from accounts";
            Statement st = cM.conn.createStatement();
            ResultSet rs2= st.executeQuery(query1);
                while(rs2.next())
                {
                    Accounts acct = new Accounts (rs2.getInt("accnt_id"),
                            rs2.getInt("student_id"),
                              rs2.getString("u_username"),
                              rs2.getString("u_password"));
                    itemsList.add(acct);  
                } 
            cM.conn.close();
          }   
        catch (SQLException e)
        {
           JOptionPane.showMessageDialog( null,e);
        }
            return itemsList; 
    }
    
    public void createAccount(int a, String b, String c){
        ConnectionsMYSQL cM = new ConnectionsMYSQL();
        cM.CheckConnection();
        try{
        String query = "Insert into accounts(student_id, u_username,u_password) values("+a+",'"+b+"','"+c+"')";
        Statement statement = cM.conn.createStatement();
        statement.execute(query);
        cM.conn.close();
        }catch(SQLException e){
            System.out.println(" "+e);
        }
    }
     
    public void showAccounts(){
        for(Accounts accnt:this.itemsList()){
            System.out.println("\n ---------------------------------\n ");
            System.out.println(" Account ID: "+accnt.accnt_id);
            System.out.println(" Student ID: "+accnt.student_id);
            System.out.println(" username: "+accnt.u_username);
            System.out.println(" Password:  "+accnt.u_password);  
        }
        System.out.println("\n ---------------------------------\n ");
    }
    
}
