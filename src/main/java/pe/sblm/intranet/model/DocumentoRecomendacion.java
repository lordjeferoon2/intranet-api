package pe.sblm.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocumentoRecomendacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idRecomendacion;
    
    @Column(length = 200)
    private String urlDocumento;
    
    @Column(length = 200)
    private String nombreDocumento;
    
    @Column(length = 30)
    private String fechaDocumento;
    
    public DocumentoRecomendacion() {
    	
    }
    
	public DocumentoRecomendacion(Long idRecomendacion, String urlDocumento, String nombreDocumento,
			String fechaDocumento) {
		super();
		this.idRecomendacion = idRecomendacion;
		this.urlDocumento = urlDocumento;
		this.nombreDocumento = nombreDocumento;
		this.fechaDocumento = fechaDocumento;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRecomendacion() {
		return idRecomendacion;
	}


	public void setIdRecomendacion(Long idRecomendacion) {
		this.idRecomendacion = idRecomendacion;
	}


	public String getFechaDocumento() {
		return fechaDocumento;
	}


	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}


	public String getUrlDocumento() {
		return urlDocumento;
	}

	public void setUrlDocumento(String urlDocumento) {
		this.urlDocumento = urlDocumento;
	}
    
}
