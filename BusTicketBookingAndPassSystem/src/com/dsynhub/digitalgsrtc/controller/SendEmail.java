package com.dsynhub.digitalgsrtc.controller;


import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dell
 */
public class SendEmail {
	
    public String SendEmail(String subject, String to, String message) {
        String from = "digitalgsrtc2016@gmail.com";
        try {
            Properties props = System.getProperties();
            // -- Attaching to default Session, or we could start a new one

            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            SMTPAuthenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            // -- Create a new message --

            Message msg = new MimeMessage(session);
              // -- Set the FROM and TO fields --

            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
 //msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
            // -- We could include CC recipients too --

    // if (cc != null)
             // msg.setRecipients(Message.RecipientType.CC
            // ,InternetAddress.parse(cc, false));
            // -- Set the subject and body text --
            msg.setSubject(subject);
            msg.setText(message);
            // -- Set some other header information --


            msg.setSentDate(new Date());
            // -- Send the message --

            Transport.send(msg);

            System.out.println("Message sent to" + to + " OK.");

            return "success";
//          return 0;
        } catch (Exception ex) {

            ex.printStackTrace();

            System.out.println("Exception " + ex);
            return ex.getMessage();
            //  return -1;

        }
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {

            String username = "digitalgsrtc2016@gmail.com";

            String password = "digital2016";

            return new PasswordAuthentication(username, password);

        }

    }
    
    
    public  boolean sendMail(String from, String password, String subject, String message, String to[]) {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.enable", "true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress("digitalgsrtc.in<"+from+">"));

            mimeMessage.setHeader("Content-Type", "text/html; charset=UTF-8");

            InternetAddress[] toAddresses = new InternetAddress[to.length];

            for (int i = 0; i < to.length; i++) {
                toAddresses[i] = new InternetAddress(to[i]);
            }
            
            System.out.println("length addresses => " + toAddresses.length);
            mimeMessage.setRecipients(Message.RecipientType.TO, toAddresses);
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message, "utf-8");
            mimeMessage.setContent(message, "text/html; charset=utf-8");

            Transport transport = session.getTransport("smtps");
            transport.connect(host, from, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;

        } catch (MessagingException me) {	
            me.printStackTrace();
        }
        return false;
    }

    
    

}
