/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.User;
import java.sql.PreparedStatement;

/**
 *
 * @author Alexander
 */
public class DatabaseInterface {
    
    static String FORNAME_URL = "com.mysql.jdbc.Driver";
    Connection conn = null;
    
    public DatabaseInterface() {
        
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
                 url = "jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/MovieReviewWebsite";
             } else {
                 user = "root";
                 pass = "password";
                 url = "jdbc:mysql://localhost/MovieReviewWebsite";
             }
             
             conn = DriverManager.getConnection(url,user,pass);

        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println("Error initializing database connection: " + e.getMessage());
        }
    }
    
    public User authorizeUser(String username, String password) {
        
        ResultSet rs = null;
        User user = null;
        
        if (conn != null) {
        
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT name, username, password FROM User WHERE username = '" + username + "' AND password = '" + password + "'";
                rs = stmt.executeQuery(sql);
                
                if (rs.first()) {
                    String d_name = rs.getString("name");
                    String d_username = rs.getString("username");
                    String d_password = rs.getString("password");
                    
                    user = new User(d_name, d_username, d_password);
                } else {
                    
                    user = null;
                }
                
                rs.close();
                stmt.close();
            } catch (Exception e) {
                
                System.out.println("Error executing sql: " + e.getMessage());
            }      
            
        } else {
            
            System.out.println("Connection not established!");
        }
        
        return user;
    }
    
    private boolean userExists(String username) {
        
        boolean exists = false;
        ResultSet rs = null;
        
        if (conn != null) {
        
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT username FROM User WHERE username = '" + username + "'";
                rs = stmt.executeQuery(sql);
                
                if (rs.first()) {
                    
                    exists = true;
                } else {
                    
                    exists = false;
                }
                
                rs.close();
                stmt.close();
            } catch (Exception e) {
                
                System.out.println("Error executing sql: " + e.getMessage());
            }      
            
        } else {
            
            System.out.println("Connection not established while checking if username exists!");
        }
        
        return exists;
    }
    
    public boolean registerUser(String name, String username, String password) {
        
        boolean success = false;
        boolean userExists = userExists(username);
        
        if (!userExists) {
            
            if (conn != null) {
        
                try {           
                    PreparedStatement pstmt = null;
                    String sql = "INSERT INTO User (name, username, password) VALUES (?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, name);
                    pstmt.setString(2, username);
                    pstmt.setString(3, password);
                    pstmt.executeUpdate();
                    pstmt.close();
                    success = true;
                } catch (Exception e) {

                    System.out.println("Error updating user table: " + e.getMessage());
                }      
            
            } else {

                System.out.println("Connection not established while registering user!");
            }
            
        } else {
            
            // user with that username already exists
            success = false;
        }
        
        return success;
    }
    
    public void close() {
        
        try {
            
            conn.close();
        } catch (Exception e) {
            
            System.out.println("Error closing: " + e.getMessage());
        }
    }
}
