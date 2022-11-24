// First turn on two step verification in aacounts.google.com/security
// Under security in your google account, create an app password
// This will help you get a password to use to access your account in your php code
// Download the phpmailer folder and include it in the same directory where your php file is
<?php  
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'phpmailer/src/Exception.php';
require 'phpmailer/src/PHPMailer.php';
require 'phpmailer/src/SMTP.php';
$mail = new PHPMailer(true);

$mail->isSMTP();
$mail->Host = "smtp.gmail.com";
$mail->SMTPAuth   = true;
$mail->Username = "sender's email address";
$mail->Password = "your app password";

$mail->SMTPSecure = "ssl";
$mail->Port = 465;
$to = "receiver's email address";
$subject = "Subject of the E mail";
$message = "Message to be sent";

$mail->setFrom("your email address", "Name of the sender");
$mail->addAddress($to);
$mail->addReplyTo("info@gmail.com");// Where replies from respondents will be sent 
$mail->isHTML(true);
$mail->Subject = $subject;
$mail->Body = $message;
$mail->AddCC("cc-recipient-email", "cc-recipient-name"); // In case of carbon copies

if(!$mail->send()) {
      echo "
      <script>
             alert('Oooops!! an Error occured, Please try again later');
      </script>
      ";
      var_dump($mail);
}else{
  echo "
        <script>
            alert('Account created successfully!! Check your e-mail inbox for your login credentials..');
            document.location.href = 'index.php';
         </script>
          ";
          }
?>
