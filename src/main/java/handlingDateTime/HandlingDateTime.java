package handlingDateTime;
import java.util.*;
import java.sql.*;
import javax.mail.*;
import javax.mail.internet.*;
public class HandlingDateTime
{
    public static void sendMail(String data)
    {
        try
        {
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            System.out.println("Sending mail......................");
            String msgBody =data;
            try
            {
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("imran.khan@hariommedia.com"));
                msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress("vinay.kumar@hariommedia.com", "Mr. User"));
                msg.setSubject("test mail");
                msg.setText(msgBody);
                Transport.send(msg);
            }catch (AddressException e)
            {
                System.out.println(e);
            } catch (MessagingException e)
            {
                System.out.println(e);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String arr[])throws Exception
    {
       
        sendMail("This message is sent from java application.");
    }
    
}
