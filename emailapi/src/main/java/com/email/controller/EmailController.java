package com.email.controller;

import com.email.model.EmailRequest;

import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String welcome()
    {

        return "This is Email API";
    }

    //API to send email
    @RequestMapping(value="/sendemail", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
    {
        System.out.println(request);

        boolean result = this.emailService.sendEmail(request.getTo(),request.getSubject(),request.getMessage());
        if(result)
        {
            return ResponseEntity.ok("Email sent successfully...");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
        }

        //return ResponseEntity.ok("Done");
    }
}
