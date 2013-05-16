/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.util;

import java.io.Serializable;
import javax.ejb.Asynchronous;

/**
 *
 * @author Hector-FlechaRoja
 */
public final class NotificationManager implements Serializable {
    private static NotificationManager not = null;

    public NotificationManager() {
    }

    public synchronized static NotificationManager getInstance() {
        if (not == null) {
            not = new NotificationManager();
        }
        return not;
    }

    /**
     * *
     * Metodo que se encarga de enviar un mensaje a un usuario dado por medio de
     * SMS o email; esto con base en la parametrizacion que el haya indicado
     *
     * @param alertType
     * @param currentUser
     * @param params
     */
    @Asynchronous
    public void sendMessage(String correoPara, String contenido, String titulo) {
        try {
            // Paso #1 por Email
            Util.sendMail(correoPara, titulo, contenido);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
