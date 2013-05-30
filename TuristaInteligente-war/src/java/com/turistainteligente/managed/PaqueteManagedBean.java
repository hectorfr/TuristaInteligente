/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.managed;

import com.turistainteligente.facade.PaqueteFacadeLocal;
import com.turistainteligente.facade.TarifaHabitacionFacade;
import com.turistainteligente.facade.TarifaPaqueteFacade;
import com.turistainteligente.facade.TipoPaqueteIntFacade;
import com.turistainteligente.facade.TipoPaqueteNacFacade;
import com.turistainteligente.model.Paquete;
import com.turistainteligente.model.TarifaHabitacion;
import com.turistainteligente.model.TarifaPaquete;
import com.turistainteligente.model.TipoPaqueteInt;
import com.turistainteligente.model.TipoPaqueteNac;
import com.turistainteligente.model.Usuario;
import com.turistainteligente.qualifiers.LoggedIn;
import com.turistainteligente.util.Util;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author HectorFlechaRoja
 */
@Named(value = "paqueteManagedBean")
@Dependent
public class PaqueteManagedBean {

    /**
     * Creates a new instance of PaqueteManagedBean
     */
    public PaqueteManagedBean() {
    }
    
    @EJB
    private PaqueteFacadeLocal paqueteFacadeLocal;
    @EJB
    private TipoPaqueteIntFacade tipoPaqueteIntFacadeLocal;
    @EJB
    private TipoPaqueteNacFacade tipoPaqueteNacFacadeLocal;
    @EJB
    private TarifaHabitacionFacade tarifaHabitacionFacadeLocal;
    @EJB
    private TarifaPaqueteFacade tarifaPaqueteFacadeLocal;
    private Paquete paquete;
    private Paquete requestedPaqueteById;
    private TarifaPaquete tarifaPaquete;
    private TarifaPaquete requestedTarifaPaqueteById;
    private TarifaHabitacion tarifaHabitacion;
    private TarifaHabitacion requestedTarifaHabitacionById;
    private TipoPaqueteInt tipoPaqueteInt;
    private TipoPaqueteInt requestedTipoPaqueteIntById;
    private TipoPaqueteNac tipoPaqueteNac;
    private TipoPaqueteNac requestedTipoPaqueteNacById;
    private char tipoPaquete;
    private char tipoTarifa;
    static final Logger log = Logger.getLogger(PaqueteManagedBean.class.getName());
    @Inject
    @LoggedIn
    private Usuario currentUser;

    public String create() {
        try {
//            se crea primero el tipo de tarifa
            if(getTipoTarifa() == Util.TipoTarifa.H.toString().charAt(0)) {
                tarifaHabitacion.setUsrRegistro(currentUser.getEmail());
                tarifaHabitacion.setFecRegistro(new Date());
                tarifaHabitacionFacadeLocal.create(tarifaHabitacion);                
            } else {
                tarifaPaquete.setUsrRegistro(currentUser.getEmail());
                tarifaPaquete.setFecRegistro(new Date());
                tarifaPaqueteFacadeLocal.create(tarifaPaquete);  
            }
//            se crea el tipo de paquete y se añade el tipo de tarifa
            if(getTipoPaquete() == Util.TipoPaquete.I.toString().charAt(0)) {                
                if(getTipoTarifa() == Util.TipoTarifa.H.toString().charAt(0)) {
                    tipoPaqueteInt.setIndTipoTarifa(Util.TipoTarifa.H.toString().charAt(0));
                    tipoPaqueteInt.setIdTarifaHabitacion(tarifaHabitacion);
                } else {
                    tipoPaqueteInt.setIndTipoTarifa(Util.TipoTarifa.P.toString().charAt(0));
                    tipoPaqueteInt.setIdTarifaPaquete(tarifaPaquete);
                }
                tipoPaqueteInt.setUsrRegistro(currentUser.getEmail());
                tipoPaqueteInt.setFecRegistro(new Date());
                tipoPaqueteIntFacadeLocal.create(tipoPaqueteInt);
                paquete.setIdTipoPaqueteInt(tipoPaqueteInt);
            } else {
                if(getTipoTarifa() == Util.TipoTarifa.H.toString().charAt(0)) {
                    tipoPaqueteNac.setIndTipoTarifa(Util.TipoTarifa.H.toString().charAt(0));
                    tipoPaqueteNac.setIdTarifaHabitacion(tarifaHabitacion);
                } else {
                    tipoPaqueteNac.setIndTipoTarifa(Util.TipoTarifa.P.toString().charAt(0));
                    tipoPaqueteNac.setIdTarifaPaquete(tarifaPaquete);
                }
                tipoPaqueteNac.setUsrRegistro(currentUser.getEmail());
                tipoPaqueteNac.setFecRegistro(new Date());
                tipoPaqueteNacFacadeLocal.create(tipoPaqueteNac);
                paquete.setIdTipoPaqueteNac(tipoPaqueteNac);
            }
            paquete.setUsrRegistro(currentUser.getEmail());
            paquete.setFecRegistro(new Date());
            paqueteFacadeLocal.create(paquete);
            Util.addSuccessMessage("Paquete creado con éxito");
            log.log(Level.INFO, "Paquete {0} creado", paquete.getIdPaquete());
            initNewPaquete();
//            return "./listado.jsf?faces-redirect=true";
            return "./listado.jsf";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al crear el paquete {0}", e.getMessage());
            Util.addErrorMessage("Error al crear el paquete");
            return null;
        }
    }

