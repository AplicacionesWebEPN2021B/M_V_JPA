package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.VehiculoDAO;
import modelo.entidades.Vehiculo;

/**
 * Servlet implementation class ActualizarPersonaController
 */
@WebServlet("/ActualizarVehiculoController")
public class ActualizarVehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActualizarVehiculoController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vehiculo v = VehiculoDAO.getVehiculo(Integer.parseInt(request.getParameter("idVehiculo")));
		request.setAttribute("idVehiculo", Integer.parseInt(request.getParameter("idVehiculo")));
		request.setAttribute("placa", v.getPlaca());
		request.setAttribute("marca", v.getMarca());
		request.setAttribute("anio", v.getAnio());
		request.setAttribute("modelo", v.getModelo());
		request.setAttribute("chasis", v.getChasis());
		request.setAttribute("propietario", v.getPropietario());
		request.getRequestDispatcher("/jsp/actualizarVehiculo.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idVehiculo = Integer.parseInt(request.getParameter("txtVehiculo"));
		String placa =  request.getParameter("txtPlaca");
		String marca =  request.getParameter("txtMarca");
		int anio = Integer.parseInt(request.getParameter("txtAnio"));
		String modelo =  request.getParameter("txtModelo");
		String chasis =  request.getParameter("txtChasis");
		String propietario =  request.getParameter("txtPropietario");
		
		Vehiculo v = new Vehiculo(idVehiculo,placa,marca,anio,modelo,chasis,propietario);
		VehiculoDAO personaDAO = new VehiculoDAO();
		personaDAO.actualizar(v);
		response.sendRedirect("ListarVehiculosController");
	}

}
