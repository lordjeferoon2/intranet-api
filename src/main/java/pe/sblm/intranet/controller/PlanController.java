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

import pe.sblm.intranet.model.Plan;
import pe.sblm.intranet.repository.PlanRepositorio;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "*")
public class PlanController {
	
	@Autowired
    private PlanRepositorio planRepository;

    @PostMapping
    public ResponseEntity<Plan> crearPlan(@RequestBody Plan Plan) {
        Plan nuevoPlan = planRepository.save(Plan);
        return new ResponseEntity<>(nuevoPlan, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Plan> obtenerPlanPorId(@PathVariable Long id) {
        Optional<Plan> planOptional = planRepository.findById(id);
        return planOptional.map(plan -> new ResponseEntity<>(plan, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> actualizarPlan(@PathVariable Long id, @RequestBody Plan plan) {
        Optional<Plan> planOptional = planRepository.findById(id);
        if (planOptional.isPresent()) {
            Plan existingPlan = planOptional.get();
            existingPlan.setId(plan.getId());
            existingPlan.setEntidad(plan.getEntidad());
            existingPlan.setInforme(plan.getInforme());
            existingPlan.setFechaInforme(plan.getFechaInforme());
            existingPlan.setTipoAuditoria(plan.getTipoAuditoria());
            existingPlan.setEntidadAuditora(plan.getEntidadAuditora());
            return new ResponseEntity<>(existingPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPlan(@PathVariable Long id) {
    	planRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Plan>> obtenerTodosPlans() {
    	List<Plan> planes = planRepository.findAll();
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }
      
}
