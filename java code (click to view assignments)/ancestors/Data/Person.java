/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Alexander
 */
public class Person {
    
    private String fName = "";
    private String lName = "";
    private String bDate = "";
    
    public Person(String fName, String lName, String bDate) {
        
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
    }
    
    public void setFirstName(String name) {
        
        this.fName = name;
    }
    
    public void setLastName(String name) {
        
        this.lName = name;
    }
    
    public void setBirthDate(String date) {
        
        this.bDate = date;
    }
    
    public String getFirstName() {
        
        return fName;
    }
    
    public String getLastName() {
        
        return lName;
    }
    
    public String getBirthDate() {
        
        return bDate;
    }
    
    public String getName() {
        
        return (fName + " " + lName);
    }
    
    public String getPersonInfo() {
        
        String title = "<b>" + fName + " " + lName + "<br/>Born: " + bDate + "</b>";
        return title;
    }
    
}
