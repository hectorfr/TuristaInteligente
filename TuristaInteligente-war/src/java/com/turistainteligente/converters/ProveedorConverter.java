/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.converters;

import com.turistainteligente.facade.ProveedorFacadeLocal;
import com.turistainteligente.model.Proveedor;
import com.turistainteligente.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author HectorFlechaRoja
 */
@Named(value = "proveedorConverter")
@RequestScoped
public class ProveedorConverter implements Converter, Serializable {
    @EJB
    private ProveedorFacadeLocal proveedorFacade;
    
    /**
     * Creates a new instance of ProveedorConverter
     */
    public ProveedorConverter() {
    }
    
    /**
     *
     * @param context
     * @param component
     * @param newValue
     * @return
     * @throws ConverterException
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String newValue)
            throws ConverterException {

        if (newValue == null) {
            return null;
        }
        /*
         * try { InitialContext ic = new InitialContext(); actoFacade =
         * (ActoFacade) ic.lookup("java:comp/env/ejb/ActoFacade"); } catch
         * (NamingException e) { e.printStackTrace();
        }
         */
        return proveedorFacade.find(Integer.parseInt(newValue));
    }
    
    /**
     *
     * @param context
     * @param component
     * @param objValue
     * @return
     * @throws ConverterException
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objValue)
            throws ConverterException {

        if (objValue == null) {
            return "";
        }
        if (!(objValue instanceof Proveedor)) {
            Util.addError("No se pudo convertir la clase");
        }
        Proveedor p = (Proveedor) objValue;
        return String.valueOf(p.getIdProveedor());
    }
}
