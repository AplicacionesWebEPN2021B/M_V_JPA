package modelo.dao;

import modelo.implementacionJPA.JPADAOFactory;

public abstract class DAOFactory {
	protected static JPADAOFactory DAOFactory = new JPADAOFactory();
	
	public static DAOFactory getDAOFactory() {
		return DAOFactory;
	}
	
	public abstract MultaDAO getMultaDAO();
	public abstract VehiculoDAO getVehiculoDAO();
	public abstract PersonaDAO getPersonaDAO();
}
