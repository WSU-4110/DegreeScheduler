/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinedecorator;
 
import java.util.regex.Pattern;


public class Register {
    String usernamePattern;
    int usernameMinimumLength;
    int usernameMaximumLength;
    int passwordMinimumLength;
    int passwordMaximumLength;
    String passwordPattern;
    
    public Boolean validateUsername(String username) {
        validUsernameFormat(username);
        validUsernameMinLength(username);
        validUsernameMaxLength(username);
        validUsernameNotNull(username);
        return true;
    }
    private void validUsernameFormat(String username){
        if (username != null) {
            Pattern usernamePattern = Pattern.compile(this.usernamePattern);
            boolean hasUsernameFormat = usernamePattern.matcher(username).matches();
            if (!hasUsernameFormat) {
              System.out.print("Username has no correct format");
            }
        }   
    }
    
    private void validUsernameMinLength(String username){
        if (username == null) {
            System.out.print("Username has no correct format");
        }
    }
    
    private void validUsernameMaxLength(String username){
        if (username != null && username.length() < this.usernameMinimumLength) {
            System.out.print("Username is too short");
        }
    }
    
    private void validUsernameNotNull(String username){
        if (username != null && username.length() > this.usernameMaximumLength) {
            System.out.print("Username is too long");
        }
    }
    
    public Boolean validatePassword(String username, String password) {
        validPassword(password);
        validPasswordDiffFromUsername(username, password);
        validPasswordMinLength(password);
        validatePasswordMaxLength(password);
        validatePasswordNotNull(password);
        return true;
    }
    
    private void validPassword(String password){
        if (password != null) {
            Pattern passwordPattern = Pattern.compile(this.passwordPattern);
            boolean hasPasswordPattern = passwordPattern.matcher(password).matches();
            if (!hasPasswordPattern) {
              System.out.print("Invalid characters in password");
            }
        }
    }
    
    private void validPasswordDiffFromUsername(String username, String password){
        if (username != null && username.equals(password)) {
            System.out.print("Password should be different than username");
        }
    }
    
    private void validPasswordMinLength(String password){
        if (password != null && password.length() > this.passwordMaximumLength) {
            System.out.print("Password too long");
        }
    }
    
    private void validatePasswordMaxLength(String password){
        if (password != null && password.length() < this.passwordMinimumLength) {
            System.out.print("Password too short");
        }
    }
    
    private void validatePasswordNotNull(String password){
        if (password == null) {
            System.out.print("Password is null");
        }
    }
        
    public static Builder builder() {
    return new Builder();
  }  
}
