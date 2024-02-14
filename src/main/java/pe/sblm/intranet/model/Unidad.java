package pe.sblm.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Unidad {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 150)
    private String nomUnidad;

	@Column(length = 5)
    private String abrUnidad;
    
    @Column(length = 5)
    private String abrUnidadPrincipal; 
    
    @Column(length = 30)
    private boolean estUnidad;
    
    @Column(length = 30)
    private boolean depUnidad;

	
	public Unidad() {
		
	}
    
    public Unidad(Long id, String nomUnidad, String abrUnidad, String abrUnidadPrincipal, boolean estUnidad, boolean depUnidad) {
		super();
		this.id = id;
		this.nomUnidad = nomUnidad;
		this.abrUnidad = abrUnidad;
		this.abrUnidadPrincipal = abrUnidadPrincipal;
		this.estUnidad = estUnidad;
		this.depUnidad = depUnidad;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomUnidad() {
		return nomUnidad;
	}


	public void setNomUnidad(String nomUnidad) {
		this.nomUnidad = nomUnidad;
	}


	public String getAbrUnidad() {
		return abrUnidad;
	}


	public void setAbrUnidad(String abrUnidad) {
		this.abrUnidad = abrUnidad;
	}


	public String getAbrUnidadPrincipal() {
		return abrUnidadPrincipal;
	}


	public void setAbrUnidadPrincipal(String abrUnidadPrincipal) {
		this.abrUnidadPrincipal = abrUnidadPrincipal;
	}


	public boolean isEstUnidad() {
		return estUnidad;
	}


	public void setEstUnidad(boolean estUnidad) {
		this.estUnidad = estUnidad;
	}


	public boolean isDepUnidad() {
		return depUnidad;
	}


	public void setDepUnidad(boolean depUnidad) {
		this.depUnidad = depUnidad;
	}
	 
	

}
