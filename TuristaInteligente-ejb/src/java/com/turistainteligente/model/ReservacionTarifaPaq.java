/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HectorFlechaRoja
 */
@Entity
@Table(name = "reservacion_tarifapaq")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservacionTarifaPaq.findAll", query = "SELECT r FROM ReservacionTarifaPaq r")})
public class ReservacionTarifaPaq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESERV_TARIFPAQ")
    private Integer idReservTarifpaq;
    @JoinColumn(name = "IDTARIFA", referencedColumnName = "IDTARIFA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TarifaPaquete idtarifa;
    @JoinColumn(name = "IDRESERVACION", referencedColumnName = "IDRESERVACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Reservacion idreservacion;

    public ReservacionTarifaPaq() {
    }

    public ReservacionTarifaPaq(Integer idReservTarifpaq) {
        this.idReservTarifpaq = idReservTarifpaq;
    }

    public Integer getIdReservTarifpaq() {
        return idReservTarifpaq;
    }

    public void setIdReservTarifpaq(Integer idReservTarifpaq) {
        this.idReservTarifpaq = idReservTarifpaq;
    }

    public TarifaPaquete getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(TarifaPaquete idtarifa) {
        this.idtarifa = idtarifa;
    }

    public Reservacion getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Reservacion idreservacion) {
        this.idreservacion = idreservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservTarifpaq != null ? idReservTarifpaq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservacionTarifaPaq)) {
            return false;
        }
        ReservacionTarifaPaq other = (ReservacionTarifaPaq) object;
        if ((this.idReservTarifpaq == null && other.idReservTarifpaq != null) || (this.idReservTarifpaq != null && !this.idReservTarifpaq.equals(other.idReservTarifpaq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.ReservacionTarifaPaq[ idReservTarifpaq=" + idReservTarifpaq + " ]";
    }
    
}
