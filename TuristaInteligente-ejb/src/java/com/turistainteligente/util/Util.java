/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.util;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Produces;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hector-FlechaRoja
 */
public final class Util {

    public enum TipoUsuario {

        A, N;

        @Override
        public String toString() {
            switch (this) {
                case A:
                    return "Adeministrador";
                case N:
                    return "Normal";
                default:
                    return "";
            }
        }
    }
    
    public enum TipoPaquete {
        I, N;
        
        @Override
        public String toString() {
             switch (this) {
                case I:
                    return "Internacional";
                case N:
                    return "Nacional";
                default:
                    return "";
            }
        }
    }
    
    public enum TipoTarifa {
        H, P;
        
        @Override
        public String toString() {
             switch (this) {
                case H:
                    return "Habitaciones";
                case P:
                    return "Personas";
                default:
                    return "";
            }
        }
    }
    
    public enum Localidad {
        C, N, S, E;
        
        @Override
        public String toString() {
             switch (this) {
                case N:
                    return "Norteamérica";
                case C:
                    return "Centroamérica";
                case S:
                    return "Suramérica";
                case E:
                    return "Europa";
                default:
                    return "";
            }
        }
    }
    
    public enum TipoTraslado {
        C, I;
        
        @Override
        public String toString() {
             switch (this) {                
                case C:
                    return "Centroamérica";
                case I:
                    return "Individual";                
                default:
                    return "";
            }
        }
    }
    
    @Named
    @Produces
    public List<SelectItem> getTipoUsuarioValues() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Util.TipoUsuario tu : Util.TipoUsuario.values()) {
            items.add(new SelectItem(tu, tu.toString()));
        }
        return items;
    }
    
    @Named
    @Produces
    public List<SelectItem> getTipoPaqueteValues() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Util.TipoPaquete tp : Util.TipoPaquete.values()) {
            items.add(new SelectItem(tp, tp.toString()));
        }
        return items;
    }
    
    @Named
    @Produces
    public List<SelectItem> getTipoTarifaValues() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Util.TipoTarifa tt : Util.TipoTarifa.values()) {
            items.add(new SelectItem(tt, tt.toString()));
        }
        return items;
    }
    
    @Named
    @Produces
    public List<SelectItem> getLocalidadValues() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Util.Localidad l : Util.Localidad.values()) {
            items.add(new SelectItem(l, l.toString()));
        }
        return items;
    }
    
    @Named
    @Produces
    public List<SelectItem> getTipoTrasladoValues() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Util.TipoTraslado t : Util.TipoTraslado.values()) {
            items.add(new SelectItem(t, t.toString()));
        }
        return items;
    }

    public static void sendMail(String sendTo, String emailSubjectTxt, String emailMsgTxt) {
//        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        try {
            new MailEvento().sendSSLMessage(sendTo, emailSubjectTxt,
                    emailMsgTxt);
            System.out.println("Sucessfully Sent mail ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not Sent mail");
        }
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static void addSuccessMessage(String message) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }

    public static void addErrorMessage(String message) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }

    public static void addInfo(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    public static void addWarn(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
    }

    public static void addError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public static void addFatal(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, message, null));
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) getExternalContext().getResponse();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    private static ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }
}
