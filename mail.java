import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import javax.activation.*;

public class mail 
{
    public static void send(String from,String password,String to,String sub,String msg){  
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable","true");      
        props.put("mail.smtp.port", "587");    
        props.put("mail.smtp.host", "smtp.gmail.com");    
   
        
       
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    

        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    

         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        }
        catch (MessagingException e)
        {
            throw new RuntimeException(e);
        }    
           
  }  

public static void main(String[] args) 
{    
   //from,password,to,subject,message  
   send("projectmaildummy@gmail.com","dummymail1","sriparimannan@gmail.com","hello","How r u?");  
   //change from, password and to  
}    
}
