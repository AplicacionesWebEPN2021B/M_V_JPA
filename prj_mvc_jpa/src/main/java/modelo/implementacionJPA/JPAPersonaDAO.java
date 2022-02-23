package modelo.implementacionJPA;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona,Integer> implements PersonaDAO{

	public JPAPersonaDAO() {
		super(Persona.class);
	}
	
	@Override
	public boolean autenticar(String usuario, String password) {
		List<Persona> personas = new ArrayList<Persona>();
		String seleccionarPersona = "SELECT p FROM Persona p WHERE p.usuario = :usuario AND p.password = :password";
		Query q = this.em.createQuery(seleccionarPersona);
		q.setParameter("usuario", usuario);
		q.setParameter("password", password);
		personas = q.getResultList();
		if(personas.size()>0) {
			return true;
		}
		return false;
	}
}
