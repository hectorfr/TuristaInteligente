/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tarifaneta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaNeta.findAll", query = "SELECT t FROM TarifaNeta t")})
public class TarifaNeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTARIFANETA")
    private Integer idtarifaneta;
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
    @OneToMany(mappedBy = "idtarifaneta", fetch = FetchType.LAZY)
    private List<Reservacion> reservacionList;

    public TarifaNeta() {
    }

    public TarifaNeta(Integer idtarifaneta) {
        this.idtarifaneta = idtarifaneta;
    }

    public TarifaNeta(Integer idtarifaneta, double total) {
        this.idtarifaneta = idtarifaneta;
        this.total = total;
    }

    public Integer getIdtarifaneta() {
        return idtarifaneta;
    }

    public void setIdtarifaneta(Integer idtarifaneta) {
        this.idtarifaneta = idtarifaneta;
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
        hash += (idtarifaneta != null ? idtarifaneta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaNeta)) {
            return false;
        }
        TarifaNeta other = (TarifaNeta) object;
        if ((this.idtarifaneta == null && other.idtarifaneta != null) || (this.idtarifaneta != null && !this.idtarifaneta.equals(other.idtarifaneta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.TarifaNeta[ idtarifaneta=" + idtarifaneta + " ]";
    }
    
}
