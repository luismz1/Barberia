/*Elaborado por:
Daniel Alemán Ruiz (2023051957)
Luis Meza Chavarría (2023800023)
David Matamoros Jiménez (2023800039)*/
package barberia.control;

// Paquetes utilizados
import java.io.Serializable;
import javax.mail.Session;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*Lógia de la clase sacada de:
L-Code. (2022, 19 de Setiembre). Enviar correos desde Java 📧 | Gmail | 2022.
You Tube. https://www.youtube.com/watch?v=ZggjlwLzrxg*/
public class MailSender implements Serializable{
    // Variables utilizadas
    private String emailFrom = "noreplybarberiamilleniumsjo@gmail.com";
    private String passwordFrom = "jvsu pwtv othz xqdx";
    
    private Properties mProperties;
    // Estos son no serializables y por lo tanto deben ser de tipo transient.
    private transient Session mSession;
    private transient MimeMessage mCorreo;
    
    public MailSender(){
        mProperties = new Properties();
    }
    
     // Método para crear un correo.
     public void createMail(String emailTo, String subject, String content){            
            // Protocolo SMP (Simple Mail Transfer Protocol)
            mProperties.put("mail.smtp.host", "smtp.gmail.com");
            mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            mProperties.setProperty("mail.smtp.starttls.enable", "true");
            mProperties.setProperty("mail.smtp.port", "587");
            mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            mProperties.setProperty("mail.smtp.auth", "true");
            
            mSession = Session.getDefaultInstance(mProperties);
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content, "ISO-8859-1", "html");
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     // Método para enviar un correo.
     public void sendMail(){
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            System.out.println("Se ha enviado el correo.");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
