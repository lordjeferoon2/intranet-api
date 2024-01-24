package pe.sblm.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.sblm.intranet.model.Recomendacion;

@Repository
public interface RecomendacionRepositorio extends JpaRepository<Recomendacion, Long> {
	List<Recomendacion> findAllByIdPlanAndEstadoOrderByNumeroAsc(Long idPlan, boolean estado);
}