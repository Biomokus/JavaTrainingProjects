package contactbook;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty eMail;
    private final SimpleStringProperty id;
    
    public Person(){
        this.lastName = new SimpleStringProperty("");
        this.firstName = new SimpleStringProperty("");
        this.eMail = new SimpleStringProperty("");
        this.id = new SimpleStringProperty(""); 
       }

    public Person(String lName, String fName, String email){
        this.lastName = new SimpleStringProperty(lName);
        this.firstName = new SimpleStringProperty(fName);
        this.eMail = new SimpleStringProperty(email);
        this.id = new SimpleStringProperty("");
       }
    
    public Person(Integer id, String lName, String fName, String email){
        this.lastName = new SimpleStringProperty(lName);
        this.firstName = new SimpleStringProperty(fName);
        this.eMail = new SimpleStringProperty(email);
        this.id = new SimpleStringProperty(String.valueOf(id));
       }
    
    public String getLastName(){
        return lastName.get();
    }
    public void setLastName(String lName){
        lastName.set(lName);
    }
    
    public String getFirstName(){
        return firstName.get();
    }
    public void setFirstName(String fName){
        firstName.set(fName);
    }
    
    public String getEmail(){
        return eMail.get();
    }
    public void setEmail(String email){
        eMail.set(email);
    }
    
    public String getId(){
        return id.get();
    }
    public void setId(String fId){
        id.set(fId);
    }
}