    public String delete() {
        try {
            paqueteFacadeLocal.remove(getRequestedPaqueteById());
            Util.addSuccessMessage("Paquete eliminado con éxito");
            log.log(Level.INFO, "Paquete {0} eliminado", getRequestedPaqueteById().getIdPaquete());
            return "./listado.jsf?faces-redirect=true";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al eliminar el paquete{0}", e.getMessage());
            Util.addErrorMessage("Error al eliminar el paquete");
            return null;
        }
    }

    public String update() {
        try {
            paquete.setUsrRegistro(currentUser.getEmail());
            paquete.setFecRegistro(new Date());
            paqueteFacadeLocal.edit(getRequestedPaqueteById());
            log.log(Level.INFO, "Paquete {0} modificado con exito", getRequestedPaqueteById().getIdPaquete());
            Util.addSuccessMessage("Paquete modificado con éxito");
            return "./listado.jsf?faces-redirect=true";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al modificar el paquete {0}", e.getMessage());
            Util.addErrorMessage("Error al modificar el paquete");
            return null;
        }
    }

    @Named
    @Produces
    public Paquete getRequestedPaqueteById() {
        if (requestedPaqueteById == null) {
            requestedPaqueteById = findPaqueteById();
        }
        return requestedPaqueteById;
    }
    
    @Named
    @Produces
    public TipoPaqueteInt getRequestedTipoPaqueteIntById() {
        if (requestedTipoPaqueteIntById == null) {
            requestedTipoPaqueteIntById = findTipoPaqueteIntById();
        }
        return requestedTipoPaqueteIntById;
    }
    
    @Named
    @Produces
    public TipoPaqueteNac getRequestedTipoPaqueteNacById() {
        if (requestedTipoPaqueteNacById == null) {
            requestedTipoPaqueteNacById = findTipoPaqueteNacById();
        }
        return requestedTipoPaqueteNacById;
    }
    
    @Named
    @Produces
    public TarifaPaquete getRequestedTarifaPaqueteById() {
        if (requestedTarifaPaqueteById == null) {
            requestedTarifaPaqueteById = findTarifaPaqueteById();
        }
        return requestedTarifaPaqueteById;
    }
    
    @Named
    @Produces
    public TarifaHabitacion getRequestedTarifaHabitacionById() {
        if (requestedTarifaHabitacionById == null) {
            requestedTarifaHabitacionById = findTarifaHabitacionById();
        }
        return requestedTarifaHabitacionById;
    }

    public Paquete findPaqueteById() {
        try {
            int id = Integer.parseInt(Util.getRequestParameter("idPaquete"));
            return paqueteFacadeLocal.find(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    public TipoPaqueteInt findTipoPaqueteIntById() {
        try {
            int id = Integer.parseInt(Util.getRequestParameter("idTipoPaqueteInt"));
            return tipoPaqueteIntFacadeLocal.find(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    public TipoPaqueteNac findTipoPaqueteNacById() {
        try {
            int id = Integer.parseInt(Util.getRequestParameter("idTipoPaqueteNac"));
            return tipoPaqueteNacFacadeLocal.find(id);
        } catch (Exception e) {
            return null;
        }
    }

    public TarifaPaquete findTarifaPaqueteById() {
        try {
            int id = Integer.parseInt(Util.getRequestParameter("idTarifaPaquete"));
            return tarifaPaqueteFacadeLocal.find(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    public TarifaHabitacion findTarifaHabitacionById() {
        try {
            int id = Integer.parseInt(Util.getRequestParameter("idTarifaHabitacion"));
            return tarifaHabitacionFacadeLocal.find(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Named
    @Produces
    public List<Paquete> getPaquetesPaged() {
        try {
            return paqueteFacadeLocal.findAll();

        } catch (Exception e) {
            return null;
        }

    }

//    @Named
//    @Produces
//    public List<SelectItem> getPaquetesItemsPaged() {
//        List<SelectItem> items = new ArrayList<SelectItem>();
//        List<Paquete> paquetes = paqueteFacadeLocal.findAll();
//        for (Paquete c : paquetes) {
//            items.add(new SelectItem(c, c.getNombre() + c.getPrimerApellido() + c.getSegundoApellido()));
//        }
//        return items;
//    }

    /**
     * @return the paquete
     */
    @Produces
    @Named
    public Paquete getPaquete() {
        return paquete;

    }
    
    @Produces
    @Named
    public TarifaPaquete getTarifaPaquete() {
        return tarifaPaquete;

    }
    
    @Produces
    @Named
    public TipoPaqueteInt getTipoPaqueteInt() {
        return tipoPaqueteInt;

    }
    
    @Produces
    @Named
    public TipoPaqueteNac getTipoPaqueteNac() {
        return tipoPaqueteNac;

    }
    
    @Produces
    @Named
    public TarifaHabitacion getTarifaHabitacion() {
        return tarifaHabitacion;

    }

    @PostConstruct
    public void initNewPaquete() {
        paquete = new Paquete();
        tarifaPaquete = new TarifaPaquete();
        tipoPaqueteInt = new TipoPaqueteInt();
        tipoPaqueteNac = new TipoPaqueteNac();
        tarifaHabitacion = new TarifaHabitacion();
    }

    /**
     * @return the tipoPaquete
     */
    public char getTipoPaquete() {
        return tipoPaquete;
    }

    /**
     * @param tipoPaquete the tipoPaquete to set
     */
    public void setTipoPaquete(char tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    /**
     * @return the tipoTarifa
     */
    public char getTipoTarifa() {
        return tipoTarifa;
    }

    /**
     * @param tipoTarifa the tipoTarifa to set
     */
    public void setTipoTarifa(char tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }
}
