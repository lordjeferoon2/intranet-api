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

import pe.sblm.intranet.model.Unidad;
import pe.sblm.intranet.repository.UnidadRepositorio;

@RestController
@RequestMapping("/api/unidades")
@CrossOrigin(origins = "*")
public class UnidadController {
    @Autowired
    private UnidadRepositorio unidadRepository;

    @PostMapping
    public ResponseEntity<Unidad> crearUnidad(@RequestBody Unidad unidad) {
        Unidad nuevoUnidad = unidadRepository.save(unidad);
        return new ResponseEntity<Unidad>(nuevoUnidad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidad> actualizarUnidad(@PathVariable Long id, @RequestBody Unidad unidad) {
        Optional<Unidad> unidadOptional = unidadRepository.findById(id);
        if (unidadOptional.isPresent()) {
            Unidad existingUnidad = unidadOptional.get();
            existingUnidad.setNomUnidad(unidad.getNomUnidad());
            existingUnidad.setAbrUnidad(unidad.getAbrUnidad());
            existingUnidad.setAbrUnidadPrincipal(unidad.getAbrUnidadPrincipal());
            existingUnidad.setEstUnidad(unidad.isEstUnidad());
            existingUnidad.setDepUnidad(unidad.isDepUnidad());
            unidadRepository.save(existingUnidad);
            return new ResponseEntity<>(existingUnidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUnidad(@PathVariable Long id) {
    	unidadRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Unidad>> obtenerTodosUnidads() {
        List<Unidad> unidads = unidadRepository.findAll();
        return new ResponseEntity<>(unidads, HttpStatus.OK);
    }

}
