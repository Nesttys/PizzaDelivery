package com.example.pizzadelivery;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email
{
//    public String jobNo;
//    public String teamNo;
//    private static final String username = "abc@gmail.com";
//    private static final String password = "000000";
//    private static final String emailid = "xyz@outlook.com";
//    private static final String subject = "Photo";
//    private static final String message = "Hello";
//    private Multipart multipart = new MimeMultipart();
//    private MimeBodyPart messageBodyPart = new MimeBodyPart();
//    public File mediaFile;

//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.camera_screen);
//        Intent intent = getIntent();
//        jobNo = intent.getStringExtra("Job_No");
//        teamNo = intent.getStringExtra("Team_No");
//        sendMail(emailid,subject,message);
//
//    }
//    public boolean isOnline() {
//        ConnectivityManager cm =
//                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netInfo = cm.getActiveNetworkInfo();
//        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
//            return true;
//        }
//        return false;
//    }
    public void sendMail(String email, String subject, String messageBody)
    {
        final String username = "bogm55529@gmail.com";
        final String password = "63364600";
        String mailhost = "smtp.gmail.com";
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", mailhost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(messageBody);

//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//
//            Multipart multipart = new MimeMultipart();
//
//            messageBodyPart = new MimeBodyPart();
//            String file = "path of file to be attached";
//            String fileName = "attachmentName";
//            DataSource source = new FileDataSource(file);
//            messageBodyPart.setDataHandler(new DataHandler(source));
//            messageBodyPart.setFileName(fileName);
//            multipart.addBodyPart(messageBodyPart);
//
//            message.setContent(multipart);

            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

//
//    private Session createSessionObject()
//    {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//
//        return Session.getInstance(properties, new javax.mail.Authenticator()
//        {
//            protected PasswordAuthentication getPasswordAuthentication()
//            {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//    }

//    private Message createMessage(String email, String subject, String messageBody, Session session) throws
//
//            MessagingException, UnsupportedEncodingException
//    {
//        Message message = new MimeMessage(session);
//        message.setFrom(new InternetAddress("xzy@outlook.com", "Naveed Qureshi"));
//        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email, email));
//        message.setSubject(subject);
//        message.setText(messageBody);
//        return message;
//    }



//    public class SendMailTask extends AsyncTask<Message, Void, Void>
//    {
//        private ProgressDialog progressDialog;
//
//        @Override
//        protected Void doInBackground(Message... messages) {
//            try
//            {
//                Transport.send(messages[0]);
//            } catch (MessagingException e)
//            {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPreExecute()
//        {
//            super.onPreExecute();
//            progressDialog = ProgressDialog.show(Email.this, "Please wait", "Sending mail", true, false);
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid)
//        {
//            super.onPostExecute(aVoid);
//            progressDialog.dismiss();
//        }
//
//    }
}