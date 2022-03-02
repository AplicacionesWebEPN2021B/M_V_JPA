package modelo.dao;

import modelo.entidades.Vehiculo;

public interface VehiculoDAO extends GenericDAO<Vehiculo, Integer>{
	public Vehiculo getVehiculoByPlaca(String placa);
	public Vehiculo getVehiculoByChasis(String placa);
}
