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
public class Employee{
    public int emp_id;
    public String emp_name;
    public String emp_address;
    public String emp_bdate;
    //public double num_days_work;
    ArrayList <Employee> employees = new ArrayList<>();
    
    public Employee(int emp_id, String emp_name, String emp_address, String emp_bdate){
        this.emp_id=emp_id;
        this.emp_name=emp_name;
        this.emp_address=emp_address;
        this.emp_bdate=emp_bdate;
    }
    public void createEmployee(String emp_name, String emp_address, String emp_bdate){
        ConnectionsMYSQL cM = new ConnectionsMYSQL();
        cM.CheckConnection();
        try{
            String queryInsert = "insert into employees(emp_name,emp_address,emp_bdate) values('"+emp_name+"','"+emp_address+"','"+emp_bdate+"')";
            Statement statement = cM.conn.createStatement();
            statement.execute(queryInsert);
            cM.conn.close();
        }catch(SQLException e){
            System.out.println(" "+e);
        }
    }
    public ArrayList<Employee> employees()       
    {
        ConnectionsMYSQL cM = new ConnectionsMYSQL();
        //ArrayList<Accounts> itemsList = new ArrayList<>();
            try{
            cM.CheckConnection();
            String query1="Select * from employees";
            Statement st = cM.conn.createStatement();
            ResultSet rs2= st.executeQuery(query1);
                while(rs2.next())
                {
                    Employee emp = new Employee (rs2.getInt("emp_id"),
                            rs2.getString("emp_name"),
                              rs2.getString("emp_address"),
                              rs2.getString("emp_bdate"));
                    employees.add(emp);  
                } 
            cM.conn.close();
          }   
        catch (SQLException e)
        {
           JOptionPane.showMessageDialog( null,e);
        }
            return employees; 
    }
    

    
    public void showEmployees(){
        for(Employee em:this.employees()){
            System.out.println("\n ---------------------------------\n ");
            System.out.println(" Employee ID: "+em.emp_id);
            System.out.println(" Name: "+em.emp_name);
            System.out.println(" Address: "+em.emp_address);
            System.out.println(" Birthdate:  "+em.emp_bdate);  
        }
        System.out.println("\n ---------------------------------\n ");
    }
    
    public void showEmployee(){
        System.out.println("Employee Information: ");
        System.out.println(" "+this.emp_id);
        System.out.println(" "+this.emp_name);
        System.out.println(" "+this.emp_address);
        
    }
     
}

