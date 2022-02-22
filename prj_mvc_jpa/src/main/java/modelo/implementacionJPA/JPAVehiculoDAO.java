package modelo.implementacionJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import modelo.dao.VehiculoDAO;
import modelo.entidades.Multa;
import modelo.entidades.Vehiculo;

public class JPAVehiculoDAO extends JPAGenericDAO<Vehiculo, Integer> implements VehiculoDAO{

	public JPAVehiculoDAO() {
		super(Vehiculo.class);
	}

	@Override
	public List<Vehiculo> getAll() {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		String consultaVehiculos = "SELECT v FROM Vehiculo v";
		Query q = this.em.createQuery(consultaVehiculos);
		vehiculos = q.getResultList();
		
		return vehiculos;
	}
	
	

}
