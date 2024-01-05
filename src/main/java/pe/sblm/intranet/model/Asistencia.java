package pe.sblm.intranet.model;

public class Asistencia {
    private long idasistencia;
    private String codreloj;
    private String dhoraingre;
    private String dfechaingre;
    private String numreloj;
    private String dfechudp;
    private String vusuario;
    private String vestacion;
    private String papeleta;
    private String idtrab_pap;
    
	public Asistencia() {
	    	
	}
  
    public Asistencia(long idasistencia, String codreloj, String dhoraingre, String dfechaingre, String numreloj,
			String dfechudp, String vusuario, String vestacion, String papeleta, String idtrab_pap) {
		super();
		this.idasistencia = idasistencia;
		this.codreloj = codreloj;
		this.dhoraingre = dhoraingre;
		this.dfechaingre = dfechaingre;
		this.numreloj = numreloj;
		this.dfechudp = dfechudp;
		this.vusuario = vusuario;
		this.vestacion = vestacion;
		this.papeleta = papeleta;
		this.idtrab_pap = idtrab_pap;
	}

	public long getIdasistencia() {
		return idasistencia;
	}

	public void setIdasistencia(long idasistencia) {
		this.idasistencia = idasistencia;
	}

	public String getCodreloj() {
		return codreloj;
	}

	public void setCodreloj(String codreloj) {
		this.codreloj = codreloj;
	}

	public String getDhoraingre() {
		return dhoraingre;
	}

	public void setDhoraingre(String dhoraingre) {
		this.dhoraingre = dhoraingre;
	}

	public String getDfechaingre() {
		return dfechaingre;
	}

	public void setDfechaingre(String dfechaingre) {
		this.dfechaingre = dfechaingre;
	}

	public String getNumreloj() {
		return numreloj;
	}

	public void setNumreloj(String numreloj) {
		this.numreloj = numreloj;
	}

	public String getDfechudp() {
		return dfechudp;
	}

	public void setDfechudp(String dfechudp) {
		this.dfechudp = dfechudp;
	}

	public String getVusuario() {
		return vusuario;
	}

	public void setVusuario(String vusuario) {
		this.vusuario = vusuario;
	}

	public String getVestacion() {
		return vestacion;
	}

	public void setVestacion(String vestacion) {
		this.vestacion = vestacion;
	}

	public String getPapeleta() {
		return papeleta;
	}

	public void setPapeleta(String papeleta) {
		this.papeleta = papeleta;
	}

	public String getIdtrab_pap() {
		return idtrab_pap;
	}

	public void setIdtrab_pap(String idtrab_pap) {
		this.idtrab_pap = idtrab_pap;
	}
    
}