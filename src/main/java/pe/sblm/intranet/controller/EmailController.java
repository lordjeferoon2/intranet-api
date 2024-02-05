package pe.sblm.intranet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sblm.intranet.model.Publicacion;
import pe.sblm.intranet.model.Usuario;
import pe.sblm.intranet.repository.PublicacionRepositorio;
import pe.sblm.intranet.repository.UsuarioRepositorio;
import pe.sblm.intranet.service.EmailService;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*")
public class EmailController {

    private final EmailService emailService;
    
    private final UsuarioRepositorio usuarioRepo;
    
    private final PublicacionRepositorio publicacionRepo;
    
    public EmailController(EmailService emailService, UsuarioRepositorio usuarioRepo, PublicacionRepositorio publicacionRepo) {
    	this.emailService = emailService;
    	this.usuarioRepo = usuarioRepo;
    	this.publicacionRepo = publicacionRepo;
    }

    @GetMapping("/sendEmail/{idPublicacion}")
    public String sendEmail(@PathVariable Long idPublicacion) {
    	Publicacion nuevaPublicacion = publicacionRepo.getById(idPublicacion);
    	List<Usuario> usuarios = usuarioRepo.findAllByEstado(true);
        for (Usuario usuario : usuarios) {
        	emailService.enviarCorreoAsincrono(usuario, nuevaPublicacion);
        }
        
        return "Correos enviados";
    }
}