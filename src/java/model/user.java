package model;



/**
 *
 * @author 827097
 */
public class user {
    
    private String username;
    private String password;
    
    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public user(){
        
    }
    public String getUsername(){
        return username;
    }
}
