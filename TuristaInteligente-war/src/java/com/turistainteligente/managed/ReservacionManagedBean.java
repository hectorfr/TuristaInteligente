/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.managed;

import com.turistainteligente.facade.ClienteFacadeLocal;
import com.turistainteligente.facade.ProveedorFacadeLocal;
import com.turistainteligente.facade.ReservacionFacadeLocal;
import com.turistainteligente.model.Cliente;
import com.turistainteligente.model.Proveedor;
import com.turistainteligente.model.Reservacion;
import com.turistainteligente.model.Usuario;
import com.turistainteligente.qualifiers.LoggedIn;
import com.turistainteligente.qualifiers.RequestedReservacion;
import com.turistainteligente.util.Util;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author HectorFlechaRoja
 */
@Named(value = "reservacionManagedBean")
@ConversationScoped
public class ReservacionManagedBean implements Serializable {           
    private static final long serialVersionUID = 1L;
    @EJB
    private ReservacionFacadeLocal reservacionFacadeLocal;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private ProveedorFacadeLocal proveedorFacade;
    private Reservacion reservacion;    
    private Reservacion requestedReservacionById;
    @Inject
    private Conversation conversation;
    @Inject
    @LoggedIn
    private Usuario currentUser;
    private static final Logger LOG = Logger.getLogger(ReservacionManagedBean.class.getName());
    /**
     * Creates a new instance of ReservacionManagedBean
     */
    public ReservacionManagedBean() {
    }

    public String infoReservacion() {
        conversation.begin();
        return "infoPaquete?faces-redirect=true";
    }
    /**
     * @return the reservacion
     */
    @Named
    @Produces
    public Reservacion getReservacion() {
        return reservacion;
    }

    /**
     * @return the requestedReservacionById
     */
    @RequestedReservacion
    @Named
    @Produces
    public Reservacion getRequestedReservacionById() {
        return requestedReservacionById;
    }
    @PostConstruct
    public void initReservacion() {
        reservacion = new Reservacion();
    }
    
    @Named
    @Produces
    public List<Reservacion> getReservacionesPaged() {
        try {
            return (List<Reservacion>) reservacionFacadeLocal.findAll();
        } catch(Exception e) {
            return null;
        }
    }
    
    @Named
    @Produces
    public List<SelectItem> getProveedoresItemsPaged() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        List<Proveedor> list = proveedorFacade.findAll();
        for (Proveedor p : list) {
            items.add(new SelectItem(p, p.getNombre()));
        }
        return items;
    }
    
    public String getNumConfirmacion() {
        return Util.numConfirmacionFormat(reservacionFacadeLocal.count());
    }
    
    public List<Cliente> autocomplete(Object suggest) {
        String pref = (String) suggest;
        return clienteFacade.buscarPorNombreCompleto(pref);        
    }
}
