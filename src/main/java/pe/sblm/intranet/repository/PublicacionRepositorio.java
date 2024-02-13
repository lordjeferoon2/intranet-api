package pe.sblm.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.sblm.intranet.model.Publicacion;

@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {
	List<Publicacion> findAllByGerencia(String gerencia);

    List<Publicacion> findAllByTipoPublicacion(String tipo);
}