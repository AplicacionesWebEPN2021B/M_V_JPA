package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Vehiculo;

/**
 * Servlet implementation class ActualizarPersonaController
 */
@WebServlet("/ActualizarVehiculoController")
public class ActualizarVehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String idVehiculo = "idVehiculo";
       
    public ActualizarVehiculoController() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Vehiculo v = DAOFactory.getDAOFactory().getVehiculoDAO().getById(Integer.parseInt(request.getParameter(idVehiculo)));
		request.setAttribute(idVehiculo, Integer.parseInt(request.getParameter(idVehiculo)));
		request.setAttribute("placa", v.getPlaca());
		request.setAttribute("marca", v.getMarca());
		request.setAttribute("anio", v.getAnio());
		request.setAttribute("modelo", v.getModelo());
		request.setAttribute("chasis", v.getChasis());
		request.setAttribute("propietario", v.getPropietario());
		request.getRequestDispatcher("/jsp/actualizarVehiculo.jsp").forward(request, response);
		
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int idVehiculo = Integer.parseInt(request.getParameter("txtVehiculo"));
		String placa =  request.getParameter("txtPlaca");
		String marca =  request.getParameter("txtMarca");
		int anio = Integer.parseInt(request.getParameter("txtAnio"));
		String modelo =  request.getParameter("txtModelo");
		String chasis =  request.getParameter("txtChasis");
		String propietario =  request.getParameter("txtPropietario");
		
		DAOFactory.getDAOFactory().getVehiculoDAO().update(new Vehiculo(idVehiculo,placa,marca,anio,modelo,chasis,propietario));
		response.sendRedirect("ListarVehiculosController");
		
		} catch(IOException e) {
			System.err.println("IOException: " + e);
		}
	}

}
