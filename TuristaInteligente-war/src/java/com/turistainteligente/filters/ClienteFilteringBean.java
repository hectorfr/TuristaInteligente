/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.filters;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author HectorFlechaRoja
 */
@ManagedBean
@ViewScoped
public class ClienteFilteringBean implements Serializable {
    private String nombreFilter;
    private String emailFilter;
    private String telefonoFilter;
    /**
     * Creates a new instance of clienteFilteringBean
     */
    public ClienteFilteringBean() {
    }

    /**
     * @return the nombreFilter
     */
    public String getNombreFilter() {
        return nombreFilter;
    }

    /**
     * @param nombreFilter the nombreFilter to set
     */
    public void setNombreFilter(String nombreFilter) {
        this.nombreFilter = nombreFilter;
    }

    /**
     * @return the emailFilter
     */
    public String getEmailFilter() {
        return emailFilter;
    }

    /**
     * @param emailFilter the emailFilter to set
     */
    public void setEmailFilter(String emailFilter) {
        this.emailFilter = emailFilter;
    }

    /**
     * @return the telefonoFilter
     */
    public String getTelefonoFilter() {
        return telefonoFilter;
    }

    /**
     * @param telefonoFilter the telefonoFilter to set
     */
    public void setTelefonoFilter(String telefonoFilter) {
        this.telefonoFilter = telefonoFilter;
    }
}
