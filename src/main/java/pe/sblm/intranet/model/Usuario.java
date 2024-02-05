package pe.sblm.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombres;

    @Column(length = 50)
    private String apellidos;
    
    @Column(length = 8)
    private String dni;

    @Column(length = 20)
    private String usuario;

    @Column(length = 20)
    private String contrasena;

    private int tipo;
    
    @Column(length = 50)
    private String accesos;

    @Column(length = 25)
    private String dependencia;

    @Column(length = 25)
    private String dependenciaHijo;
    
    @Column(length = 50)
    private String correo;

    @Column(length = 50)
    private String sede;

	@Column(length = 250)
	private String cargo;
    
    private boolean estado;
    
    public Usuario() {
    	
    }
    
	public Usuario(String nombres, String apellidos, String dni, String usuario, String contrasena, int tipo,
			String accesos, String dependencia, String dependenciaHijo, String correo, String sede, String cargo,
				   boolean estado) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.accesos = accesos;
		this.dependencia = dependencia;
		this.dependenciaHijo = dependenciaHijo;
		this.correo = correo;
		this.sede = sede;
		this.cargo = cargo;
		this.estado = estado;
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
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSede() {
		return sede;
	}
	
	public void setSede(String sede) {
		this.sede = sede;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getAccesos() {
		return accesos;
	}

	public void setAccesos(String accesos) {
		this.accesos = accesos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
    
}