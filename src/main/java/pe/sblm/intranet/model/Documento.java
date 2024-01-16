package pe.sblm.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idPublicacion;
    
    @Column(length = 200)
    private String urlDocumento;
    
    public Documento() {
    	
    }

	public Documento(Long idPublicacion, String urlDocumento) {
		super();
		this.idPublicacion = idPublicacion;
		this.urlDocumento = urlDocumento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(Long idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public String getUrlDocumento() {
		return urlDocumento;
	}

	public void setUrlDocumento(String urlDocumento) {
		this.urlDocumento = urlDocumento;
	}
    
}