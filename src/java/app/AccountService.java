package app;

import model.user;

/**
 *
 * @author 827097
 */
public class AccountService {

    private String username;
    private String password;
    
    public AccountService(){
    }
    public user login(String username, String password){
        boolean nameCheck;
        boolean passwordCheck;
        
        if(username.equals("abe") || username.equals("barb")) {
            nameCheck = true;
        }
        else {
        nameCheck = false;
        }
        if (password.equals("password")) {
            passwordCheck = true;
            password = "";
        } 
        else {
            passwordCheck = false;
        }
        if (nameCheck == true && passwordCheck == true) {
            user user = new user(username, password);
            return user;
        }
        else {
            return null;
        }
    }

}