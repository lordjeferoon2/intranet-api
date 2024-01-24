package pe.sblm.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plann")
public class Plan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 150)
    private String nombre;
    
    @Column(length = 150)
    private String entidad;
    
    @Column(length = 150)
    private String informe;
    
    @Column(length = 30)
    private String fechaInforme;
    
    @Column(length = 30)
    private String tipoAuditoria;
    
    @Column(length = 150)
    private String entidadAuditora;
    
    @Column(length = 100)
    private String titularEntidadAuditora;
    
    public Plan() {
    	
    }

	public Plan(String nombre, String entidad, String informe, String fechaInforme, String tipoAuditoria, String entidadAuditora, String titularEntidadAuditora) {
		super();
		this.nombre = nombre;
		this.entidad = entidad;
		this.informe = informe;
		this.fechaInforme = fechaInforme;
		this.tipoAuditoria = tipoAuditoria;
		this.entidadAuditora = entidadAuditora;
		this.titularEntidadAuditora = titularEntidadAuditora;
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

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getInforme() {
		return informe;
	}

	public void setInforme(String informe) {
		this.informe = informe;
	}

	public String getFechaInforme() {
		return fechaInforme;
	}

	public void setFechaInforme(String fechaInforme) {
		this.fechaInforme = fechaInforme;
	}

	public String getTipoAuditoria() {
		return tipoAuditoria;
	}

	public void setTipoAuditoria(String tipoAuditoria) {
		this.tipoAuditoria = tipoAuditoria;
	}

	public String getEntidadAuditora() {
		return entidadAuditora;
	}

	public void setEntidadAuditora(String entidadAuditora) {
		this.entidadAuditora = entidadAuditora;
	}

	public String getTitularEntidadAuditora() {
		return titularEntidadAuditora;
	}

	public void setTitularEntidadAuditora(String titularEntidadAuditora) {
		this.titularEntidadAuditora = titularEntidadAuditora;
	}

}