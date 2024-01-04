package pe.sblm.intranet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasena;
    private int tipo;
    private String dependencia;
    private String dependenciaHijo;
    private String sede;
    
    public Usuario() {
    	
    }
    
	public Usuario(String nombres, String apellidos, String usuario, String contrasena, int tipo, String dependencia,
			String dependenciaHijo, String sede) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.dependencia = dependencia;
		this.dependenciaHijo = dependenciaHijo;
		this.sede = sede;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getDependencia() {
		return dependencia;
	}
	
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	
	public String getDependenciaHijo() {
		return dependenciaHijo;
	}
	
	public void setDependenciaHijo(String dependenciaHijo) {
		this.dependenciaHijo = dependenciaHijo;
	}
	
	public String getSede() {
		return sede;
	}
	
	public void setSede(String sede) {
		this.sede = sede;
	}
    
}