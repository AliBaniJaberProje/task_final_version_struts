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
        //INSERT INTO `Managment_relation` (`id`, `id_developer`, `id_manager`) VALUES (NULL, '11', '22');


        System.out.println(idNewEmployee);
    }

    public HashMap<String, String> getMyEmployee() throws SQLException {
        HashMap<String,String> employeeHashMap=new HashMap<String, String>();
        ResultSet resultSet=DatabaseDriver.db_executor("select Employees.* from Employees" +
                "JOIN Managment_relation on Managment_relation.id_developer=Employees.id" +
                "where Managment_relation.id_manager='"+this.idManager+"'",false);

        while (resultSet.next()){
            employeeHashMap.put( resultSet.getString("id"), resultSet.getString("first_name") +" "+resultSet.getString("last_name"));

        }
        return  employeeHashMap;
    }




}
