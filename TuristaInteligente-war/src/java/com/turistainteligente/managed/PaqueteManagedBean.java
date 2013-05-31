/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.managed;

import com.turistainteligente.facade.PaqueteFacadeLocal;
import com.turistainteligente.facade.TarifaHabitacionFacadeLocal;
import com.turistainteligente.facade.TarifaPaqueteFacadeLocal;
import com.turistainteligente.facade.TipoPaqueteIntFacadeLocal;
import com.turistainteligente.facade.TipoPaqueteNacFacadeLocal;
import com.turistainteligente.model.Paquete;
import com.turistainteligente.model.TarifaHabitacion;
import com.turistainteligente.model.TarifaPaquete;
import com.turistainteligente.model.TipoPaqueteInt;
import com.turistainteligente.model.TipoPaqueteNac;
import com.turistainteligente.model.Usuario;
import com.turistainteligente.qualifiers.LoggedIn;
import com.turistainteligente.util.Util;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author HectorFlechaRoja
 */
@Named(value = "paqueteManagedBean")
@RequestScoped
public class PaqueteManagedBean implements Serializable {

    /**
     * Creates a new instance of PaqueteManagedBean
     */
    public PaqueteManagedBean() {
    }
    @EJB
    private PaqueteFacadeLocal paqueteFacadeLocal;
    @EJB
    private TipoPaqueteIntFacadeLocal tipoPaqueteIntFacadeLocal;
    @EJB
    private TipoPaqueteNacFacadeLocal tipoPaqueteNacFacadeLocal;
    @EJB
    private TarifaHabitacionFacadeLocal tarifaHabitacionFacadeLocal;
    @EJB
    private TarifaPaqueteFacadeLocal tarifaPaqueteFacadeLocal;
    @Inject
    private PaqueteSessionBean paqueteSessionBean;
    private Paquete paquete;
    private Paquete requestedPaqueteById;
    private TarifaPaquete requestedTarifaPaqueteById;
    private TarifaHabitacion requestedTarifaHabitacionById;
    private TipoPaqueteInt requestedTipoPaqueteIntById;
    private TipoPaqueteNac requestedTipoPaqueteNacById;
    private String tipoPaquete;
    private String tipoTarifa;
    private char indPaquete;
    private char indTarifa;
    static final Logger log = Logger.getLogger(PaqueteManagedBean.class.getName());
    @Inject
    @LoggedIn
    private Usuario currentUser;

