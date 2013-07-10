/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HectorFlechaRoja
 */
@Entity
@Table(name = "tipo_paquete_reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaqueteReservacion.findAll", query = "SELECT t FROM TipoPaqueteReservacion t")})
public class TipoPaqueteReservacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PAQUETE_RESERVACION")
    private Integer idTipoPaqueteReservacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TIPO_TARIFA")
    private String tipoTarifa;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION_SERVICIOS")
    private String descripcionServicios;
    @Size(max = 100)
    @Column(name = "HOTEL")
    private String hotel;
    @Size(max = 1000)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Size(max = 25)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Size(max = 25)
    @Column(name = "TIPO_VEHICULO")
    private String tipoVehiculo;
    @Size(max = 25)
    @Column(name = "TIPO_TRASLADO")
    private String tipoTraslado;
    @Size(max = 100)
    @Column(name = "LUGAR_SALIDA")
    private String lugarSalida;
    @Size(max = 100)
    @Column(name = "LUGAR_LLEGADA")
    private String lugarLlegada;
    @Size(max = 500)
    @Column(name = "DIRECCION")
    private String direccion;
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

    public TipoPaqueteReservacion() {
    }

    public TipoPaqueteReservacion(Integer idTipoPaqueteReservacion) {
        this.idTipoPaqueteReservacion = idTipoPaqueteReservacion;
    }

    public TipoPaqueteReservacion(Integer idTipoPaqueteReservacion, String tipoTarifa, String usrRegistro, Date fecRegistro) {
        this.idTipoPaqueteReservacion = idTipoPaqueteReservacion;
        this.tipoTarifa = tipoTarifa;
        this.usrRegistro = usrRegistro;
        this.fecRegistro = fecRegistro;
    }

    public Integer getIdTipoPaqueteReservacion() {
        return idTipoPaqueteReservacion;
    }

    public void setIdTipoPaqueteReservacion(Integer idTipoPaqueteReservacion) {
        this.idTipoPaqueteReservacion = idTipoPaqueteReservacion;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPaqueteReservacion != null ? idTipoPaqueteReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaqueteReservacion)) {
            return false;
        }
        TipoPaqueteReservacion other = (TipoPaqueteReservacion) object;
        if ((this.idTipoPaqueteReservacion == null && other.idTipoPaqueteReservacion != null) || (this.idTipoPaqueteReservacion != null && !this.idTipoPaqueteReservacion.equals(other.idTipoPaqueteReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.TipoPaqueteReservacion[ idTipoPaqueteReservacion=" + idTipoPaqueteReservacion + " ]";
    }
    
}
