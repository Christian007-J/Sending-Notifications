#Step 1: First navigate to https://myaccount.google.com/security to turn on 2-Step verification
#Step 2: Register your application. Ref: https://www.youtube.com/watch?v=g_j6ILT-X0k
#Step 3: Start writing code
# Import statements
from email.message import EmailMessage
import ssl
import smtplib

# Initialising necessary Variables
sender = 'Senders_Email_address'
password = 'your application password'
receiver = 'Receivers_Email_address'

subject = 'Message Subject'
body = """Message to be sent """
# Preparing Message
em = EmailMessage()
em['From'] = sender
em['To'] = receiver
em['Subject'] = subject
em.set_content(body)

context = ssl.create_default_context()
# Sending Email
with smtplib.SMTP_SSL('smtp.gmail.com', 465, context=context) as smtp:
    smtp.login(sender, password)
    smtp.sendmail(sender, receiver, em.as_string())
#End
