/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.managed;

import com.turistainteligente.model.TarifaHabitacion;
import com.turistainteligente.model.TarifaPaquete;
import com.turistainteligente.model.TipoPaqueteInt;
import com.turistainteligente.model.TipoPaqueteNac;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author HectorFlechaRoja
 */
@Named(value = "paqueteSessionBean")
@SessionScoped
public class PaqueteSessionBean implements Serializable {
    private TarifaPaquete tarifaPaquete;
    private TarifaHabitacion tarifaHabitacion;
    private TipoPaqueteInt tipoPaqueteInt;
    private TipoPaqueteNac tipoPaqueteNac;
    private int cantidad;
    /**
     * Creates a new instance of PaqueteSessionBean
     */
    public PaqueteSessionBean() {
    }

    /**
     * @return the tarifaPaquete
     */
    public TarifaPaquete getTarifaPaquete() {
        if(tarifaPaquete == null) {
            tarifaPaquete = new TarifaPaquete();
        }
        return tarifaPaquete;
    }

    /**
     * @param tarifaPaquete the tarifaPaquete to set
     */
    public void setTarifaPaquete(TarifaPaquete tarifaPaquete) {
        this.tarifaPaquete = tarifaPaquete;
    }

    /**
     * @return the tarifaHabitacion
     */
    public TarifaHabitacion getTarifaHabitacion() {
        if(tarifaHabitacion == null) {
            tarifaHabitacion = new TarifaHabitacion();
        }
        return tarifaHabitacion;
    }

    /**
     * @param tarifaHabitacion the tarifaHabitacion to set
     */
    public void setTarifaHabitacion(TarifaHabitacion tarifaHabitacion) {
        this.tarifaHabitacion = tarifaHabitacion;
    }

    /**
     * @return the tipoPaqueteInt
     */
    public TipoPaqueteInt getTipoPaqueteInt() {
        if(tipoPaqueteInt == null) {
            tipoPaqueteInt = new TipoPaqueteInt();
        }
        return tipoPaqueteInt;
    }

    /**
     * @param tipoPaqueteInt the tipoPaqueteInt to set
     */
    public void setTipoPaqueteInt(TipoPaqueteInt tipoPaqueteInt) {
        this.tipoPaqueteInt = tipoPaqueteInt;
    }

    /**
     * @return the tipoPaqueteNac
     */
    public TipoPaqueteNac getTipoPaqueteNac() {
        if(tipoPaqueteNac == null) {
            tipoPaqueteNac = new TipoPaqueteNac();
        }
        return tipoPaqueteNac;
    }

    /**
     * @param tipoPaqueteNac the tipoPaqueteNac to set
     */
    public void setTipoPaqueteNac(TipoPaqueteNac tipoPaqueteNac) {
        this.tipoPaqueteNac = tipoPaqueteNac;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
