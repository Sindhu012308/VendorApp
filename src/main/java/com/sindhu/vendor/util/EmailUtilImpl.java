package com.sindhu.vendor.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void sendEmail(String toAddress, String subject, String bodyMessage) {
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage);
		try {
			mimeHelper.setTo(toAddress);
			mimeHelper.setSubject(subject);
			mimeHelper.setText(bodyMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		sender.send(mimeMessage);

	}

}
