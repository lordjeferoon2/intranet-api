package pe.sblm.intranet.model;

import java.time.LocalDateTime;

public class Trabajador {
    private Long id;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String dni;
    private String sexo;
    private String celular;
    private LocalDateTime fecNaci;
    private LocalDateTime fecIngreso;
    
    public Trabajador() {
    	
    }
    
	public Trabajador(Long id, String nombre, String apePaterno, String apeMaterno, String dni, String sexo,
			String celular, LocalDateTime fecNaci, LocalDateTime fecIngreso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.dni = dni;
		this.sexo = sexo;
		this.celular = celular;
		this.fecNaci = fecNaci;
		this.fecIngreso = fecIngreso;
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
	
	public String getApePaterno() {
		return apePaterno;
	}
	
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	
	public String getApeMaterno() {
		return apeMaterno;
	}
	
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public LocalDateTime getFecNaci() {
		return fecNaci;
	}
	
	public void setFecNaci(LocalDateTime fecNaci) {
		this.fecNaci = fecNaci;
	}
	
	public LocalDateTime getFecIngreso() {
		return fecIngreso;
	}
	
	public void setFecIngreso(LocalDateTime fecIngreso) {
		this.fecIngreso = fecIngreso;
	}
    
}
