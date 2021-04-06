/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinedecorator;

import java.util.regex.Pattern;

/**
 *
 * @author SHANTHAMMA
 */
public class Builder {
    private static final String USERNAME_PATTERN = "^([-_A-Za-z0-9])*$";
    private static final int USERNAME_MIN_LENGTH = 3;
    private static final int USERNAME_MAX_LENGTH = 25;
    private static final int PASSWORD_MIN_LENGTH = 6;
    private static final int PASSWORD_MAX_LENGTH = 20;
    private static final String PASSWORD_PATTERN = "^([A-Za-z0-9_.,&%€@#~])*$";
    
    private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);
    private Register register = new Register();
    
    public Builder() {
      setDefaults();
    }
    
    private void setDefaults() {
        register.usernamePattern = USERNAME_PATTERN;
        register.usernameMinimumLength = USERNAME_MIN_LENGTH;
        register.usernameMaximumLength = USERNAME_MAX_LENGTH;
        register.passwordMinimumLength = PASSWORD_MIN_LENGTH;
        register.passwordMaximumLength = PASSWORD_MAX_LENGTH;
        register.passwordPattern = PASSWORD_PATTERN;
    }
    public Builder usernamePattern(String usernamePattern) {
      register.usernamePattern = usernamePattern;
      return this;
    }

    public Builder passwordPattern(String passwordPattern) {
      register.passwordPattern = passwordPattern;
      return this;
    }

    public Builder usernameMinimumLength(Integer usernameMinLength) {
      register.usernameMinimumLength = usernameMinLength;
      return this;
    }

    public Builder usernameMaximumLength(Integer usernameMaxLength) {
      register.usernameMaximumLength = usernameMaxLength;
      return this;
    }

    public Builder passwordMinimumLength(Integer passwordMinLength) {
      register.passwordMinimumLength = passwordMinLength;
      return this;
    }

    public Builder passwordMaximumLength(Integer passwordMaxLength) {
      register.passwordMaximumLength = passwordMaxLength;
      return this;
    }

    public Register build() {
      return register;
    }
}
