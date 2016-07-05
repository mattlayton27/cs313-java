/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alexander
 */
public class User {
    
    private String name = null;
    private String username = null;
    private String password = null;
    
    public User(String name, String username, String password) {
        
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public void setUsername(String username) {
        
        this.username = username;
    }
    
    public void setPassword(String password) {
        
        this.password = password;
    }
    
    public String getName() {
        
        return name;
    }
    
    public String getUsername() {
        
        return username;
    }
    
    public String getPassword() {
        
        return password;
    }
    
}
