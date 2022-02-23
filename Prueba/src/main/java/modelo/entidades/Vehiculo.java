package modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculo  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdVehiculo;
	@Column(name = "placa")
	private String placa;
	@Column(name = "marca")
	private String marca;
	@Column(name = "anio")
	private Integer anio;
	@Column(name = "modelo")
	private String modelo;
	@Column(name = "chasis")
	private String chasis;
	@Column(name = "propietario")
	private String propietario;
	
	public Vehiculo() {}


	public Vehiculo(Integer idVehiculo, String placa, String marca, Integer anio, String modelo, String chasis,
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


	public Vehiculo(String placa, String marca, Integer anio, String modelo, String chasis, String propietario) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.anio = anio;
		this.modelo = modelo;
		this.chasis = chasis;
		this.propietario = propietario;
	}


	public Integer getIdVehiculo() {
		return IdVehiculo;
	}


	public void setIdVehiculo(Integer idVehiculo) {
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


	public Integer getAnio() {
		return anio;
	}


	public void setAnio(Integer anio) {
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
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vehiculo) {
			return ((Vehiculo) obj).IdVehiculo == this.IdVehiculo || ((Vehiculo) obj).placa == this.placa;
		}
		return false;
	}


	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", anio=" + anio + ", modelo=" + modelo + ", chasis="
				+ chasis + ", propietario=" + propietario + "]";
	}
	

}
