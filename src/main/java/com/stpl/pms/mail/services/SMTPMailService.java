package com.stpl.pms.mail.services;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class SMTPMailService {

	private static final Logger logger = Logger.getLogger(SMTPMailService.class);
	private static SMTPMailService instance;
	private static final String SMTP_AUTH_USER = "itgs.engine@gmail.com";
	private static final String SMTP_AUTH_PWD = "123456789itgs";

	public SMTPMailService() {
	}

	public static SMTPMailService getInstance() {
		if (instance == null)
			instance = new SMTPMailService();
		return instance;
	}

	public void sendMail(String fromEmail, String fromName, String toEmail, String replyTo, String subject, String body,
			String smtpHost) {
		try {
			logger.info("Inside SMTP service...........");
			Properties props = new Properties();
			props.put("mail.smtp.host", smtpHost);
			props.put("mail.smtp.ssl.trust", smtpHost);
			Session session = SMTPMailService.getInstance().getSMTPSession(props, true);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail, fromName));
			message.setReplyTo(InternetAddress.parse(replyTo, false));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(subject, "UTF-8");
			message.setText(body, "UTF-8");
			message.setSentDate(new Date());

			// for sending simple body mail
			message.setContent(body, "text/html; charset=UTF-8");

			message.setSentDate(new Date());
			// Send mail
			Transport.send(message);
				System.out.println("sent");
			logger.info("SMTP mail sent SUCCESS....");

		} catch (Exception e) {
			logger.error(e);
			System.out.println(e);
			logger.info("SMTP mail sent FAILED....");

		}

	}

	public void sendMail(String fromEmail, String fromName, String toEmail, String replyTo, String subject, String body,
			String smtpHost, String filePath) {
		try {
			logger.info("Inside SMTP service...........");
			Properties props = new Properties();
			props.put("mail.smtp.host", "SMTP_HOST");
			
			Session session = SMTPMailService.getInstance().getSMTPSession(props, true);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

			message.setSubject(subject);

			// for sending simple body mail

			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = body;
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(filePath);

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			// Send mail
			Transport.send(message);

			logger.info("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void sendBulkMail(String fromEmail, String fromName, String[] toEmail, String replyTo, String subject,
			String body, String smtpHost) {
		try {
			logger.info("Inside SMTP service...........");
			Properties props = new Properties();
			props.put("mail.smtp.host", "SMTP_HOST");

			Session session = SMTPMailService.getInstance().getSMTPSession(props, true);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			InternetAddress[] sendTo = new InternetAddress[toEmail.length];
			for (int i = 0; i < toEmail.length; i++) {
				System.out.println("Send to:" + toEmail[i]);
				sendTo[i] = new InternetAddress(toEmail[i]);
			}
			message.addRecipients(Message.RecipientType.TO, sendTo);
			message.setSubject(subject);

			// for sending simple body mail
			message.setText(body);
			message.setSentDate(new Date());
			// Send mail
			Transport.send(message);

			logger.info("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void sendBulkMail(String fromEmail, String fromName, String[] toEmail, String replyTo, String subject,
			String body, String smtpHost, String filePath) {
		try {
			logger.info("Inside SMTP service...........");
			Properties props = new Properties();
			props.put("mail.smtp.host", "SMTP_HOST");

			Session session = SMTPMailService.getInstance().getSMTPSession(props, true);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			InternetAddress[] sendTo = new InternetAddress[toEmail.length];
			for (int i = 0; i < toEmail.length; i++) {
				System.out.println("Send to:" + toEmail[i]);
				sendTo[i] = new InternetAddress(toEmail[i]);
			}
			message.setRecipients(Message.RecipientType.TO, sendTo);
			message.setSubject(subject);
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");

			message.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			message.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
			// for sending simple body mail

			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = body;
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(filePath);

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			// Send mail
			Transport.send(message);

			logger.info("Sent message successfully....");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public Session getSMTPSession(Properties props, boolean senderAuth) {
		final String username = SMTP_AUTH_USER;
		final String password = SMTP_AUTH_PWD;
		if (senderAuth) {
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			return Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
		} else {
			return Session.getInstance(props, null);
		}
	}

	public static void main(String[] args) {

		String toEmail = "gmonu6171@gmail.com";
		String fromEmail = "itgs.engine@gmail.com";
		String subject = "HELLO TESTING";
		String message = "test message";
		String fromName = "Test";
		String mailSmtpHost = "smtp.gmail.com";
		SMTPMailService.getInstance().sendMail(fromEmail, fromName, toEmail, fromEmail, subject, message, mailSmtpHost);
System.out.println("MAIL SENT SUCCESS!!!!");
	}
}