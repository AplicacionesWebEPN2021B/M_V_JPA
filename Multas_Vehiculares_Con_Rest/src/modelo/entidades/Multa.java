package modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "multa")
public class Multa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMulta;
	@ManyToOne()
	@JoinColumn(name = "idVehiculo")
	private Vehiculo vehiculo;
	@Column(name = "valor")
	private Double valor;
	@Column(name = "anio")
	private String anio;
	@Column(name = "descripcion")
	private String descripcion;
	
	public Multa() {}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Multa(Vehiculo vehiculo, Double valor, String anio, String descripcion) {
		super();
		this.vehiculo = vehiculo;
		this.valor = valor;
		this.anio = anio;
		this.descripcion = descripcion;
	}

	public Multa(Integer idMulta, Vehiculo vehiculo, Double valor, String anio, String descripcion) {
		super();
		this.idMulta = idMulta;
		this.vehiculo = vehiculo;
		this.valor = valor;
		this.anio = anio;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdMulta() {
		return idMulta;
	}

	public void setIdMulta(Integer idMulta) {
		this.idMulta = idMulta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Multa) {
			return ((Multa) obj).idMulta == this.idMulta;
		}
		return false;
	}
	
	
	
}
