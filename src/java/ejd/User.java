/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejd;

/**
 *
 * @author yglee
 */
public class User {
    // member vars
    private String userId;
    private String password;
    private String nickname;
    private String email;
    
    //no-arg ctor
    public User() {   
        
    }
    
    // with-arg ctor
    public User(String user, String pass, String nick, String email) {
     
          userId = user;
          password = pass;
          nickname = nick;
          this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
    
    
}
