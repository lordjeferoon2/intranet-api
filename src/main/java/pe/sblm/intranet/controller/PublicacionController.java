package pe.sblm.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.sblm.intranet.model.Documento;
import pe.sblm.intranet.model.Publicacion;
import pe.sblm.intranet.repository.DocumentoRepositorio;
import pe.sblm.intranet.repository.PublicacionRepositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publicaciones")
@CrossOrigin(origins = "*")
public class PublicacionController {

    @Autowired
    private PublicacionRepositorio publicacionRepo;
    
    @Autowired
    private DocumentoRepositorio documentoRepo;

    @PostMapping
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        Publicacion nuevaPublicacion = publicacionRepo.save(publicacion);
        //String fecha = LocalDateTime.now().toString().substring(0, 10);
        //nuevaPublicacion.setFechaPublicacion(fecha);
        System.out.print(nuevaPublicacion.toString());
        return ResponseEntity.ok(nuevaPublicacion);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        Optional<Publicacion> publicacionOptional = publicacionRepo.findById(id);

        if (publicacionOptional.isPresent()) {
            Publicacion existingPublicacion = publicacionOptional.get();
            existingPublicacion.setTipoPublicacion(publicacion.getTipoPublicacion());
            existingPublicacion.setTitulo(publicacion.getTitulo());
            existingPublicacion.setContenido(publicacion.getContenido());

            Publicacion updatedPublicacion = publicacionRepo.save(existingPublicacion);
            return ResponseEntity.ok(updatedPublicacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        Optional<Publicacion> publicacionOptional = publicacionRepo.findById(id);

        if (publicacionOptional.isPresent()) {
        	publicacionRepo.deleteById(id);
            return ResponseEntity.ok().<Void>build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public List<Publicacion> obtenerTodas() {
        return publicacionRepo.findAll();
    }


    @GetMapping("/all/{gerencia}")
    public ResponseEntity<List<Publicacion>> obtenerTodasPublicaciones(@PathVariable String gerencia) {
    	List<Publicacion> publicaciones = publicacionRepo.findAllByGerencia(gerencia);
    	for(int i=0; i<publicaciones.size(); i++) {
    		List<Documento> documentos = documentoRepo.findAllByIdPublicacion(publicaciones.get(i).getId());
    		publicaciones.get(i).setUrlDocumento(documentos.get(0).getUrlDocumento());
    	}
    	 return ResponseEntity.ok(publicaciones);
    }

    @GetMapping("/all/por-tipo/{tipo}")
    public ResponseEntity<List<Publicacion>> obtenerPublicacionesPorTipo(@PathVariable String tipo) {
        List<Publicacion> publicaciones = publicacionRepo.findAllByTipoPublicacion(tipo);
        for(int i=0; i<publicaciones.size(); i++) {
        	List<Documento> documentos = documentoRepo.findAllByIdPublicacion(publicaciones.get(i).getId());
    		publicaciones.get(i).setUrlDocumento(documentos.get(0).getUrlDocumento());
    	}
        
        if(tipo.equals("Comunicaciones")) {
            List<Publicacion> publicaciones2 = publicacionRepo.findAllByTipoPublicacion("Eventos");
            for(int i=0; i<publicaciones2.size(); i++) {
                List<Documento> documentos = documentoRepo.findAllByIdPublicacion(publicaciones2.get(i).getId());
                publicaciones2.get(i).setUrlDocumento(documentos.get(0).getUrlDocumento());
            }

            List<Publicacion> publicaciones3 = publicacionRepo.findAllByTipoPublicacion("Galería");
            for(int i=0; i<publicaciones3.size(); i++) {
                List<Documento> documentos = documentoRepo.findAllByIdPublicacion(publicaciones3.get(i).getId());
                publicaciones3.get(i).setUrlDocumento(documentos.get(0).getUrlDocumento());
            }

            publicaciones.addAll(publicaciones2);
            publicaciones.addAll(publicaciones3);
        }
    	return ResponseEntity.ok(publicaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable Long id) {
        Optional<Publicacion> publicacionOptional = publicacionRepo.findById(id);
        return publicacionOptional.map(publicacion -> ResponseEntity.ok(publicacion))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}