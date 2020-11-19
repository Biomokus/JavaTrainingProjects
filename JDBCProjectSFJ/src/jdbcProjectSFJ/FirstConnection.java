package jdbcProjectSFJ;

import java.util.List;

public class FirstConnection {

public static void main(String[] args) {
        
    DB db = new DB();
    db.addUser("Marci", "Kaposvár");
    db.addUser("Levi", "Kaposvár");
    
//    db.showAllUsers();
    
    List<User> users = db.getAllUsers();
        for (User u : users){
            System.out.println(u.getName() + "|" + u.getAddress());}     
    }
}
