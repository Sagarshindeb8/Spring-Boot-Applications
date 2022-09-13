package com.email.service;


import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import jakarta.mail.*;

import java.util.Properties;

@Service
public class EmailService {

    public boolean sendEmail(String to, String subject, String message)
    {

        boolean f = false;

        //Email id through which mail is to be sent
        String from = "sagarshinde.repository@gmail.com";

        //Variable for gmail host
        String host="smtp.gmail.com";

        //Get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //Setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");



        //Step 1: To get the session object
        Session session =  Session.getInstance(properties,new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("sagarshinde.repository@gmail.com", "ufoyahxrqiwbaoib");
            }

        });

        //Step 2: Compose the email message
        session.setDebug(true);
        MimeMessage m = new MimeMessage(session);


        try
        {
            //From email id
            m.setFrom(from);

            //Recepient email id
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //Subject of email
            m.setSubject(subject);

            //Text - message to send email
            m.setText(message);

            //Step 3: Send email using transport class
            Transport.send(m);

            System.out.println("Email sent successfully...!!");
            f=true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return f;
    }
}
