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
    
    @Named
    @Produces
    public List<SelectItem> getTipoUsuarioValues() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Util.TipoUsuario tu : Util.TipoUsuario.values()) {
            items.add(new SelectItem(tu, tu.toString()));
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
