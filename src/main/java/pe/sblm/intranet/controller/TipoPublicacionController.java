package pe.sblm.intranet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sblm.intranet.model.TipoPublicacion;
import pe.sblm.intranet.repository.TipoPublicacionRepositorio;

@RestController
@RequestMapping("/api/tipoPublicaciones")
@CrossOrigin(origins = "*")
public class TipoPublicacionController {
	
	@Autowired
    private TipoPublicacionRepositorio tipoPublicacionRepository;

    @PostMapping
    public ResponseEntity<TipoPublicacion> crearTipoPublicacion(@RequestBody TipoPublicacion TipoPublicacion) {
        TipoPublicacion nuevoTipoPublicacion = tipoPublicacionRepository.save(TipoPublicacion);
        return new ResponseEntity<>(nuevoTipoPublicacion, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoPublicacion> obtenerTipoPublicacionPorId(@PathVariable Long id) {
        Optional<TipoPublicacion> planOptional = tipoPublicacionRepository.findById(id);
        return planOptional.map(plan -> new ResponseEntity<>(plan, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPublicacion> actualizarTipoPublicacion(@PathVariable Long id, @RequestBody TipoPublicacion plan) {
        Optional<TipoPublicacion> planOptional = tipoPublicacionRepository.findById(id);
        if (planOptional.isPresent()) {
            TipoPublicacion existingTipoPublicacion = planOptional.get();
            existingTipoPublicacion.setId(plan.getId());
            existingTipoPublicacion.setNombre(plan.getNombre());
            existingTipoPublicacion.setAccesos(plan.getAccesos());
            return new ResponseEntity<>(existingTipoPublicacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoPublicacion(@PathVariable Long id) {
    	tipoPublicacionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<TipoPublicacion>> obtenerTodosTipoPublicacions() {
    	List<TipoPublicacion> planes = tipoPublicacionRepository.findAll();
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }
      
}
