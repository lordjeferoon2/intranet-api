package pe.sblm.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.sblm.intranet.model.TipoPublicacion;

@Repository
public interface TipoPublicacionRepositorio  extends JpaRepository<TipoPublicacion, Long> {

}
