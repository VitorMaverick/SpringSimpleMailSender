package com.example.demo.controller;

import com.example.demo.mail.MailSender;
import com.example.demo.mail.MockMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private MailSender mailSender;

    public MailController(@Qualifier("smtpMailSender") MailSender mailSender) {
        this.mailSender = mailSender;
    }
    /*
    @Autowired
    public void setMailSender(@Qualifier("smtpMailSender") MailSender mailSender) {
        this.mailSender = mailSender;
    }
     */

    @RequestMapping("/mail")
    public String hello(){

        mailSender.send("mail@example.com", "A test e-mail", "Boddy of the test email");

        return "mail sent";
    }
}
