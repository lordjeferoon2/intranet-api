package pe.sblm.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sblm.intranet.model.Plan;

public interface PlanRepositorio  extends JpaRepository<Plan, Long> {

}
