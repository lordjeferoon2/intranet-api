package pe.sblm.intranet.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import pe.sblm.intranet.model.Publicacion;
import pe.sblm.intranet.model.Usuario;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("comunicaciones@beneficenciadelima.org");

        javaMailSender.send(message);
    }
    
    public void enviarCorreoAsincrono(Usuario usuario, Publicacion nuevaPublicacion) {
        String cuerpoCorreo = "";
        if (nuevaPublicacion.getTipoPublicacion().equals("Comunicaciones") ||
            nuevaPublicacion.getTipoPublicacion().equals("Eventos") ||
            nuevaPublicacion.getTipoPublicacion().equals("Galería")) {
            cuerpoCorreo = "¡Hola, " + usuario.getNombres() + "!\n\n"
                    + "Se ha registrado una nueva publicación en la INTRANET.\n"
                    + "Puedes visitarla en la siguiente ruta:\n"
                    + "http://intranet.benelima.pe/new/" + nuevaPublicacion.getId() + "\n\n"
                    + "¡Esperamos que encuentres la información interesante!\n"
                    + "Saludos,\n"
                    + "Tu equipo de la INTRANET";
        } else {
        	String tipo = "";
            cuerpoCorreo = "¡Hola, " + usuario.getNombres() + "!\n\n"
                    + "Se ha cargado un nuevo documento en la INTRANET.\n"
                    + "Puedes visitarla en la siguiente ruta:\n"
                    + nuevaPublicacion.getUrlDocumento() + "\n\n"
                    + "¡Esperamos que encuentres la información interesante!\n"
                    + "Saludos,\n"
                    + "Tu equipo de la INTRANET";
        }

        sendEmail(usuario.getCorreo() + "@beneficenciadelima.org", "Nueva Publicación en la INTRANET", cuerpoCorreo);
    }
}