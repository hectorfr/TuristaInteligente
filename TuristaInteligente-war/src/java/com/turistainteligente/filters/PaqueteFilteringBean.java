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
public class PaqueteFilteringBean implements Serializable {
    private String nombreFilter;
    
    /**
     * Creates a new instance of clienteFilteringBean
     */
    public PaqueteFilteringBean() {
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
}
