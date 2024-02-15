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

    public void sendEmail(String to, String from, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom(from);

        javaMailSender.send(message);
    }
    
    public void enviarCorreoAsincrono(Usuario usuario, Publicacion nuevaPublicacion) {
        String cuerpoCorreo = "";
        if (nuevaPublicacion.getTipoPublicacion().equals("Comunicaciones") ||
            nuevaPublicacion.getTipoPublicacion().equals("Eventos") ||
            nuevaPublicacion.getTipoPublicacion().equals("Galería")) {
            cuerpoCorreo = "¡Hola, " + usuario.getNombres() + "!\n\n"
                    + "Se ha registrado una nueva publicación en la INTRANET:\n\n"
                    + nuevaPublicacion.getTitulo()+"\n"
                    + nuevaPublicacion.getContenido()+"\n\n"
                    + "Puedes visitarla en el siguiente enlace:\n"
                    + "http://intranet.benelima.pe/#/new/" + nuevaPublicacion.getId() + "\n\n"
                    + "¡Esperamos que encuentres la información interesante!\n"
                    + "Saludos,\n"
                    + "Tu equipo de la INTRANET\n"
            		+ "Gerencia de Tecnologías de la Información y Comunicaciones";
        } else {
        	String tipo = nuevaPublicacion.getTipoPublicacion();
        	switch(tipo) {
        		case "Marco": tipo = "Control Interno - Marco Normativo"; break;
        		case "Orientaciones": tipo = "Control Interno - Orientaciones Prácticas"; break;
        		case "Cronograma": tipo = "Control Interno - Cronograma de Presentación"; break;
        		case "Preguntas": tipo = "Control Interno - Preguntas Frecuentes"; break;
        		case "Planes": tipo = "Planes de Gestión"; break;
        		case "PlanesAccion": tipo = "Planes de Acción"; break;
        	}
            cuerpoCorreo = "¡Hola, " + usuario.getNombres() + "!\n\n"
                    + "Se ha publicado un nuevo documento en la INTRANET:\n\n"
                    + nuevaPublicacion.getTitulo()+"\n\n"
                    + "Puedes encontrarla en la sección de " + nuevaPublicacion.getTipoPublicacion() + ".\n"
                    + "¡Esperamos que encuentres la información interesante!\n"
                    + "Saludos,\n"
                    + "Tu equipo de la INTRANET\n"
            		+ "Gerencia de Tecnologías de la Información y Comunicaciones";
        }
        String correoOrigen = "";
        if(nuevaPublicacion.getGerencia().equals("GTI")) {
        	correoOrigen = "comunicaciones.GTI@beneficenciadelima.org";
        }
        else {
        	correoOrigen = "comunicaciones@beneficenciadelima.org";
        }
        String correoDestino = usuario.getCorreo().endsWith("@beneficenciadelima.org") ? usuario.getCorreo() : usuario.getCorreo() + "@beneficenciadelima.org";
        sendEmail(correoDestino, correoOrigen, nuevaPublicacion.getTitulo(), cuerpoCorreo);
    }
}