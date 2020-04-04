package com.teembinsys;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  

public class Mailer {  
public static void send(String to,String uname, String passwd, String subject,String msg){  
  
final String user=(String)to.trim().toString();//change accordingly  
final String pass=(String)passwd.trim().toString();

//final String user="kanagaraj.dharuman@teembinsys.com";  
//final String pass="a5newdelhi";
	
System.out.println("User name: "+user);
System.out.println("Password: "+pass);

  
//1st step) Get the session object    
Properties props = new Properties();

props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.host", "smtp.teembinsys.com");//change accordingly  
props.put("mail.smtp.port", "587");
//props.put( "mail.smtp.user" , user);
//props.put( "mail.smtp.password" , pass);

Session session = Session.getDefaultInstance(props,  
 new javax.mail.Authenticator() {  
  protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication(user,pass);  
   }  
});  
//2nd step)compose message  
try {  
 MimeMessage message = new MimeMessage(session);  
 message.setFrom(new InternetAddress(user));  
 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
 message.setSubject(subject);  
 message.setText(msg);  
   
 System.out.println("Before Transport.send");
 
 //3rd step)send message  
 Transport.send(message);  
  
 System.out.println("Done");  
  
 } catch (MessagingException e) {  
    throw new RuntimeException(e);  
 }  
      
}  
}
