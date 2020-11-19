package jdbcProjectSFJ;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {
    
    final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
//  final String USERNAME = "";
//  final String PASSWORD = "";
    
    Connection conn = null;
    Statement createStatement = null;
    DatabaseMetaData dbmd = null;
    
public DB(){
        
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("A híd megépült.");
        } catch (SQLException ex) {
            System.out.println("Valami baj van a kapcsolat létrehozásakor!");
            System.out.println("" + ex);
        }
        
        if (conn != null){
            try {
                createStatement = conn.createStatement();       
            } catch (SQLException ex) {
                System.out.println("Valami baj van a createStatement létrehozásakor!");
                System.out.println("" + ex);
            }    
        }
        
        try {
            dbmd = conn.getMetaData();    
        } catch (SQLException ex) {
            System.out.println("Valami baj van a DataBaseMetaData (adatbázis leírása) létrehozásakor!");
            System.out.println("" + ex);
        }
        
        try {
            ResultSet rs = dbmd.getTables(null, "APP", "USERS", null);
            if(!rs.next())
            createStatement.execute("create table users (name varchar(20), address varchar(20))");
        } catch (SQLException ex) {
            System.out.println("Valami baj van az adattáblák létrehozásakor!");
            System.out.println("" + ex);
        }
}

public void addUser(String name, String address){
        
        try {
//            String sql = "insert into users values ('"+ name +"', '" + address+ "')";
//            createStatement.execute(sql);
            String sql = "insert into users values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.execute();
    } catch (SQLException ex) {
            System.out.println("Valami baj van a user hozzáadásakor!");
            System.out.println("" + ex);
    }
}     
    
 public void showAllUsers(){
     
    String sql = "select * from users";
    
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(name + " | " + address); 
            }
        } catch (SQLException ex) {
            System.out.println("Valami baj van a user-ek kiolvasásakor!");
            System.out.println("" + ex);
        }
 }   
    
public void showUserMeta(){

    String sql = "select * from users";
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    
        try {
            rs = createStatement.executeQuery(sql);
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++){
                System.out.print(rsmd.getColumnName(i) + " | ");
            }
        } catch (SQLException ex) {
            System.out.println("Valami baj van a metaadatok kiolvasásakor!");
            System.out.println("" + ex);
        }
} 

public List<User> getAllUsers(){
    
    String sql = "select * from users";
    List<User> users = null;
    
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            users = new ArrayList<>();
            while (rs.next()){
                User actualUser = new User(rs.getString("name"), rs.getString("address"));
                users.add(actualUser);
            }
        } catch (SQLException ex) {
            System.out.println("Valami baj van a user-ek kiolvasásakor!");
            System.out.println("" + ex);
        }
    return users;
}

public void addUser(User user){
        
        try {
              String sql = "insert into users values (?,?)";
              PreparedStatement preparedStatement = conn.prepareStatement(sql);
              preparedStatement.setString(1, user.getName());
              preparedStatement.setString(2, user.getAddress());
              preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a user hozzáadásakor!");
            System.out.println(""+ex);
        }
}
}
