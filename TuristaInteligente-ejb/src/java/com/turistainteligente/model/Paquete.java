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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HectorFlechaRoja
 */
@Entity
@Table(name = "paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquete.findAll", query = "SELECT p FROM Paquete p")})
public class Paquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPAQUETE")
    private Integer idpaquete;
    @Column(name = "ADULTONAC")
    private Integer adultonac;
    @Column(name = "ADULTOEXT")
    private Integer adultoext;
    @Column(name = "NINIONAC")
    private Integer ninionac;
    @Column(name = "NINIOEXT")
    private Integer ninioext;
    @OneToMany(mappedBy = "idpaquete", fetch = FetchType.LAZY)
    private List<TarifaPaquete> tarifaPaqueteList;

    public Paquete() {
    }

    public Paquete(Integer idpaquete) {
        this.idpaquete = idpaquete;
    }

    public Integer getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(Integer idpaquete) {
        this.idpaquete = idpaquete;
    }

    public Integer getAdultonac() {
        return adultonac;
    }

    public void setAdultonac(Integer adultonac) {
        this.adultonac = adultonac;
    }

    public Integer getAdultoext() {
        return adultoext;
    }

    public void setAdultoext(Integer adultoext) {
        this.adultoext = adultoext;
    }

    public Integer getNinionac() {
        return ninionac;
    }

    public void setNinionac(Integer ninionac) {
        this.ninionac = ninionac;
    }

    public Integer getNinioext() {
        return ninioext;
    }

    public void setNinioext(Integer ninioext) {
        this.ninioext = ninioext;
    }

    @XmlTransient
    public List<TarifaPaquete> getTarifaPaqueteList() {
        return tarifaPaqueteList;
    }

    public void setTarifaPaqueteList(List<TarifaPaquete> tarifaPaqueteList) {
        this.tarifaPaqueteList = tarifaPaqueteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaquete != null ? idpaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.idpaquete == null && other.idpaquete != null) || (this.idpaquete != null && !this.idpaquete.equals(other.idpaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.Paquete[ idpaquete=" + idpaquete + " ]";
    }
    
}
