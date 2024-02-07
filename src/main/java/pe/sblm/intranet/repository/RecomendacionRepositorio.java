package pe.sblm.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.sblm.intranet.model.Recomendacion;

@Repository
public interface RecomendacionRepositorio extends JpaRepository<Recomendacion, Long> {
	List<Recomendacion> findAllByIdPlanAndEstadoOrderByNumeroAsc(Long idPlan, boolean estado);

	@Query("SELECT r FROM Recomendacion r " + "WHERE r.fechaCreacion = ("
			+ "    SELECT MAX(r2.fechaCreacion) FROM Recomendacion r2 " + "    WHERE r2.numero = r.numero "
			+ "    AND r2.fechaCreacion <= :fecha AND r2.idPlan = :plan" + ") AND r.idPlan = :plan")
	List<Recomendacion> obtenerRecomendacionesHastaFecha(@Param("fecha") String fecha, @Param("plan") Long plan);
}