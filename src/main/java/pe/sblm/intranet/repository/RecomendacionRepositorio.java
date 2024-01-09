package pe.sblm.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sblm.intranet.model.Recomendacion;

public interface RecomendacionRepositorio extends JpaRepository<Recomendacion, Long> {
	List<Recomendacion> findAllByIdPlan(Long idPlan);
}