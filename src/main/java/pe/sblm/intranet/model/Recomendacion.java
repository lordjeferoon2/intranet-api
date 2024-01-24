package pe.sblm.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recomendacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long idPlan;
    
    private int numero;
    
    @Column(length = 300)
    private String observacion;
    
    private int nivelRiesgo;
    
    @Column(length = 3000)
    private String recomendacion;
    
    @Column(length = 1000)
    private String acciones;
    
    @Column(length = 3000)
    private String medio;
    
    @Column(length = 30)
    private String fechaFinal;
    
    @Column(length = 300)
    private String unidadResponsable;
    
    @Column(length = 100)
    private String documentoUnidadResponsable;
    
    @Column(length = 50)
    private String dniResponsable;
    
    @Column(length = 250)
    private String nombresResponsable;
    
    @Column(length = 300)
    private String observacionRiesgos;
    
    private Long usuarioCreacion;
    
    private Long usuarioModificacion;
    
    private String fechaCreacion;
    
    private String fechaModificacion;
    
    private boolean estado;
    
    public Recomendacion() {
    	
    }

	public Recomendacion(Long idPlan, int numero, String observacion, int nivelRiesgo, String recomendacion, String acciones,
			String medio, String fechaFinal, String unidadResponsable, String documentoUnidadResponsable,
			String dniResponsable, String nombresResponsable, String observacionRiesgos, Long usuarioCreacion, Long usuarioModificacion,
			String fechaCreacion, String fechaModificacion, boolean estado) {
		super();
		this.idPlan = idPlan;
		this.numero = numero;
		this.observacion = observacion;
		this.nivelRiesgo = nivelRiesgo;
		this.recomendacion = recomendacion;
		this.acciones = acciones;
		this.medio = medio;
		this.fechaFinal = fechaFinal;
		this.unidadResponsable = unidadResponsable;
		this.documentoUnidadResponsable = documentoUnidadResponsable;
		this.dniResponsable = dniResponsable;
		this.nombresResponsable = nombresResponsable;
		this.observacionRiesgos = observacionRiesgos;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Long idPlan) {
		this.idPlan = idPlan;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(int nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	public String getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public String getAcciones() {
		return acciones;
	}

	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getUnidadResponsable() {
		return unidadResponsable;
	}

	public void setUnidadResponsable(String unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
	}

	public String getDocumentoUnidadResponsable() {
		return documentoUnidadResponsable;
	}

	public void setDocumentoUnidadResponsable(String documentoUnidadResponsable) {
		this.documentoUnidadResponsable = documentoUnidadResponsable;
	}

	public String getDniResponsable() {
		return dniResponsable;
	}

	public void setDniResponsable(String dniResponsable) {
		this.dniResponsable = dniResponsable;
	}

	public String getNombresResponsable() {
		return nombresResponsable;
	}

	public void setNombresResponsable(String nombresResponsable) {
		this.nombresResponsable = nombresResponsable;
	}

	public String getObservacionRiesgos() {
		return observacionRiesgos;
	}

	public void setObservacionRiesgos(String observacionRiesgos) {
		this.observacionRiesgos = observacionRiesgos;
	}

	public Long getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Long usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Long getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Long usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreación) {
		this.fechaCreacion = fechaCreación;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
}
