package modelo.implementacionJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import modelo.dao.MultaDAO;
import modelo.entidades.Multa;

public class JPAMultaDAO extends JPAGenericDAO<Multa, Integer> implements MultaDAO{

	public JPAMultaDAO() {
		super(Multa.class);
	}
	
	public List<Multa> getAllMultas(int idVehiculo){
		List<Multa> multas = new ArrayList<Multa>();
		String consultaMultas = "SELECT m FROM Multa m WHERE m.vehiculo.IdVehiculo = :idVehiculo";
		Query q = this.em.createQuery(consultaMultas);
		q.setParameter("idVehiculo", idVehiculo);
		multas = q.getResultList();
		
		return multas;
	}
}
