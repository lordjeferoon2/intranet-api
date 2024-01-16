package pe.sblm.intranet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sblm.intranet.model.Documento;

public interface DocumentoRepositorio  extends JpaRepository<Documento, Long> {
	
	List<Documento> findAllByIdPublicacion(Long idPublicacion);
	
}
