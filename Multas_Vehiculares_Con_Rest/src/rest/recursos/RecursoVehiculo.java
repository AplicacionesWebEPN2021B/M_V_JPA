package rest.recursos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelo.dao.DAOFactory;
import modelo.entidades.Vehiculo;

@Path("/vehiculos")
public class RecursoVehiculo {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehiculo> getVehiculo(){
		return DAOFactory.getDAOFactory().getVehiculoDAO().getAll();
	}
	@GET
	@Path("/listByPlaca/{placa}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vehiculo getVehiculoByPlaca(@PathParam("placa") String placa){
		return DAOFactory.getDAOFactory().getVehiculoDAO().getVehiculoByPlaca(placa);
	}
	
	@GET
	@Path("/listByChasis/{chasis}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vehiculo getVehiculoByChasis(@PathParam("chasis") String chasis){
		return DAOFactory.getDAOFactory().getVehiculoDAO().getVehiculoByChasis(chasis);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void guardarVehiculo(Vehiculo v) {
		DAOFactory.getDAOFactory().getVehiculoDAO().create(v);
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizarVehiculo(Vehiculo v) {
		DAOFactory.getDAOFactory().getVehiculoDAO().update(v);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarVehiculo(@PathParam("id") int id) {
		DAOFactory.getDAOFactory().getVehiculoDAO().deleteById(id);
	}
}
