package modelo.dao;

import modelo.entidades.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer>{
	public boolean autenticar(String usuario, String password);
}
