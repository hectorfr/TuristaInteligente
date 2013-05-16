/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.managed;

import com.turistainteligente.facade.ClienteFacadeLocal;
import com.turistainteligente.model.Cliente;
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
 * @author HectorFlechaRoja
 */
@Named(value = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteFacadeLocal;
    private Cliente cliente;
    private Cliente requestedClienteById;
    static final Logger log = Logger.getLogger(ClienteManagedBean.class.getName());
    @Inject
    @LoggedIn
    private Usuario currentUser;
    
        public String create() {
        try {
//            cliente.setUsuarioRegistro(currentUser.getCorreo());
//            cliente.setFechaRegistro(new Date());
            clienteFacadeLocal.create(cliente);
            Util.addSuccessMessage("Cliente creado con éxito");
            log.log(Level.INFO, "Cliente {0} creado", cliente.getNombre() + cliente.getPrimerApellido());
            initNewCliente();
            return "./listado.jsf?faces-redirect=true";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al crear el cliente {0}", e.getMessage());
            Util.addErrorMessage("Error al crear el cliente");
            return null;

        }


    }

    public String delete() {
        try {            
            clienteFacadeLocal.remove(getRequestedClienteById());
            Util.addSuccessMessage("Cliente eliminado con éxito");
            log.log(Level.INFO, "Cliente {0} eliminado", getRequestedClienteById().getNombre() + getRequestedClienteById().getPrimerApellido());
            return "./listado.jsf?faces-redirect=true";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al eliminar el cliente{0}", e.getMessage());
            Util.addErrorMessage("Error al eliminar el cliente");
            return null;

        }


    }

    public String update() {
        try {
//            getRequestedClienteById().setUsuarioModificacion(currentUser.getCorreo());
//            getRequestedClienteById().setFechaModificacion(new Date());
            clienteFacadeLocal.edit(getRequestedClienteById());
            log.log(Level.INFO, "Cliente {0} modificado con exito", getRequestedClienteById().getNombre() + getRequestedClienteById().getPrimerApellido());
            Util.addSuccessMessage("Cliente modificado con éxito");
            return "./listado.jsf?faces-redirect=true";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al modificar el cliente {0}", e.getMessage());
            Util.addErrorMessage("Error al modificar el cliente");

            return null;

        }


    }

    @Named
    @Produces
    public Cliente getRequestedClienteById() {
        if (requestedClienteById == null) {
            requestedClienteById = findClienteById();
        }
        return requestedClienteById;
    }

    public Cliente findClienteById() {
        try {
            int id = Integer.parseInt(Util.getRequestParameter("idCliente"));
            return clienteFacadeLocal.find(id);
        } catch (Exception e) {
            return null;
        }

    }

    @Named
    @Produces
    public List<Cliente> getClientesPaged() {
        try {
            return clienteFacadeLocal.findAll();

        } catch (Exception e) {
            return null;
        }

    }

    @Named
    @Produces
    public List<SelectItem> getClientesItemsPaged() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        List<Cliente> clientes = clienteFacadeLocal.findAll();
        for (Cliente c : clientes) {
            items.add(new SelectItem(c, c.getNombre() + c.getPrimerApellido() + c.getSegundoApellido()));
        }
        return items;
    }

    /**
     * @return the cliente
     */
    @Produces
    @Named
    public Cliente getCliente() {
        return cliente;

    }

    @PostConstruct
    public void initNewCliente() {
        cliente = new Cliente();

    }
    /**
     * Creates a new instance of ClienteManagedBean
     */
    public ClienteManagedBean() {
    }
}
