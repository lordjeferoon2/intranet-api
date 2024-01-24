package pe.sblm.intranet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sblm.intranet.service.EmailService;

@RestController
public class EmailController {

    private final EmailService emailService;
    
    public EmailController(EmailService emailService) {
    	this.emailService = emailService;
    }

    @RequestMapping("/sendEmail")
    public String sendEmail() {
        emailService.sendEmail("comunicaciones@beneficenciadelima.org", "Asunto del correo", "Cuerpo del correo");
        return "Correo enviado exitosamente.";
    }
}