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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tipo_paquete_int")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaqueteInt.findAll", query = "SELECT t FROM TipoPaqueteInt t")})
public class TipoPaqueteInt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PAQUETE_INT")
    private Integer idTipoPaqueteInt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Size(max = 25)
    @Column(name = "TIPO_VEHICULO")
    private String tipoVehiculo;
    @Size(max = 25)
    @Column(name = "TIPO_TRASLADO")
    private String tipoTraslado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TIPO_TARIFA")
    private String tipoTarifa;
    @Size(max = 100)
    @Column(name = "LUGAR_SALIDA")
    private String lugarSalida;
    @Size(max = 100)
    @Column(name = "LUGAR_LLEGADA")
    private String lugarLlegada;
    @Size(max = 500)
    @Column(name = "DIRECCION")
    private String direccion;
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
    @OneToMany(mappedBy = "idTipoPaqueteInt", fetch = FetchType.LAZY)
    private List<Paquete> paqueteList;
    @JoinColumn(name = "ID_TARIFA_PAQUETE", referencedColumnName = "ID_TARIFA_PAQUETE")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarifaPaquete idTarifaPaquete;
    @JoinColumn(name = "ID_TARIFA_HABITACION", referencedColumnName = "ID_TARIFA_HABITACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarifaHabitacion idTarifaHabitacion;

    public TipoPaqueteInt() {
    }

    public TipoPaqueteInt(Integer idTipoPaqueteInt) {
        this.idTipoPaqueteInt = idTipoPaqueteInt;
    }

    public TipoPaqueteInt(Integer idTipoPaqueteInt, String localidad, String tipoTarifa, String usrRegistro, Date fecRegistro) {
        this.idTipoPaqueteInt = idTipoPaqueteInt;
        this.localidad = localidad;
        this.tipoTarifa = tipoTarifa;
        this.usrRegistro = usrRegistro;
        this.fecRegistro = fecRegistro;
    }

    public Integer getIdTipoPaqueteInt() {
        return idTipoPaqueteInt;
    }

    public void setIdTipoPaqueteInt(Integer idTipoPaqueteInt) {
        this.idTipoPaqueteInt = idTipoPaqueteInt;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoTraslado() {
        return tipoTraslado;
    }

    public void setTipoTraslado(String tipoTraslado) {
        this.tipoTraslado = tipoTraslado;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public String getLugarSalida() {
        return lugarSalida;
    }

    public void setLugarSalida(String lugarSalida) {
        this.lugarSalida = lugarSalida;
    }

    public String getLugarLlegada() {
        return lugarLlegada;
    }

    public void setLugarLlegada(String lugarLlegada) {
        this.lugarLlegada = lugarLlegada;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public TarifaHabitacion getIdTarifaHabitacion() {
        return idTarifaHabitacion;
    }

    public void setIdTarifaHabitacion(TarifaHabitacion idTarifaHabitacion) {
        this.idTarifaHabitacion = idTarifaHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPaqueteInt != null ? idTipoPaqueteInt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaqueteInt)) {
            return false;
        }
        TipoPaqueteInt other = (TipoPaqueteInt) object;
        if ((this.idTipoPaqueteInt == null && other.idTipoPaqueteInt != null) || (this.idTipoPaqueteInt != null && !this.idTipoPaqueteInt.equals(other.idTipoPaqueteInt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.TipoPaqueteInt[ idTipoPaqueteInt=" + idTipoPaqueteInt + " ]";
    }
    
}
