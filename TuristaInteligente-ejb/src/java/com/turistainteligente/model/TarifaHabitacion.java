/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "tarifa_habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaHabitacion.findAll", query = "SELECT t FROM TarifaHabitacion t")})
public class TarifaHabitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TARIFA_HABITACION")
    private Integer idTarifaHabitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_HABITACION")
    private String tipoHabitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private short cantidad;
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
    @OneToMany(mappedBy = "idTarifaHabitacion", fetch = FetchType.LAZY)
    private List<TipoPaqueteNac> tipoPaqueteNacList;
    @OneToMany(mappedBy = "idTarifaHabitacion", fetch = FetchType.LAZY)
    private List<TipoPaqueteInt> tipoPaqueteIntList;
    @NotNull
    @Column(name = "MONTO_PERSONA")
    private BigDecimal montoPersona;
    @Column(name = "MONTO_PERSONA")
    private BigDecimal montoNinio;

    public TarifaHabitacion() {
    }

    public TarifaHabitacion(Integer idTarifaHabitacion) {
        this.idTarifaHabitacion = idTarifaHabitacion;
    }

    public TarifaHabitacion(Integer idTarifaHabitacion, String tipoHabitacion, short cantidad, String usrRegistro, Date fecRegistro) {
        this.idTarifaHabitacion = idTarifaHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.cantidad = cantidad;
        this.usrRegistro = usrRegistro;
        this.fecRegistro = fecRegistro;
    }

    public Integer getIdTarifaHabitacion() {
        return idTarifaHabitacion;
    }

    public void setIdTarifaHabitacion(Integer idTarifaHabitacion) {
        this.idTarifaHabitacion = idTarifaHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
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
    public List<TipoPaqueteNac> getTipoPaqueteNacList() {
        return tipoPaqueteNacList;
    }

    public void setTipoPaqueteNacList(List<TipoPaqueteNac> tipoPaqueteNacList) {
        this.tipoPaqueteNacList = tipoPaqueteNacList;
    }

    @XmlTransient
    public List<TipoPaqueteInt> getTipoPaqueteIntList() {
        return tipoPaqueteIntList;
    }

    public void setTipoPaqueteIntList(List<TipoPaqueteInt> tipoPaqueteIntList) {
        this.tipoPaqueteIntList = tipoPaqueteIntList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifaHabitacion != null ? idTarifaHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaHabitacion)) {
            return false;
        }
        TarifaHabitacion other = (TarifaHabitacion) object;
        if ((this.idTarifaHabitacion == null && other.idTarifaHabitacion != null) || (this.idTarifaHabitacion != null && !this.idTarifaHabitacion.equals(other.idTarifaHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.TarifaHabitacion[ idTarifaHabitacion=" + idTarifaHabitacion + " ]";
    }

    /**
     * @return the montoPersona
     */
    public BigDecimal getMontoPersona() {
        return montoPersona;
    }

    /**
     * @param montoPersona the montoPersona to set
     */
    public void setMontoPersona(BigDecimal montoPersona) {
        this.montoPersona = montoPersona;
    }

    /**
     * @return the montoNinio
     */
    public BigDecimal getMontoNinio() {
        return montoNinio;
    }

    /**
     * @param montoNinio the montoNinio to set
     */
    public void setMontoNinio(BigDecimal montoNinio) {
        this.montoNinio = montoNinio;
    }
    
}
