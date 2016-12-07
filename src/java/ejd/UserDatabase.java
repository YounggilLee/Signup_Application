//Model component to access DB
 
package ejd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author yglee
 */
public class UserDatabase {
    
    // constants
    private final static String DB_URL = "jdbc:mysql://localhost:3306/ejd";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "1234";
    
    //member var
    private JdbcHelper jdbc = new JdbcHelper();
    
    //get all users from DB
    public ArrayList<User> getUsers() {
        ArrayList<User> users  = new ArrayList<>();
        
        // connect DB
        jdbc.connect(DB_URL, DB_USER, DB_PASS);
        // set SQL statement
        String sql = "SELECT * FROM ejdUser";
        try{
            //execute SQL with PS
            ResultSet rs = jdbc.query(sql, null);
            
            //get all records in loop
            while(rs.next()){
                
                //get 4 cols per row
                String userId = rs.getString ("id");
                String password = rs.getString ("password");
                String nickname = rs.getString ("nickname");
                String email = rs.getString ("email");

                //create User javabean and add it to array
                User user = new User(userId, password, nickname, email);
                
                // put user into ArrayList
                users.add(user);             
                
            }
                
        } catch(SQLException e){
        
            System.err.println("FROM getAuthors() : " + e.getSQLState() + " : " + e.getMessage());
        } catch(Exception e){
        
            System.err.println(e.getMessage());
        }
        // close DB and return arrayList    
        jdbc.disconnect();
        
        return users;
    }
    
    
 //////////////////////////////////////////////////////////////////////// 
    public User getUser(String userId) {
    
        //validate arg
        if(userId == null || userId.isEmpty()) {
            return null;
        }
        User user = null; // return value
        jdbc.connect(DB_URL, DB_USER, DB_PASS);
        String sql = "SELECT * FROM ejdUser WHERE id =  ?";
        try{
            //execute
             ArrayList<Object> params  = new ArrayList<>();// for param
             params.add(userId);
             ResultSet rs = jdbc.query(sql, params);
             
             if(rs.first()){    //check only first record
                 String id = rs.getString("id");
                 String password = rs.getString("password");
                 String nickname = rs.getString("nickname");
                  String email = rs.getString("email");
                  
                user = new User(id, password, nickname, email);
                  
             }
             
        } catch(SQLException e){
        
            System.err.println("FROM getUser() : " + e.getSQLState() + " : " + e.getMessage());
            
        } catch(Exception e){
        
            System.err.println(e.getMessage());
        }
        // return user
        jdbc.disconnect();
        return user;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////
    public boolean isValid(String userId, String password){
        
        User user = getUser(userId); //get user data from getUser method
        // if user  == null then, return false
        // if user  != null then, check password as well
        if(user == null){
            
            return false;
        
        }else{
        
            //must check the password here //Bcrypt method return boolean 
            return BCrypt.checkpw(password, user.getPassword());  //orig is from user, hash is from database
        }
    
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public boolean isUnique(String userId){
        
        User user = getUser(userId);
        
        //if user == null , uique
        //if user !=, not nuique (already in DB)
        if(userId == null) {
            return true;
        }else{
            return false;            
        }
        
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    public int addUser(String userId, String password, String nickname, String email) {
        
        int result = -1; //default return value
         jdbc.connect(DB_URL, DB_USER, DB_PASS);
         String sql = "INSERT INTO ejdUser VALUES (?, ?, ?, ?)";
         
         //must hash password //salt(default 10)
         String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
         ArrayList<Object> params  = new ArrayList<>();// for param
         params.add(userId);
         params.add(hashedPassword);
         params.add(nickname);
         params.add(email);
         
         result = jdbc.update(sql,params);
         
         jdbc.disconnect();
         return result;
        
    }
    
    
    
}
