package com.practice.code;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class Example {
	public static void main(String[] args) throws IOException {

		Email from = new Email("kuldeepargal998@gmail.com");
		String subject = "Sending with SendGrid is Fun";
		Email to = new Email("contact.ttn.entertainment@gmail.com");

		String verificationTemplate = Verification.returnMessage("Kuldeep Argal", "contact.ttn.entertainment@gmail.com",
				null);

		Content content = new Content("text/html", verificationTemplate);

		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("enter your key ");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println("Message Sent");
		} catch (IOException ex) {
			System.out.println("Exception Occure");
			System.out.println(ex.getMessage());

		}

	}
}