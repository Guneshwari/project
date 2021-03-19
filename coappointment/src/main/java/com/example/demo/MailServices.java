/*package com.example.demo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServices {

private JavaMailSender mailSender;
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String emailId)
	{
		MimeMessage message =  this.mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper;
		try {
			mimeHelper = new MimeMessageHelper(message,true);
			mimeHelper.setTo(emailId);
			
			
			mimeHelper.setFrom("covax121@gmail.com");
			mimeHelper.setSubject("Password Reset");
			mimeHelper.setText("<html><body>hi,<br/><a href='http://localhost:8080/ForgotPassword/newPassword/"+emailId+"/'> Click here</a> to reset password</body></html>",true);
			mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("Error Sending email "+ e.getMessage());
		}
		
	}

}
*/
package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServices {
	
	@Autowired
	private JavaMailSender mailSender ;

	public void sendSimpleEmail(String toEmail, String body , String subject) {
		 SimpleMailMessage message = new SimpleMailMessage();
		 message.setFrom("covaxapp@gmail.com");
		 message.setTo(toEmail);
		 message.setText(body);
		 message.setSubject(subject);
	
		 mailSender.send(message);
		 System.out.println("Mail send...");
	}
}
