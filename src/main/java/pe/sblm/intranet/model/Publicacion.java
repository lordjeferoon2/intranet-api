package pe.sblm.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 5)
    private String gerencia;
    
    @Column(length = 15)
    private String tipoPublicacion;
    
    @Column(length = 200)
    private String titulo;
    
    @Column(length = 1000)
    private String contenido;
    
    @Column(length = 30)
    private String fechaPublicacion;
    
    @Column(length = 30)
    private String fechaEvento;
    
    @Column(length = 200)
    private String urlDocumento;
        
    public Publicacion() {
    	
    }

	public Publicacion(String gerencia, String tipoPublicacion, String titulo, String contenido,
			String fechaPublicacion, String fechaEvento, String urlDocumento) {
		super();
		this.gerencia = gerencia;
		this.tipoPublicacion = tipoPublicacion;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fechaPublicacion = fechaPublicacion;
		this.fechaEvento = fechaEvento;
		this.urlDocumento = urlDocumento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGerencia() {
		return this.gerencia;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}

	public String getTipoPublicacion() {
		return tipoPublicacion;
	}

	public void setTipoPublicacion(String tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getUrlDocumento() {
		return urlDocumento;
	}

	public void setUrlDocumento(String urlDocumento) {
		this.urlDocumento = urlDocumento;
	}

	@Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", gerencia='" + gerencia + '\'' +
                ", tipoPublicacion='" + tipoPublicacion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaPublicacion='" + fechaPublicacion + '\'' +
                ", fechaEvento='" + fechaEvento + '\'' +
                ", urlDocumento='" + urlDocumento + '\'' +
                '}';
    }

}