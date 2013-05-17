/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.authenticator;

import com.turistainteligente.facade.UsuarioFacadeLocal;
import com.turistainteligente.model.Usuario;
import com.turistainteligente.qualifiers.LoggedIn;
import com.turistainteligente.util.Util;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Hector-FlechaRoja
 */
@Named
@SessionScoped
public class Authenticator implements Serializable {
    @Inject
    private Credentials credentials;
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario currentUser;
    static final Logger log = Logger.getLogger(Authenticator.class.getName());
    
     public String authenticate() {
        try {
            String username = credentials.getUsername();
            String password = credentials.getPassword();
            Usuario u = usuarioFacadeLocal.buscarUsuarioPorEmail(username);
            if (u != null && u.getPassword().equals(password)) {
                setCurrentUser(u);                
                log.log(Level.INFO, "Usuario {0} ingreso al sistema.", getCurrentUser().getEmail());
                Util.addInfo("Bienvenido " + currentUser.getNombre()+"!");                
                return "inicio?faces-redirect=true";
            } else {
                Util.addError("Usuario y/o clave incorrectos");
                log.log(Level.WARNING, "Usuario y/o clave incorrectos");
                return null;
            }
        } catch (Exception e) {
            log.severe(e.getMessage());
            Util.addError("No se logró procesar su solicitud");
            return null;
        }
    }

    public String logout() {
        System.out.println(".................logout...............");
        setCurrentUser(null);
        return "/login.jsf?faces-redirect=true";


    }

    /**
     * @return the currentUser
     */
    @Named
    @Produces
    @LoggedIn
    public Usuario getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(Usuario currentUser) {
        this.currentUser = currentUser;
    }
}
