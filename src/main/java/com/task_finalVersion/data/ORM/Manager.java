package com.task_finalVersion.data.ORM;

import com.task_finalVersion.data.database.DatabaseDriver;
import com.task_finalVersion.data.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Manager extends Employee {
    String idManager;

    public Manager(String firstName, String lastName, String imgURL, String birthday, String startJobDate, String role, String password, String id , String idManager) {
        super();
        this.idManager=idManager;
    }
    public Manager(String idManager){
        super();
        this.idManager=idManager;
    }
    public void saveNewEmployee(Employee employee) throws SQLException {
        ResultSet resultSet= DatabaseDriver.db_executor(employee.getAddQuery(),true);
        ResultSet resultSet1=DatabaseDriver.db_executor("select *from `Employees` ORDER BY id DESC LIMIT 1" ,false);
        String idNewEmployee="";
        while (resultSet1.next())
            idNewEmployee=resultSet1.getString("id");

        DatabaseDriver.db_executor("INSERT INTO `Managment_relation` (`id`, `id_developer`, `id_manager`) VALUES (NULL, '"+idNewEmployee+"', '"+this.idManager+"')",true);

    }
    public HashMap<String, HashMap<String,String>> getMyEmployee() throws SQLException {
        HashMap<String,HashMap<String,String>> employeeHashMap=new HashMap<String, HashMap<String,String>>();
        ResultSet resultSet=DatabaseDriver.db_executor("select Employees.* from Employees JOIN Managment_relation on Managment_relation.id_developer=Employees.id where Managment_relation.id_manager='"+this.idManager+"'",false);

        while (resultSet.next()){
            HashMap<String,String> entry=new HashMap<String,String>();
            entry.put("img",resultSet.getString("img_url"));
            entry.put("username",resultSet.getString("first_name") +" "+resultSet.getString("last_name"));
            entry.put("role",resultSet.getString("role"));
            entry.put("email",resultSet.getString("email"));
            employeeHashMap.put( resultSet.getString("id"), entry);

        }
        return  employeeHashMap;
    }
    public HashMap<String,String> getMyInfo() throws SQLException {
        HashMap<String,String> entry=new HashMap<String,String>();        ResultSet resultSet=DatabaseDriver.db_executor("SELECT * FROM Employees WHERE id='"+this.idManager+"'",false);
        while (resultSet.next()){
            entry.put("img",resultSet.getString("img_url"));
            entry.put("username",resultSet.getString("first_name") +" "+resultSet.getString("last_name"));
            entry.put("role",resultSet.getString("role"));
            entry.put("email",resultSet.getString("email"));
        }
        return  entry;
    }

    public HashMap<String, HashMap<String,String>> getAllEmployee() throws SQLException {
        HashMap<String,HashMap<String,String>> employeeHashMap=new HashMap<String, HashMap<String,String>>();
        ResultSet resultSet=DatabaseDriver.db_executor("select Employees.* from Employees ",false);
        while (resultSet.next()){
            HashMap<String,String> entry=new HashMap<String,String>();
            entry.put("img",resultSet.getString("img_url"));
            entry.put("username",resultSet.getString("first_name") +" "+resultSet.getString("last_name"));
            entry.put("role",resultSet.getString("role"));
            entry.put("email",resultSet.getString("email"));
            employeeHashMap.put( resultSet.getString("id"), entry);

        }
        return  employeeHashMap;
    }



}
