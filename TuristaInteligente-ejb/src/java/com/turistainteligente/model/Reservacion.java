/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import com.turistainteligente.util.Util;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r")})
public class Reservacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESERVACION")
    private Integer idReservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IND_ESTADO")
    private char indEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_CONFIRMACION")
    private String numConfirmacion;
    @Column(name = "FECHA_PAGO_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPagoInicio;
    @Column(name = "FECHA_PAGO_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPagoFinal;
    @Column(name = "FECHA_LLEGADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
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
    @JoinTable(name = "proveedores_reservacion", joinColumns = {
        @JoinColumn(name = "ID_RESERVACION", referencedColumnName = "ID_RESERVACION")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Proveedor> proveedorList;
    @JoinColumn(name = "ID_TARIFA_RESERVACION", referencedColumnName = "ID_TARIFA_RESERVACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarifaReservacion idTarifaReservacion;
    @JoinColumn(name = "ID_PAQUETE", referencedColumnName = "ID_PAQUETE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paquete idPaquete;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "ID_TIPO_PAQUETE_RESERVACION", referencedColumnName = "ID_TIPO_PAQUETE_RESERVACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoPaqueteReservacion idTipoPaqueteReservacion;

    public Reservacion() {
    }

    public Reservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Reservacion(Integer idReservacion, char indEstado, String numConfirmacion, String usrRegistro, Date fecRegistro) {
        this.idReservacion = idReservacion;
        this.indEstado = indEstado;
        this.numConfirmacion = numConfirmacion;
        this.usrRegistro = usrRegistro;
        this.fecRegistro = fecRegistro;
    }

    public Integer getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public char getIndEstado() {
        return indEstado;
    }

    public void setIndEstado(char indEstado) {
        this.indEstado = indEstado;
    }

    public String getNumConfirmacion() {
        return numConfirmacion;
    }

    public void setNumConfirmacion(String numConfirmacion) {
        this.numConfirmacion = numConfirmacion;
    }

    public Date getFechaPagoInicio() {
        return fechaPagoInicio;
    }

    public void setFechaPagoInicio(Date fechaPagoInicio) {
        this.fechaPagoInicio = fechaPagoInicio;
    }

    public Date getFechaPagoFinal() {
        return fechaPagoFinal;
    }

    public void setFechaPagoFinal(Date fechaPagoFinal) {
        this.fechaPagoFinal = fechaPagoFinal;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    public TarifaReservacion getIdTarifaReservacion() {
        return idTarifaReservacion;
    }

    public void setIdTarifaReservacion(TarifaReservacion idTarifaReservacion) {
        this.idTarifaReservacion = idTarifaReservacion;
    }

    public Paquete getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Paquete idPaquete) {
        this.idPaquete = idPaquete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservacion != null ? idReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.idReservacion == null && other.idReservacion != null) || (this.idReservacion != null && !this.idReservacion.equals(other.idReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.Reservacion[ idReservacion=" + idReservacion + " ]";
    }

    /**
     * @return the idCliente
     */
    public Cliente getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idTipoPaqueteReservacion
     */
    public TipoPaqueteReservacion getIdTipoPaqueteReservacion() {
        return idTipoPaqueteReservacion;
    }

    /**
     * @param idTipoPaqueteReservacion the idTipoPaqueteReservacion to set
     */
    public void setIdTipoPaqueteReservacion(TipoPaqueteReservacion idTipoPaqueteReservacion) {
        this.idTipoPaqueteReservacion = idTipoPaqueteReservacion;
    }
    
    public String getEstadoFormat() {
        if(getIndEstado() == Util.RES_CONFIRMADA) {
            return "Confirmada";
        } else if(getIndEstado() == Util.RES_COTIZADA) {
            return "Cotizada";
        } else {
            return "Pagada";
        }
    }
    
}
