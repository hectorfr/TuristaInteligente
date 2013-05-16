/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turistainteligente.util;

import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;

/**
 *
 * @author Hector-FlechaRoja
 */
public class MailEvento implements Serializable {
    // private static final String SMTP_HOST_NAME = "smtp.ice.go.cr";
    //  private static final String SMTP_PORT = "25";
// Get a handle to the JNDI environment naming context

    static final Logger log = Logger.getLogger(MailEvento.class.getName());

    public MailEvento() {
    }

    @Asynchronous
    public void sendSSLMessage(String recipients, String subject,
            String message) throws MessagingException {
        try {
            boolean debug = false;

            final String smtpHostName = "smtp.sendgrid.com";
            final String smtpPortNumber = "25";
            final String fromEmail = "gerardo@flecharoja.com";
            final String fromEmailPassword = "crUwEye23";

            Properties props = new Properties();

            props.put("mail.smtp.host", smtpHostName);
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.port", smtpPortNumber);
            props.put("mail.smtp.auth", "true");
            //      props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, fromEmailPassword);
                }
            });

            session.setDebug(debug);

            MimeMessage msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(fromEmail);
            msg.setFrom(addressFrom);

            //InternetAddress addressTo = new InternetAddress(recipients);
            //msg.setRecipient(Message.RecipientType.TO, addressTo);
            msg.setRecipients(Message.RecipientType.TO, recipients);

            msg.setSubject(subject, "UTF-8");
            msg.setText(message, "UTF-8");
            msg.setHeader("Content-Type", "text/html; charset=UTF-8");

            Transport.send(msg);
        } catch (Exception e) {
            log.severe(e.getMessage());
        }
    }
}
