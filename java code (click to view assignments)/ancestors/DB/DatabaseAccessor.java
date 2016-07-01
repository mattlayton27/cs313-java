/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;
import Data.Person;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.lang.System;
/**
 *
 * @author Alexander
 */
public class DatabaseAccessor {
   
    static String FORNAME_URL = "com.mysql.jdbc.Driver";
   
    Connection conn = null;
    
    public DatabaseAccessor() {
        
        try{
            // Register JDBC driver
            Class.forName(FORNAME_URL);

            // Open a connection
            String user = null;
            String pass = null;
            String url = null;
            
             if(System.getenv("OPENSHIFT_MYSQL_DB_USERNAME") != null) {
                 user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                 pass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                 url = "jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/teamact11";
             } else {
                 user = "php";
                 pass = "php-pass";
                 url = "jdbc:mysql://localhost/teamact11";
             }
             
             conn = DriverManager.getConnection(url,user,pass);

        } catch (Exception e) {
            
            System.out.println("Error getting connection:" + e.getMessage());
        }
    }
    
    public List<Person> getPeople() {
        
        List<Person> people = new ArrayList<>();
        ResultSet rs = null;
        
        if (conn != null) {
            
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT first_name, last_name, birthday FROM person";
                rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
                    String fName = rs.getString("first_name");
                    String lName = rs.getString("last_name");
                    String date = rs.getString("birthday");
                    
                    Person temp = new Person(fName, lName, date);
                    people.add(temp);
                }
                
                rs.close();
                stmt.close();
            } catch (Exception e) {
                System.out.println("Error executing sql: " + e.getMessage());
            }      
        } else {
            System.out.println("Connection not established");
        }
        
        return people;
    }
    
    public void close() {
        
        try {
            
        conn.close();
        } catch (Exception e) {
            
            System.out.println("Error closing");
        }
    }
    
}
