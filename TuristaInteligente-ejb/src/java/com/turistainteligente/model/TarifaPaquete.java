/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HectorFlechaRoja
 */
@Entity
@Table(name = "tarifapaquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaPaquete.findAll", query = "SELECT t FROM TarifaPaquete t")})
public class TarifaPaquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTARIFA")
    private Integer idtarifa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ADULTONAC")
    private Double adultonac;
    @Column(name = "ADULTOEXT")
    private Double adultoext;
    @Column(name = "NINIONAC")
    private Double ninionac;
    @Column(name = "NINIOEXT")
    private Double ninioext;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private double total;
    @Column(name = "IMPUESTOS")
    private Double impuestos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INDINTER")
    private boolean indinter;
    @JoinColumn(name = "IDPROVEEDOR", referencedColumnName = "IDPROVEEDOR")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor idproveedor;
    @JoinColumn(name = "IDPAQUETE", referencedColumnName = "IDPAQUETE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paquete idpaquete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtarifa", fetch = FetchType.LAZY)
    private List<ReservacionTarifaPaq> reservacionTarifaPaqList;
    @OneToMany(mappedBy = "idtarifa", fetch = FetchType.LAZY)
    private List<Reservacion> reservacionList;

    public TarifaPaquete() {
    }

    public TarifaPaquete(Integer idtarifa) {
        this.idtarifa = idtarifa;
    }

    public TarifaPaquete(Integer idtarifa, double total, boolean indinter) {
        this.idtarifa = idtarifa;
        this.total = total;
        this.indinter = indinter;
    }

    public Integer getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Integer idtarifa) {
        this.idtarifa = idtarifa;
    }

    public Double getAdultonac() {
        return adultonac;
    }

    public void setAdultonac(Double adultonac) {
        this.adultonac = adultonac;
    }

    public Double getAdultoext() {
        return adultoext;
    }

    public void setAdultoext(Double adultoext) {
        this.adultoext = adultoext;
    }

    public Double getNinionac() {
        return ninionac;
    }

    public void setNinionac(Double ninionac) {
        this.ninionac = ninionac;
    }

    public Double getNinioext() {
        return ninioext;
    }

    public void setNinioext(Double ninioext) {
        this.ninioext = ninioext;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Double impuestos) {
        this.impuestos = impuestos;
    }

    public boolean getIndinter() {
        return indinter;
    }

    public void setIndinter(boolean indinter) {
        this.indinter = indinter;
    }

    public Proveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedor idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Paquete getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(Paquete idpaquete) {
        this.idpaquete = idpaquete;
    }

    @XmlTransient
    public List<ReservacionTarifaPaq> getReservacionTarifaPaqList() {
        return reservacionTarifaPaqList;
    }

    public void setReservacionTarifaPaqList(List<ReservacionTarifaPaq> reservacionTarifaPaqList) {
        this.reservacionTarifaPaqList = reservacionTarifaPaqList;
    }

    @XmlTransient
    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarifa != null ? idtarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaPaquete)) {
            return false;
        }
        TarifaPaquete other = (TarifaPaquete) object;
        if ((this.idtarifa == null && other.idtarifa != null) || (this.idtarifa != null && !this.idtarifa.equals(other.idtarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.TarifaPaquete[ idtarifa=" + idtarifa + " ]";
    }
    
}
