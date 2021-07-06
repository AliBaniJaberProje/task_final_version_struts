package com.task_finalVersion.data.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDriver {

    public static   ResultSet db_executor(String SQL,boolean update_query ){
        ResultSet rs=null;

        try{
            Statement stmt= DatabaseConnection.getUniqueConnection().createStatement();
            if(!update_query)
                rs=stmt.executeQuery(SQL);
            else
                stmt.executeUpdate(SQL);
//                rs=stmt.getResultSet();
//                while (rs.next()){
//                    System.out.println(rs.getInt("id"));
//                }
//                System.out.println(x);


        }catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }

}
