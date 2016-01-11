package mail;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class SendMail
{
    public static void main(String arr[])
    {
        try
        {
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            System.out.println("Sending mail......................");
            String msgBody = "Hello Vinay Kumar.";
            try
            {
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("imran.khan@hariommedia.com"));
                msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress("imran.khan@hariommedia.com", "Mr. User"));
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
        System.out.println("Mail sent successfully.");
    }
}
