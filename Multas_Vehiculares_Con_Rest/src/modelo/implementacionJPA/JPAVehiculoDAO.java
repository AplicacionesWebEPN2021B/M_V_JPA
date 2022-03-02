package modelo.implementacionJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import modelo.dao.VehiculoDAO;
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

	@Override
	public Vehiculo getVehiculoByPlaca(String placa) {
		Vehiculo v = null;
		String consulta = "SELECT v FROM Vehiculo v WHERE v.placa = :placa";
		Query q = this.em.createQuery(consulta);
		q.setParameter("placa", placa);
		v = (Vehiculo) q.getSingleResult();
		
		return v;
	}

	@Override
	public Vehiculo getVehiculoByChasis(String chasis) {
		Vehiculo v = null;
		String consulta = "SELECT v FROM Vehiculo v WHERE v.chasis = :chasis";
		Query q = this.em.createQuery(consulta);
		q.setParameter("chasis", chasis);
		v = (Vehiculo) q.getSingleResult();
		
		return v;
	}
	
	
	

}
