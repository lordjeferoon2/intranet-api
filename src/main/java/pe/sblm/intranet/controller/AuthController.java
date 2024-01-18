package pe.sblm.intranet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.sblm.intranet.model.Usuario;
import pe.sblm.intranet.repository.UsuarioRepositorio;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private static final String LDAP_URL = "ldap://192.168.1.5:389";
    private static final String LDAP_PRINCIPAL_SUFFIX = "@benelima.pe";

    @Autowired
    private UsuarioRepositorio userRepo;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (authenticateUser(username, password)) {
            Optional<Usuario> usuarioOptional = userRepo.findByUsuario(username);
            Usuario usuario = usuarioOptional.orElse(null);

            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autenticación fallida para el usuario: " + username);
        }
    }

    private boolean authenticateUser(String username, String password) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, username + LDAP_PRINCIPAL_SUFFIX);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);

        try {
            DirContext context = new InitialDirContext(env);
            context.close();
            return true;
        } catch (NamingException e) {
            logger.error("Error en la autenticación para el usuario {}: {}", username, e.getMessage());
            return false;
        }
    }
}
