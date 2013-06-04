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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tarifa_reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaReservacion.findAll", query = "SELECT t FROM TarifaReservacion t")})
public class TarifaReservacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TARIFA_RESERVACION")
    private Integer idTarifaReservacion;
    @Column(name = "CANT_ADULTO_NAC")
    private Integer cantAdultoNac;
    @Column(name = "CANT_ADULTO_INT")
    private Integer cantAdultoInt;
    @Column(name = "CANT_NINIO_NAC")
    private Integer cantNinioNac;
    @Column(name = "CANT_NINIO_INT")
    private Integer cantNinioInt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_ADULTO_NAC")
    private BigDecimal montoAdultoNac;
    @Column(name = "MONTO_ADULTO_INT")
    private BigDecimal montoAdultoInt;
    @Column(name = "MONTO_NINIO_NAC")
    private BigDecimal montoNinioNac;
    @Column(name = "MONTO_NINIO_INT")
    private BigDecimal montoNinioInt;
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
    @Size(max = 20)
    @Column(name = "TIPO_HABITACION")
    private String tipoHabitacion;
    @Column(name = "CANTIDAD")
    private Short cantidad;
    @Column(name = "MONTO_PERSONA")
    private BigDecimal montoPersona;
    @Column(name = "MONTO_NINIO")
    private BigDecimal montoNinio;
    @OneToMany(mappedBy = "idTarifaReservacion", fetch = FetchType.LAZY)
    private List<Reservacion> reservacionList;

    public TarifaReservacion() {
    }

    public TarifaReservacion(Integer idTarifaReservacion) {
        this.idTarifaReservacion = idTarifaReservacion;
    }

    public TarifaReservacion(Integer idTarifaReservacion, String usrRegistro, Date fecRegistro) {
        this.idTarifaReservacion = idTarifaReservacion;
        this.usrRegistro = usrRegistro;
        this.fecRegistro = fecRegistro;
    }

    public Integer getIdTarifaReservacion() {
        return idTarifaReservacion;
    }

    public void setIdTarifaReservacion(Integer idTarifaReservacion) {
        this.idTarifaReservacion = idTarifaReservacion;
    }

    public Integer getCantAdultoNac() {
        return cantAdultoNac;
    }

    public void setCantAdultoNac(Integer cantAdultoNac) {
        this.cantAdultoNac = cantAdultoNac;
    }

    public Integer getCantAdultoInt() {
        return cantAdultoInt;
    }

    public void setCantAdultoInt(Integer cantAdultoInt) {
        this.cantAdultoInt = cantAdultoInt;
    }

    public Integer getCantNinioNac() {
        return cantNinioNac;
    }

    public void setCantNinioNac(Integer cantNinioNac) {
        this.cantNinioNac = cantNinioNac;
    }

    public Integer getCantNinioInt() {
        return cantNinioInt;
    }

    public void setCantNinioInt(Integer cantNinioInt) {
        this.cantNinioInt = cantNinioInt;
    }

    public BigDecimal getMontoAdultoNac() {
        return montoAdultoNac;
    }

    public void setMontoAdultoNac(BigDecimal montoAdultoNac) {
        this.montoAdultoNac = montoAdultoNac;
    }

    public BigDecimal getMontoAdultoInt() {
        return montoAdultoInt;
    }

    public void setMontoAdultoInt(BigDecimal montoAdultoInt) {
        this.montoAdultoInt = montoAdultoInt;
    }

    public BigDecimal getMontoNinioNac() {
        return montoNinioNac;
    }

    public void setMontoNinioNac(BigDecimal montoNinioNac) {
        this.montoNinioNac = montoNinioNac;
    }

    public BigDecimal getMontoNinioInt() {
        return montoNinioInt;
    }

    public void setMontoNinioInt(BigDecimal montoNinioInt) {
        this.montoNinioInt = montoNinioInt;
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

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMontoPersona() {
        return montoPersona;
    }

    public void setMontoPersona(BigDecimal montoPersona) {
        this.montoPersona = montoPersona;
    }

    public BigDecimal getMontoNinio() {
        return montoNinio;
    }

    public void setMontoNinio(BigDecimal montoNinio) {
        this.montoNinio = montoNinio;
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
        hash += (idTarifaReservacion != null ? idTarifaReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaReservacion)) {
            return false;
        }
        TarifaReservacion other = (TarifaReservacion) object;
        if ((this.idTarifaReservacion == null && other.idTarifaReservacion != null) || (this.idTarifaReservacion != null && !this.idTarifaReservacion.equals(other.idTarifaReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.TarifaReservacion[ idTarifaReservacion=" + idTarifaReservacion + " ]";
    }
    
}
