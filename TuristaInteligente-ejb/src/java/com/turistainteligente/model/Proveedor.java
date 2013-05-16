/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
    @Column(name = "IDPROVEEDOR")
    private Integer idproveedor;
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CUENTABANCARIA")
    private String cuentabancaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "BANCO")
    private String banco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CEDULAJURIDICA")
    private String cedulajuridica;
    @Size(max = 50)
    @Column(name = "CUENTABANCARIA2")
    private String cuentabancaria2;
    @Column(name = "IND_SINPE")
    private Boolean indSinpe;
    @Column(name = "IND_CUENTA_CORRIENTE")
    private Boolean indCuentaCorriente;
    @Column(name = "IND_COLONES")
    private Boolean indColones;
    @Column(name = "IND_DOLARES")
    private Boolean indDolares;
    @Column(name = "IMP_SWIFT")
    private Boolean impSwift;
    @Column(name = "IMP_AVA")
    private Boolean impAva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISION")
    private Double comision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproveedor", fetch = FetchType.LAZY)
    private List<TarifaPaquete> tarifaPaqueteList;
    @OneToMany(mappedBy = "idproveedor", fetch = FetchType.LAZY)
    private List<Reservacion> reservacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproveedor", fetch = FetchType.LAZY)
    private List<ReservacionProveedor> reservacionProveedorList;

    public Proveedor() {
    }

    public Proveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Proveedor(Integer idproveedor, String nombre, String telefono, String cuentabancaria, String banco, String cedulajuridica) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cuentabancaria = cuentabancaria;
        this.banco = banco;
        this.cedulajuridica = cedulajuridica;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuentabancaria() {
        return cuentabancaria;
    }

    public void setCuentabancaria(String cuentabancaria) {
        this.cuentabancaria = cuentabancaria;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCedulajuridica() {
        return cedulajuridica;
    }

    public void setCedulajuridica(String cedulajuridica) {
        this.cedulajuridica = cedulajuridica;
    }

    public String getCuentabancaria2() {
        return cuentabancaria2;
    }

    public void setCuentabancaria2(String cuentabancaria2) {
        this.cuentabancaria2 = cuentabancaria2;
    }

    public Boolean getIndSinpe() {
        return indSinpe;
    }

    public void setIndSinpe(Boolean indSinpe) {
        this.indSinpe = indSinpe;
    }

    public Boolean getIndCuentaCorriente() {
        return indCuentaCorriente;
    }

    public void setIndCuentaCorriente(Boolean indCuentaCorriente) {
        this.indCuentaCorriente = indCuentaCorriente;
    }

    public Boolean getIndColones() {
        return indColones;
    }

    public void setIndColones(Boolean indColones) {
        this.indColones = indColones;
    }

    public Boolean getIndDolares() {
        return indDolares;
    }

    public void setIndDolares(Boolean indDolares) {
        this.indDolares = indDolares;
    }

    public Boolean getImpSwift() {
        return impSwift;
    }

    public void setImpSwift(Boolean impSwift) {
        this.impSwift = impSwift;
    }

    public Boolean getImpAva() {
        return impAva;
    }

    public void setImpAva(Boolean impAva) {
        this.impAva = impAva;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    @XmlTransient
    public List<TarifaPaquete> getTarifaPaqueteList() {
        return tarifaPaqueteList;
    }

    public void setTarifaPaqueteList(List<TarifaPaquete> tarifaPaqueteList) {
        this.tarifaPaqueteList = tarifaPaqueteList;
    }

    @XmlTransient
    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
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
        hash += (idproveedor != null ? idproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idproveedor == null && other.idproveedor != null) || (this.idproveedor != null && !this.idproveedor.equals(other.idproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turistainteligente.model.Proveedor[ idproveedor=" + idproveedor + " ]";
    }
    
}
