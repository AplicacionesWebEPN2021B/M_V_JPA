package modelo.entidades;

import java.io.Serializable;

public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int IdVehiculo;
	private String placa;
	private String marca;
	private int anio;
	private String modelo;
	private String chasis;
	private String propietario;
	
	public Vehiculo() {}


	public Vehiculo(int idVehiculo, String placa, String marca, int anio, String modelo, String chasis,
			String propietario) {
		super();
		IdVehiculo = idVehiculo;
		this.placa = placa;
		this.marca = marca;
		this.anio = anio;
		this.modelo = modelo;
		this.chasis = chasis;
		this.propietario = propietario;
	}


	public Vehiculo(String placa, String marca, int anio, String modelo, String chasis, String propietario) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.anio = anio;
		this.modelo = modelo;
		this.chasis = chasis;
		this.propietario = propietario;
	}


	public int getIdVehiculo() {
		return IdVehiculo;
	}


	public void setIdVehiculo(int idVehiculo) {
		IdVehiculo = idVehiculo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getChasis() {
		return chasis;
	}


	public void setChasis(String chasis) {
		this.chasis = chasis;
	}


	public String getPropietario() {
		return propietario;
	}


	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}


	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", anio=" + anio + ", modelo=" + modelo + ", chasis="
				+ chasis + ", propietario=" + propietario + "]";
	}
	
	
}
