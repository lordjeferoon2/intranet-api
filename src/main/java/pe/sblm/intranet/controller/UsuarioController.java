package pe.sblm.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.sblm.intranet.model.Usuario;
import pe.sblm.intranet.repository.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario existingUsuario = usuarioOptional.get();
            existingUsuario.setNombres(usuario.getNombres());
            existingUsuario.setApellidos(usuario.getApellidos());
            existingUsuario.setUsuario(usuario.getUsuario());
            existingUsuario.setContrasena(usuario.getContrasena());
            existingUsuario.setTipo(usuario.getTipo());
            existingUsuario.setDependencia(usuario.getDependencia());
            existingUsuario.setDependenciaHijo(usuario.getDependenciaHijo());
            existingUsuario.setCorreo(usuario.getCorreo());
            existingUsuario.setSede(usuario.getSede());
            existingUsuario.setEstado(usuario.isEstado());
            usuarioRepository.save(existingUsuario);
            return new ResponseEntity<>(existingUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscarPorUsernameYContrasena/{username}")
    public ResponseEntity<Usuario> buscarPorUsername(@PathVariable String username) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuario(username);
        return usuarioOptional.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscarPorUsernameYContrasena/{username}/{contrasena}")
    public ResponseEntity<Usuario> buscarPorUsernameYContrasena(@PathVariable String username, @PathVariable String contrasena) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuarioAndContrasena(username, contrasena);
        return usuarioOptional.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getByDependencia/{dependencia}")
    public ResponseEntity<List<Usuario>> obtenerTodosUsuariosPorOficina(@PathVariable String dependencia) {
        List<Usuario> usuarios = usuarioRepository.findAllByDependencia(dependencia);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    
    @GetMapping("/getByDependenciaHijo/{dependenciaHijo}")
    public ResponseEntity<List<Usuario>> obtenerTodosUsuariosPorDependenciaHijo(@PathVariable String dependenciaHijo) {
        List<Usuario> usuarios = usuarioRepository.findAllByDependenciaHijo(dependenciaHijo);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

}