package pe.sblm.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPublicacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 20)
    private String nombre;
    
    @Column(length = 20)
    private String accesos;
    
    public TipoPublicacion() {
    	
    }

	public TipoPublicacion(String nombre, String accesos) {
		super();
		this.nombre = nombre;
		this.accesos = accesos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAccesos() {
		return accesos;
	}

	public void setAccesos(String accesos) {
		this.accesos = accesos;
	}
    
}
