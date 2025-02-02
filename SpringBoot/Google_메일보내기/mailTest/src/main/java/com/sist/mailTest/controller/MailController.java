package com.sist.mailTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class MailController {

	@Autowired
	private MailSender javaMailSender;

	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@RequestMapping("/mail.do")
	public String mail()
	{
		String r  = "OK";
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("회원가입안내");
		mailMessage.setFrom("jewelrye6");
		mailMessage.setText("회원가입을 환영합니다.");
		mailMessage.setTo("jewelrye@hanmail.net");
		try {
			javaMailSender.send(mailMessage);
		}catch (Exception e) {
			// TODO: handle exception'
			System.out.println(e.getMessage());
		}
		return r;
	}// mail
	
}





