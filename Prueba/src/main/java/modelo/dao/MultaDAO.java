package modelo.dao;

import java.util.List;

import modelo.entidades.Multa;

public interface MultaDAO extends GenericDAO<Multa, Integer>{
	public List<Multa> getAllMultas(int idVehiculo);
}
