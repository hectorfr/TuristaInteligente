/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HectorFlechaRoja
 */
@Entity
@Table(name = "tipo_paquete_nac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaqueteNac.findAll", query = "SELECT t FROM TipoPaqueteNac t")})
public class TipoPaqueteNac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PAQUETE_NAC")
    private Integer idTipoPaqueteNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IND_TIPO_PAQUETE")
    private char indTipoPaquete;
    @Column(name = "IND_TIPO_HABITACION")
    private Character indTipoHabitacion;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION_SERVICIOS")
    private String descripcionServicios;
    @Size(max = 100)
    @Column(name = "HOTEL")
    private String hotel;
    @Size(max = 1000)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USR_REGISTRO")
    private String usrRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Size(max = 50)
    @Column(name = "USR_MODIFICACION")
    private String usrModificacion;
    @Column(name = "FEC_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @OneToMany(mappedBy = "idTipoPaqueteNac", fetch = FetchType.LAZY)
    private List<Paquete> paqueteList;
    @JoinColumn(name = "ID_TARIFA_PAQUETE", referencedColumnName = "ID_TARIFA_PAQUETE")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarifaPaquete idTarifaPaquete;

    public TipoPaqueteNac() {
    }

    public TipoPaqueteNac(Integer idTipoPaqueteNac) {
        this.idTipoPaqueteNac = idTipoPaqueteNac;
    }

    public TipoPaqueteNac(Integer idTipoPaqueteNac, char indTipoPaquete, String usrRegistro, Date fecRegistro) {
        this.idTipoPaqueteNac = idTipoPaqueteNac;
        this.indTipoPaquete = indTipoPaquete;
        this.usrRegistro = usrRegistro;
        this.fecRegistro = fecRegistro;
    }

    public Integer getIdTipoPaqueteNac() {
        return idTipoPaqueteNac;
    }

    public void setIdTipoPaqueteNac(Integer idTipoPaqueteNac) {
        this.idTipoPaqueteNac = idTipoPaqueteNac;
    }

    public char getIndTipoPaquete() {
        return indTipoPaquete;
    }

    public void setIndTipoPaquete(char indTipoPaquete) {
        this.indTipoPaquete = indTipoPaquete;
    }

    public Character getIndTipoHabitacion() {
        return indTipoHabitacion;
    }

    public void setIndTipoHabitacion(Character indTipoHabitacion) {
        this.indTipoHabitacion = indTipoHabitacion;
    }

    public String getDescripcionServicios() {
        return descripcionServicios;
    }

    public void setDescripcionServicios(String descripcionServicios) {
        this.descripcionServicios = descripcionServicios;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUsrRegistro() {
        return usrRegistro;
    }

    public void setUsrRegistro(String usrRegistro) {
        this.usrRegistro = usrRegistro;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getUsrModificacion() {
        return usrModificacion;
    }

    public void setUsrModificacion(String usrModificacion) {
        this.usrModificacion = usrModificacion;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    @XmlTransient
    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public void setPaqueteList(List<Paquete> paqueteList) {
        this.paqueteList = paqueteList;
    }

    public TarifaPaquete getIdTarifaPaquete() {
        return idTarifaPaquete;
    }

    public void setIdTarifaPaquete(TarifaPaquete idTarifaPaquete) {
        this.idTarifaPaquete = idTarifaPaquete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPaqueteNac != null ? idTipoPaqueteNac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaqueteNac)) {
            return false;
        }
        TipoPaqueteNac other = (TipoPaqueteNac) object;
        if ((this.idTipoPaqueteNac == null && other.idTipoPaqueteNac != null) || (this.idTipoPaqueteNac != null && !this.idTipoPaqueteNac.equals(other.idTipoPaqueteNac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.TipoPaqueteNac[ idTipoPaqueteNac=" + idTipoPaqueteNac + " ]";
    }
    
}
