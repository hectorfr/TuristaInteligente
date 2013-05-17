/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.managed;

import com.turistainteligente.facade.UsuarioFacadeLocal;
import com.turistainteligente.model.Usuario;
import com.turistainteligente.qualifiers.LoggedIn;
import com.turistainteligente.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author zakrom
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean implements Serializable {
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario usuario;
    private Usuario requestedUsuarioById;
    static final Logger log = Logger.getLogger(UsuarioManagedBean.class.getName());
    @Inject
    @LoggedIn
    private Usuario currentUser;

    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
    }
    
    public String create() {
        try {
            usuario.setUsrRegistro(currentUser.getEmail());
            usuario.setFecRegistro(new Date());
            usuarioFacadeLocal.create(usuario);
            Util.addSuccessMessage("Usuario creado con éxito");
            log.log(Level.INFO, "Usuario {0} creado", usuario.getNombre() + usuario.getPrimerApellido());
            initNewUsuario();
            return "./listado.jsf?faces-redirect=true";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al crear el usuario {0}", e.getMessage());
            Util.addErrorMessage("Error al crear el usuario");
            return null;
        }
    }

    public String delete() {
        try {
            usuarioFacadeLocal.remove(getRequestedUsuarioById());
            Util.addSuccessMessage("Usuario eliminado con éxito");
            log.log(Level.INFO, "Usuario {0} eliminado", getRequestedUsuarioById().getNombre() + getRequestedUsuarioById().getPrimerApellido());
            return "./listado.jsf?faces-redirect=true";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al eliminar el usuario{0}", e.getMessage());
            Util.addErrorMessage("Error al eliminar el usuario");
            return null;
        }
    }

    public String update() {
        try {
            usuario.setUsrRegistro(getRequestedUsuarioById().getEmail());
            usuario.setFecRegistro(new Date());
            usuarioFacadeLocal.edit(getRequestedUsuarioById());
            log.log(Level.INFO, "Usuario {0} modificado con exito", getRequestedUsuarioById().getNombre() + getRequestedUsuarioById().getPrimerApellido());
            Util.addSuccessMessage("Usuario modificado con éxito");
            return "./listado.jsf?faces-redirect=true";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al modificar el usuario {0}", e.getMessage());
            Util.addErrorMessage("Error al modificar el usuario");
            return null;
        }
    }

    @Named
    @Produces
    public Usuario getRequestedUsuarioById() {
        if (requestedUsuarioById == null) {
            requestedUsuarioById = findUsuarioById();
        }
        return requestedUsuarioById;
    }

    public Usuario findUsuarioById() {
        try {
            int id = Integer.parseInt(Util.getRequestParameter("idUsuario"));
            return usuarioFacadeLocal.find(id);
        } catch (Exception e) {
            return null;
        }

    }

    @Named
    @Produces
    public List<Usuario> getUsuariosPaged() {
        try {
            return usuarioFacadeLocal.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Named
    @Produces
    public List<SelectItem> getUsuariosItemsPaged() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        List<Usuario> usuarios = usuarioFacadeLocal.findAll();
        for (Usuario c : usuarios) {
            items.add(new SelectItem(c, c.getNombre() + c.getPrimerApellido() + c.getSegundoApellido()));
        }
        return items;
    }

    /**
     * @return the usuario
     */
    @Produces
    @Named
    public Usuario getUsuario() {
        return usuario;

    }

    @PostConstruct
    public void initNewUsuario() {
        usuario = new Usuario();

    }
}
