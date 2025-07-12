package orangeHRM.utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendMail {
	
	
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	public void sendMail() {
		
		//entering directory name and verifying whether the given path is valid.
		File dir = new File("./ExtentReports");
		System.out.println(dir.isDirectory());
		
		//getting the recent report name
		String fileName = getLatestFilefromDir("./ExtentReports").getName();
		System.out.println(fileName);
		
		//converting folder path to string
		String path=dir.toString();
		System.out.println("Path is "+path);
		
		//entering gmail id and its password of the recipient
		final String username = "dhanatest2411@gmail.com";
	    final String password = "jspm lpzi tzsn ldlh";

	    Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
	    prop.put("mail.smtp.port", "587");
	    prop.put("mail.smtp.auth", "true");
	    prop.put("mail.smtp.starttls.enable", "true"); //TLS
	    
	    //session creation
	    Session session = Session.getInstance(prop,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	    
	    //add attachment
	    try {

	    	MimeMessage message = new MimeMessage(session);
	    	//add from and to recipients
	        message.setFrom(new InternetAddress("dhanatest2411@gmail.com"));
	        message.setRecipients(
	                Message.RecipientType.TO,
	                InternetAddress.parse("dhanatest2411@gmail.com")
	        );
	        //add subject
	        message.setSubject("OrangeHRM Test Automation Results");

	        //add content
	        BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         
	         messageBodyPart.setText("Please find the attached automation test report.");
	         
	        
	         // Create a multipart message for attachment
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Second part is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = path+"\\"+fileName;
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
		
	}
	
}
