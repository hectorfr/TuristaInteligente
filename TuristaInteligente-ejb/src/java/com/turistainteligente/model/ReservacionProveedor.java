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
@Table(name = "reservacion_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservacionProveedor.findAll", query = "SELECT r FROM ReservacionProveedor r")})
public class ReservacionProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESERV_PROVEE")
    private Integer idReservProvee;
    @JoinColumn(name = "IDRESERVACION", referencedColumnName = "IDRESERVACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Reservacion idreservacion;
    @JoinColumn(name = "IDPROVEEDOR", referencedColumnName = "IDPROVEEDOR")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor idproveedor;

    public ReservacionProveedor() {
    }

    public ReservacionProveedor(Integer idReservProvee) {
        this.idReservProvee = idReservProvee;
    }

    public Integer getIdReservProvee() {
        return idReservProvee;
    }

    public void setIdReservProvee(Integer idReservProvee) {
        this.idReservProvee = idReservProvee;
    }

    public Reservacion getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Reservacion idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Proveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedor idproveedor) {
        this.idproveedor = idproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservProvee != null ? idReservProvee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservacionProveedor)) {
            return false;
        }
        ReservacionProveedor other = (ReservacionProveedor) object;
        if ((this.idReservProvee == null && other.idReservProvee != null) || (this.idReservProvee != null && !this.idReservProvee.equals(other.idReservProvee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.ReservacionProveedor[ idReservProvee=" + idReservProvee + " ]";
    }
    
}
