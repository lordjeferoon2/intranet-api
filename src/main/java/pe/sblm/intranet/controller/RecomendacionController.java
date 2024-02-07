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

import pe.sblm.intranet.model.Recomendacion;
import pe.sblm.intranet.repository.RecomendacionRepositorio;

@RestController
@RequestMapping("/api/recomendaciones")
@CrossOrigin(origins = "*")
public class RecomendacionController {
	@Autowired
    private RecomendacionRepositorio recomendacionRepository;

    @PostMapping
    public ResponseEntity<Recomendacion> crearRecomendacion(@RequestBody Recomendacion recomendacion) {
        Recomendacion nuevoRecomendacion = recomendacionRepository.save(recomendacion);
        return new ResponseEntity<>(nuevoRecomendacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recomendacion> actualizarRecomendacion(@PathVariable Long id, @RequestBody Recomendacion recomendacion) {
        Optional<Recomendacion> recomendacionOptional = recomendacionRepository.findById(id);
        if (recomendacionOptional.isPresent()) {
            Recomendacion existingRecomendacion = recomendacionOptional.get();
            existingRecomendacion.setIdPlan(recomendacion.getIdPlan());
            existingRecomendacion.setNumero(recomendacion.getNumero());
            existingRecomendacion.setObservacion(recomendacion.getObservacion());
            existingRecomendacion.setNivelRiesgo(recomendacion.getNivelRiesgo());
            existingRecomendacion.setRecomendacion(recomendacion.getRecomendacion());
            existingRecomendacion.setAcciones(recomendacion.getAcciones());
            existingRecomendacion.setMedio(recomendacion.getMedio());
            existingRecomendacion.setFechaFinal(recomendacion.getFechaFinal());
            existingRecomendacion.setUnidadResponsable(recomendacion.getUnidadResponsable());
            existingRecomendacion.setDocumentoUnidadResponsable(recomendacion.getDocumentoUnidadResponsable());
            existingRecomendacion.setDniResponsable(recomendacion.getDniResponsable());
            existingRecomendacion.setNombresResponsable(recomendacion.getNombresResponsable());
            existingRecomendacion.setObservacionRiesgos(recomendacion.getObservacionRiesgos());
            existingRecomendacion.setUsuarioCreacion(recomendacion.getUsuarioCreacion());
            existingRecomendacion.setUsuarioModificacion(recomendacion.getUsuarioModificacion());
            existingRecomendacion.setFechaCreacion(recomendacion.getFechaCreacion());
            existingRecomendacion.setFechaModificacion(recomendacion.getFechaModificacion());
            existingRecomendacion.setEstado(recomendacion.isEstado());
            
            recomendacionRepository.save(existingRecomendacion);
            return new ResponseEntity<>(existingRecomendacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecomendacion(@PathVariable Long id) {
        recomendacionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Recomendacion>> obtenerTodosRecomendacions() {
        List<Recomendacion> recomendacions = recomendacionRepository.findAll();
        return new ResponseEntity<>(recomendacions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recomendacion> obtenerRecomendacionPorId(@PathVariable Long id) {
        Optional<Recomendacion> recomendacionOptional = recomendacionRepository.findById(id);
        return recomendacionOptional.map(recomendacion -> new ResponseEntity<>(recomendacion, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getByPlan/{plan}")
    public ResponseEntity<List<Recomendacion>> obtenerTodosRecomendacionesPorPlan(@PathVariable Long plan) {
        List<Recomendacion> recomendacions = recomendacionRepository.findAllByIdPlanAndEstadoOrderByNumeroAsc(plan, true);
        return new ResponseEntity<>(recomendacions, HttpStatus.OK);
    }
    
    @GetMapping("/getByDate/{fecha}/{plan}")
    public ResponseEntity<List<Recomendacion>> obtenerTodosRecomendacionesHastaFecha(@PathVariable String fecha, @PathVariable Long plan) {
        List<Recomendacion> recomendacions = recomendacionRepository.obtenerRecomendacionesHastaFecha(fecha, plan);
        return new ResponseEntity<>(recomendacions, HttpStatus.OK);
    }
}
