package pe.sblm.intranet.controller;

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

    @Autowired
    private UsuarioRepositorio userRepo;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        String domainController = "ldap://192.168.1.5:389";

        if (authenticateUser(username, password, domainController)) {
            Optional<Usuario> usuarioOptional = userRepo.findByUsuario(username);
            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                // System.out.println("Usuario encontrado " + usuario);
                return ResponseEntity.ok(usuario);
            } else {
                // System.out.println("Usuario NO encontrado " + username);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autenticación fallida para el usuario: " + username);
        }
    }

    public static boolean authenticateUser(String username, String password, String domainController) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, username + "@benelima.pe");
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, domainController);

        try {
            // Intentar conectarse al servidor LDAP
            DirContext context = new InitialDirContext(env);
            // System.out.println("Conexión exitosa al servidor LDAP");
            context.close();
            return true;
        } catch (NamingException e) {
            System.out.println("Error en la autenticación: " + e.getMessage());
            return false;
        }
    }
}
