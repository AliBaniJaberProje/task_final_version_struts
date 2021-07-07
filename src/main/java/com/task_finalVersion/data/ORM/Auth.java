package com.task_finalVersion.data.ORM;

import com.task_finalVersion.data.database.DatabaseDriver;

import java.sql.ResultSet;
import java.util.HashMap;

public class Auth {

    public static HashMap<String, String> isAuthorized(String email, String password) {
        ResultSet resultSet= DatabaseDriver.db_executor("SELECT id,role FROM `Employees` WHERE email='"+email+"' and password='"+password+"'",false);
        HashMap<String, String> loginResult = new HashMap<String, String>();
        try {
            while (resultSet.next()){
                loginResult.put("role", resultSet.getString("role"));
                loginResult.put("id", resultSet.getString("id"));
                return loginResult;
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            System.out.println("error in  login query execute");
            return  null;

        }
        return null;
    }

}
