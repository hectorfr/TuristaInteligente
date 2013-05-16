/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.authenticator;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Hector-FlechaRoja
 */
@Named(value = "credentials")
@RequestScoped
public class Credentials {
 private String username;
    private String password;

    /**
     * @return the userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param userName the userName to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
