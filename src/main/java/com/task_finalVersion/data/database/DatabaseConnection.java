package com.task_finalVersion.data.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

   private final static String JDBC_DRIVER="com.mysql.jdbc.Driver";
   private final static String DB_URL="jdbc:mysql://localhost:3306/task_final_version";

   private final static String USER="root";
   private final static String PASS="";

   private  static Connection uniqueConnection = null;

   public static Connection  getUniqueConnection() throws Exception{
        if(uniqueConnection==null){
            synchronized (DatabaseConnection.class){
                if (uniqueConnection==null){
                    Class.forName(JDBC_DRIVER);
                    uniqueConnection= DriverManager.getConnection(DB_URL,USER,PASS);
                }
            }
        }
        return uniqueConnection;
    }

}
