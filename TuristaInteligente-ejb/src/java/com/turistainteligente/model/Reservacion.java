/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
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
@Table(name = "reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r")})
public class Reservacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESERVACION")
    private Integer idreservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHARESERVACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHASALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalida;
    @Size(max = 10)
    @Column(name = "HORARECOGIDA")
    private String horarecogida;
    @Size(max = 100)
    @Column(name = "LUGARRECOGIDA")
    private String lugarrecogida;
    @Size(max = 200)
    @Column(name = "CLIENTES")
    private String clientes;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "DESCRIPCIONSERVICIO")
    private String descripcionservicio;
    @Lob
    @Size(max = 65535)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Size(max = 50)
    @Column(name = "usuarioMod")
    private String usuarioMod;
    @Column(name = "fechaMod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreservacion", fetch = FetchType.LAZY)
    private List<ReservacionTarifaPaq> reservacionTarifaPaqList;
    @JoinColumn(name = "IDTARIFA", referencedColumnName = "IDTARIFA")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarifaPaquete idtarifa;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente idcliente;
    @JoinColumn(name = "IDPROVEEDOR", referencedColumnName = "IDPROVEEDOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor idproveedor;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "IDTARIFANETA", referencedColumnName = "IDTARIFANETA")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarifaNeta idtarifaneta;
    @JoinColumn(name = "IDHOTEL", referencedColumnName = "IDHOTEL")
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel idhotel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreservacion", fetch = FetchType.LAZY)
    private List<ReservacionProveedor> reservacionProveedorList;

    public Reservacion() {
    }

    public Reservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Reservacion(Integer idreservacion, Date fechareservacion, Date fechaentrada, Date fechasalida, String descripcionservicio, Date fechaCreacion) {
        this.idreservacion = idreservacion;
        this.fechareservacion = fechareservacion;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.descripcionservicio = descripcionservicio;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Date getFechareservacion() {
        return fechareservacion;
    }

    public void setFechareservacion(Date fechareservacion) {
        this.fechareservacion = fechareservacion;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getHorarecogida() {
        return horarecogida;
    }

    public void setHorarecogida(String horarecogida) {
        this.horarecogida = horarecogida;
    }

    public String getLugarrecogida() {
        return lugarrecogida;
    }

    public void setLugarrecogida(String lugarrecogida) {
        this.lugarrecogida = lugarrecogida;
    }

    public String getClientes() {
        return clientes;
    }

    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    public String getDescripcionservicio() {
        return descripcionservicio;
    }

    public void setDescripcionservicio(String descripcionservicio) {
        this.descripcionservicio = descripcionservicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUsuarioMod() {
        return usuarioMod;
    }

    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<ReservacionTarifaPaq> getReservacionTarifaPaqList() {
        return reservacionTarifaPaqList;
    }

    public void setReservacionTarifaPaqList(List<ReservacionTarifaPaq> reservacionTarifaPaqList) {
        this.reservacionTarifaPaqList = reservacionTarifaPaqList;
    }

    public TarifaPaquete getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(TarifaPaquete idtarifa) {
        this.idtarifa = idtarifa;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Proveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedor idproveedor) {
        this.idproveedor = idproveedor;
    }    

    public TarifaNeta getIdtarifaneta() {
        return idtarifaneta;
    }

    public void setIdtarifaneta(TarifaNeta idtarifaneta) {
        this.idtarifaneta = idtarifaneta;
    }

    public Hotel getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(Hotel idhotel) {
        this.idhotel = idhotel;
    }

    @XmlTransient
    public List<ReservacionProveedor> getReservacionProveedorList() {
        return reservacionProveedorList;
    }

    public void setReservacionProveedorList(List<ReservacionProveedor> reservacionProveedorList) {
        this.reservacionProveedorList = reservacionProveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservacion != null ? idreservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.idreservacion == null && other.idreservacion != null) || (this.idreservacion != null && !this.idreservacion.equals(other.idreservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.Reservacion[ idreservacion=" + idreservacion + " ]";
    }

    /**
     * @return the idUsuario
     */
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