    public String create() {
        try {
//            se crea primero el tipo de tarifa
            if (getTipoTarifa().equals(Util.TipoTarifa.H.toString())) {
                getPaqueteSessionBean().getTarifaHabitacion().setUsrRegistro(currentUser.getEmail());
                getPaqueteSessionBean().getTarifaHabitacion().setFecRegistro(new Date());
                tarifaHabitacionFacadeLocal.create(getPaqueteSessionBean().getTarifaHabitacion());
            } else {
                getPaqueteSessionBean().getTarifaPaquete().setUsrRegistro(currentUser.getEmail());
                getPaqueteSessionBean().getTarifaPaquete().setFecRegistro(new Date());
                tarifaPaqueteFacadeLocal.create(getPaqueteSessionBean().getTarifaPaquete());
            }
//            se crea el tipo de paquete y se añade el tipo de tarifa
            if (getTipoPaquete().equals(Util.TipoPaquete.I.toString())) {
                if (getTipoTarifa().equals(Util.TipoTarifa.H.toString())) {
                    getPaqueteSessionBean().getTipoPaqueteInt().setTipoTarifa(Util.TipoTarifa.H.toString());
                    getPaqueteSessionBean().getTipoPaqueteInt().setIdTarifaHabitacion(getPaqueteSessionBean().getTarifaHabitacion());
                } else {
                    getPaqueteSessionBean().getTipoPaqueteInt().setTipoTarifa(Util.TipoTarifa.P.toString());
                    getPaqueteSessionBean().getTipoPaqueteInt().setIdTarifaPaquete(getPaqueteSessionBean().getTarifaPaquete());
                }
                getPaqueteSessionBean().getTipoPaqueteInt().setUsrRegistro(currentUser.getEmail());
                getPaqueteSessionBean().getTipoPaqueteInt().setFecRegistro(new Date());
                tipoPaqueteIntFacadeLocal.create(getPaqueteSessionBean().getTipoPaqueteInt());
                paquete.setIdTipoPaqueteInt(getPaqueteSessionBean().getTipoPaqueteInt());
            } else {
                if (getTipoTarifa().equals(Util.TipoTarifa.H.toString())) {
                    getPaqueteSessionBean().getTipoPaqueteNac().setTipoTarifa(Util.TipoTarifa.H.toString());
                    getPaqueteSessionBean().getTipoPaqueteNac().setIdTarifaHabitacion(getPaqueteSessionBean().getTarifaHabitacion());
                } else {
                    getPaqueteSessionBean().getTipoPaqueteNac().setTipoTarifa(Util.TipoTarifa.P.toString());
                    getPaqueteSessionBean().getTipoPaqueteNac().setIdTarifaPaquete(getPaqueteSessionBean().getTarifaPaquete());
                }
                getPaqueteSessionBean().getTipoPaqueteNac().setUsrRegistro(currentUser.getEmail());
                getPaqueteSessionBean().getTipoPaqueteNac().setFecRegistro(new Date());
                tipoPaqueteNacFacadeLocal.create(getPaqueteSessionBean().getTipoPaqueteNac());
                paquete.setIdTipoPaqueteNac(getPaqueteSessionBean().getTipoPaqueteNac());
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
            e.printStackTrace();
            return null;
        }
    }

    public String update() {
        try {
            //            se crea primero el tipo de tarifa
            if (getTipoTarifa().equals(Util.TipoTarifa.H.toString())) {
                getRequestedTarifaHabitacionById().setUsrModificacion(currentUser.getEmail());
                getRequestedTarifaHabitacionById().setFecModificacion(new Date());
                tarifaHabitacionFacadeLocal.edit(getRequestedTarifaHabitacionById());
            } else {
                getRequestedTarifaPaqueteById().setUsrModificacion(currentUser.getEmail());
                getRequestedTarifaPaqueteById().setFecModificacion(new Date());
                tarifaPaqueteFacadeLocal.edit(getRequestedTarifaPaqueteById());
            }
//            se crea el tipo de paquete y se añade el tipo de tarifa
            if (getTipoPaquete().equals(Util.TipoPaquete.I.toString())) {
                if (getTipoTarifa().equals(Util.TipoTarifa.H.toString())) {
                    getRequestedTipoPaqueteIntById().setTipoTarifa(Util.TipoTarifa.H.toString());
                    getRequestedTipoPaqueteIntById().setIdTarifaHabitacion(getRequestedTarifaHabitacionById());
                } else {
                    getRequestedTipoPaqueteIntById().setTipoTarifa(Util.TipoTarifa.P.toString());
                    getRequestedTipoPaqueteIntById().setIdTarifaPaquete(getRequestedTarifaPaqueteById());
                }
                getRequestedTipoPaqueteIntById().setUsrModificacion(currentUser.getEmail());
                getRequestedTipoPaqueteIntById().setFecModificacion(new Date());
                tipoPaqueteIntFacadeLocal.edit(getRequestedTipoPaqueteIntById());
                getRequestedPaqueteById().setIdTipoPaqueteInt(getRequestedTipoPaqueteIntById());
            } else {
                if (getTipoTarifa().equals(Util.TipoTarifa.H.toString())) {
                    getRequestedTipoPaqueteNacById().setTipoTarifa(Util.TipoTarifa.H.toString());
                    getRequestedTipoPaqueteNacById().setIdTarifaHabitacion(getRequestedTarifaHabitacionById());
                } else {
                    getRequestedTipoPaqueteNacById().setTipoTarifa(Util.TipoTarifa.P.toString());
                    getRequestedTipoPaqueteNacById().setIdTarifaPaquete(getRequestedTarifaPaqueteById());
                }
                getRequestedTipoPaqueteNacById().setUsrModificacion(currentUser.getEmail());
                getRequestedTipoPaqueteNacById().setFecModificacion(new Date());
                tipoPaqueteNacFacadeLocal.edit(getRequestedTipoPaqueteNacById());
                getRequestedPaqueteById().setIdTipoPaqueteNac(getRequestedTipoPaqueteNacById());
            }
            getRequestedPaqueteById().setUsrModificacion(currentUser.getEmail());
            getRequestedPaqueteById().setFecModificacion(new Date());
            paqueteFacadeLocal.edit(getRequestedPaqueteById());
            log.log(Level.INFO, "Paquete {0} modificado con exito", getRequestedPaqueteById().getIdPaquete());
            Util.addSuccessMessage("Paquete modificado con éxito");
            return "./listado.jsf";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al modificar el paquete {0}", e.getMessage());
            Util.addErrorMessage("Error al modificar el paquete");
            return null;
        }
    }

    public String delete() {
        try {
            if (getRequestedTarifaHabitacionById() != null) {
                tarifaHabitacionFacadeLocal.remove(getRequestedTarifaHabitacionById());
            } else if (getRequestedTarifaPaqueteById() != null) {
                tarifaPaqueteFacadeLocal.remove(getRequestedTarifaPaqueteById());
            }

            if (getRequestedTipoPaqueteIntById() != null) {
                tipoPaqueteIntFacadeLocal.remove(getRequestedTipoPaqueteIntById());
            } else if (getRequestedTipoPaqueteNacById() != null) {
                tipoPaqueteNacFacadeLocal.remove(getRequestedTipoPaqueteNacById());
            }
            paqueteFacadeLocal.remove(getRequestedPaqueteById());
            Util.addSuccessMessage("Paquete eliminado con éxito");
            log.log(Level.INFO, "Paquete {0} eliminado", getRequestedPaqueteById().getIdPaquete());
            return "./listado.jsf";
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error al eliminar el paquete{0}", e.getMessage());
            Util.addErrorMessage("Error al eliminar el paquete");
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

    @PostConstruct
    public void initNewPaquete() {
        paquete = new Paquete();
//        setTarifaPaquete(new TarifaPaquete());
//        setTipoPaqueteInt(new TipoPaqueteInt());
//        setTipoPaqueteNac(new TipoPaqueteNac());
//        setTarifaHabitacion(new TarifaHabitacion());
    }

    /**
     * @return the tipoPaquete
     */
    public String getTipoPaquete() {
        if (requestedTipoPaqueteIntById != null || requestedTipoPaqueteNacById != null) {
            tipoPaquete = requestedTipoPaqueteIntById != null ? Util.TipoPaquete.I.toString() : Util.TipoPaquete.N.toString();
        }
        return tipoPaquete;
    }

    /**
     * @param tipoPaquete the tipoPaquete to set
     */
    public void setTipoPaquete(String tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    /**
     * @return the tipoTarifa
     */
    public String getTipoTarifa() {
        if (requestedTarifaHabitacionById != null || requestedTarifaPaqueteById != null) {
            tipoTarifa = requestedTarifaHabitacionById != null ? Util.TipoTarifa.H.toString() : Util.TipoTarifa.P.toString();
        }
        return tipoTarifa;
    }

    /**
     * @param tipoTarifa the tipoTarifa to set
     */
    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    /**
     * @return the indPaquete
     */
    public char getIndPaquete() {
        if (getTipoPaquete() != null) {
            if (getTipoPaquete().equals(Util.TipoPaquete.I.toString())) {
                indPaquete = 'I';
            } else {
                indPaquete = 'N';
            }
        }
        return indPaquete;
    }

    /**
     * @param indPaquete the indPaquete to set
     */
    public void setIndPaquete(char indPaquete) {
        this.indPaquete = indPaquete;
    }

    /**
     * @return the indTarifa
     */
    public char getIndTarifa() {
        if (getTipoTarifa() != null) {
            if (getTipoTarifa().equals(Util.TipoTarifa.H.toString())) {
                indTarifa = 'H';
            } else {
                indTarifa = 'P';
            }
        }
        return indTarifa;
    }

    /**
     * @param indTarifa the indTarifa to set
     */
    public void setIndTarifa(char indTarifa) {
        this.indTarifa = indTarifa;
    }    

    /**
     * @return the paqueteSessionBean
     */
    public PaqueteSessionBean getPaqueteSessionBean() {
        return paqueteSessionBean;
    }

    /**
     * @param paqueteSessionBean the paqueteSessionBean to set
     */
    public void setPaqueteSessionBean(PaqueteSessionBean paqueteSessionBean) {
        this.paqueteSessionBean = paqueteSessionBean;
    }
}
