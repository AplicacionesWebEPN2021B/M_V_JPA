package Test;

import modelo.dao.DAOFactory;

public class Test {

	public static void main(String[] args) {
		DAOFactory.getDAOFactory().getVehiculoDAO().getAll()
		.forEach(v -> System.out.println(v));
		
	}

}
