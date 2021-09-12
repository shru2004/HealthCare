package com.example.thymeleaf.controller;

import javax.mail.MessagingException;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.thymeleaf.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
    private EmailService emailService;
	
	//private Patient patient;
	
	
//	@GetMapping("/thymeleafTemplate")
//	public String getTemplate(@RequestParam (name="name", required=false) String name, Model model)
//	{
//		model.addAttribute("name", name);
//		return "thymeleafTemplate";
//	}
	
//	@RequestMapping(value = "/email", method = RequestMethod.POST)
//	@ResponseBody
//	public String sendMail(@RequestBody  )throws MessagingException{
//	        emailService.sendMail(patient);
//	        return "Email Sent Successfully.!";
//	}
	
//	@PostMapping("/emailSend")
//	public String sendEmail(@RequestParam (name="name") String name), @RequestParam(emailId= "emmailId") String name))
//	{
//		return emailService.sendMail(patient);
//	}

	@RequestMapping("/send")
	public String email(@RequestParam (name="name",  required=false)String name, 
			@RequestParam (name="emailId", required=false) String emailId, Model model) throws MessagingException
	{
		return emailService.sendMail(name, emailId);
	}
	
}
