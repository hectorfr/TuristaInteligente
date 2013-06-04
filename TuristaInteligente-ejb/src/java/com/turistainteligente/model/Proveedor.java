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
import javax.persistence.ManyToMany;
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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 25)
    @Column(name = "SEGUNDO_TELEFONO")
    private String segundoTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRIMERA_CUENTA")
    private String primeraCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BANCO_PRIM_CUENTA")
    private String bancoPrimCuenta;
    @Size(max = 50)
    @Column(name = "SEGUNDA_CUENTA")
    private String segundaCuenta;
    @Size(max = 50)
    @Column(name = "BANCO_SDA_CUENTA")
    private String bancoSdaCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IND_SINPE_PRIM_CUENTA")
    private char indSinpePrimCuenta;
    @Column(name = "IND_SINPE_SDA_CUENTA")
    private Character indSinpeSdaCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IND_MONEDA_PRIM_CUENTA")
    private char indMonedaPrimCuenta;
    @Column(name = "IND_MONEDA_SDA_CUENTA")
    private Character indMonedaSdaCuenta;
    @Column(name = "IND_IMP_SWIFT")
    private Character indImpSwift;
    @Column(name = "IND_IMP_AVA")
    private Character indImpAva;
    @Column(name = "IND_COMISION")
    private Character indComision;
    @Column(name = "IND_CREDITO")
    private Character indCredito;
    @Column(name = "CANT_DIAS_CREDITO")
    private Integer cantDiasCredito;
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
    @ManyToMany(mappedBy = "proveedorList", fetch = FetchType.LAZY)
    private List<Reservacion> reservacionList;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(Integer idProveedor, String nombre, String telefono, String primeraCuenta, String bancoPrimCuenta, char indSinpePrimCuenta, char indMonedaPrimCuenta, String usrRegistro, Date fecRegistro) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.primeraCuenta = primeraCuenta;
        this.bancoPrimCuenta = bancoPrimCuenta;
        this.indSinpePrimCuenta = indSinpePrimCuenta;
        this.indMonedaPrimCuenta = indMonedaPrimCuenta;
        this.usrRegistro = usrRegistro;
        this.fecRegistro = fecRegistro;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSegundoTelefono() {
        return segundoTelefono;
    }

    public void setSegundoTelefono(String segundoTelefono) {
        this.segundoTelefono = segundoTelefono;
    }

    public String getPrimeraCuenta() {
        return primeraCuenta;
    }

    public void setPrimeraCuenta(String primeraCuenta) {
        this.primeraCuenta = primeraCuenta;
    }

    public String getBancoPrimCuenta() {
        return bancoPrimCuenta;
    }

    public void setBancoPrimCuenta(String bancoPrimCuenta) {
        this.bancoPrimCuenta = bancoPrimCuenta;
    }

    public String getSegundaCuenta() {
        return segundaCuenta;
    }

    public void setSegundaCuenta(String segundaCuenta) {
        this.segundaCuenta = segundaCuenta;
    }

    public String getBancoSdaCuenta() {
        return bancoSdaCuenta;
    }

    public void setBancoSdaCuenta(String bancoSdaCuenta) {
        this.bancoSdaCuenta = bancoSdaCuenta;
    }

    public char getIndSinpePrimCuenta() {
        return indSinpePrimCuenta;
    }

    public void setIndSinpePrimCuenta(char indSinpePrimCuenta) {
        this.indSinpePrimCuenta = indSinpePrimCuenta;
    }

    public Character getIndSinpeSdaCuenta() {
        return indSinpeSdaCuenta;
    }

    public void setIndSinpeSdaCuenta(Character indSinpeSdaCuenta) {
        this.indSinpeSdaCuenta = indSinpeSdaCuenta;
    }

    public char getIndMonedaPrimCuenta() {
        return indMonedaPrimCuenta;
    }

    public void setIndMonedaPrimCuenta(char indMonedaPrimCuenta) {
        this.indMonedaPrimCuenta = indMonedaPrimCuenta;
    }

    public Character getIndMonedaSdaCuenta() {
        return indMonedaSdaCuenta;
    }

    public void setIndMonedaSdaCuenta(Character indMonedaSdaCuenta) {
        this.indMonedaSdaCuenta = indMonedaSdaCuenta;
    }

    public Character getIndImpSwift() {
        return indImpSwift;
    }

    public void setIndImpSwift(Character indImpSwift) {
        this.indImpSwift = indImpSwift;
    }

    public Character getIndImpAva() {
        return indImpAva;
    }

    public void setIndImpAva(Character indImpAva) {
        this.indImpAva = indImpAva;
    }

    public Character getIndComision() {
        return indComision;
    }

    public void setIndComision(Character indComision) {
        this.indComision = indComision;
    }

    public Character getIndCredito() {
        return indCredito;
    }

    public void setIndCredito(Character indCredito) {
        this.indCredito = indCredito;
    }

    public Integer getCantDiasCredito() {
        return cantDiasCredito;
    }

    public void setCantDiasCredito(Integer cantDiasCredito) {
        this.cantDiasCredito = cantDiasCredito;
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
    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
