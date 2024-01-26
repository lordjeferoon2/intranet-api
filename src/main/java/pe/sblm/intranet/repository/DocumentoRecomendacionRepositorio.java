package pe.sblm.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sblm.intranet.model.DocumentoRecomendacion;

public interface DocumentoRecomendacionRepositorio  extends JpaRepository<DocumentoRecomendacion, Long> {
	
	List<DocumentoRecomendacion> findAllByIdRecomendacion(Long idRecomendacion);
	
}
