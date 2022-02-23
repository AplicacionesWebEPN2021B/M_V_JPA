package modelo.implementacionJPA;

import modelo.dao.DAOFactory;
import modelo.dao.MultaDAO;
import modelo.dao.PersonaDAO;
import modelo.dao.VehiculoDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public MultaDAO getMultaDAO() {
		return new JPAMultaDAO();
	}

	@Override
	public VehiculoDAO getVehiculoDAO() {
		return new JPAVehiculoDAO();
	}
	
	@Override
	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

}
