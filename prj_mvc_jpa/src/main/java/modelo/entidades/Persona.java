package modelo.entidades;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idPersona;
	private String usuario;
	private String password;
	
	public Persona() {}

	public Persona(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", usuario=" + usuario + ", password=" + password + "]";
	}
	
	
}