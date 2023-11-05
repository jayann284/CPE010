/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermquiz2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rich
 */
public class Part_time{
    public double rate;
    public int emp_id;
    public double nwd;
    public String emp_name;
  // ArrayList <Part_time> itemsList = new ArrayList<>();

    public Part_time(int emp_id, String emp_name,  double nwd, double rate) {
        this.emp_id=emp_id;
        this.emp_name=emp_name;
        this.rate=rate;
        this.nwd=nwd; 
        
    }

    public void createSalary( int emp_id, double nwd, double rate) {
        ConnectionsMYSQL cM = new ConnectionsMYSQL();
        //super.emp_id = emp_id;
        cM.CheckConnection();
        
        this.nwd=nwd;
        this.rate=rate;
         
        try{
            String query = "Insert into salary(employee_id,nwd, rate) values("+emp_id+",'"+nwd+"','"+rate+"')";
             cM.statement = cM.conn.createStatement();
            cM.statement.execute(query);
            
            cM.conn.close();
        }catch(SQLException e){
            System.out.println(" "+e);
        }
        
    }
    
    public ArrayList<Part_time> itemsList()       
    {
        ConnectionsMYSQL cM = new ConnectionsMYSQL();
        ArrayList<Part_time> itemsList = new ArrayList<>();
            try{
            cM.CheckConnection();
            String query2="SELECT emp_id, emp_name, nwd, emp_address, emp_bdate, rate from salaryview";
            cM.statement = cM.conn.createStatement();
            ResultSet rs3= cM.statement.executeQuery(query2);
                while(rs3.next())
                {
                    Part_time pt = new Part_time (rs3.getInt("emp_id"),
                             rs3.getString("emp_name"),
                            rs3.getDouble("nwd"),
                            rs3.getDouble("rate"));
                    itemsList.add(pt);  
                } 
            cM.conn.close();
          }   
        catch (SQLException e)
        {
           JOptionPane.showMessageDialog( null,e);
        }
            return itemsList; 
    }
    
    public void showSalary(){
        for(Part_time pt:this.itemsList()){
            System.out.println("\n ---------------------------------\n ");
            System.out.println(" Employee ID: "+pt.emp_id);
            System.out.println(" Employee Name:  "+pt.emp_name);
            System.out.println(" NWD:  "+pt.nwd);
            System.out.println(" Rate:  "+pt.rate); 
            System.out.println(" Salary:  "+(pt.rate*pt.nwd)); 
            
        }
        System.out.println("\n ---------------------------------\n ");
    }
}
