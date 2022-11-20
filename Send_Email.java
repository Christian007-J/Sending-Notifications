// Import the following
import javax.mail.Authenticator;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import com.sun.mail.util.MailConnectException;
// Under Action Listener of your button, write the following code
// E-Mail Proprties
Properties properties = new Properties();
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");
properties.put("mail.smtp.host", "smtp.gmail.com");
properties.put("mail.smtp.port", "587");

// Sender's Details
String myemail = "Sender's email";
String mypassword = "Your Password";
String sub = "Email Subject";

//Receiver's Email Address
String to = "Receiver's Email address";
                
Session session = Session.getInstance(properties, new Authenticator(){
// Verifying your email credentials
protected PasswordAuthentication getPasswordAuthentication(){
    return new PasswordAuthentication(myemail , mypassword);}});

try {
                    MimeMessage m = new MimeMessage(session);
                    m.setFrom(myemail);
                    m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    m.setSubject(sub);
                    m.setText("Message to be Sent");
                    Transport.send(m);
                    JOptionPane.showMessageDialog(null, "Email sent Successfully");           
                }
// Incase you ain't connected to the internet
                catch(MailConnectException ex){
                    JOptionPane.showMessageDialog(null, "No Internet Connection !!");
// Incase of any error
                }
                catch(Exception e){
                    e.printStackTrace();       
                }
// End --> See you
