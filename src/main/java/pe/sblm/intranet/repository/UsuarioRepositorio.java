package pe.sblm.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.sblm.intranet.model.Usuario;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuarioAndContrasena(String usuario, String contrasena);
}