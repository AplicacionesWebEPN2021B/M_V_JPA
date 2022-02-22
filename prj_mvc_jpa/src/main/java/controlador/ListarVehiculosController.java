package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.VehiculoDAO;
import modelo.entidades.Vehiculo;

/**
 * Servlet implementation class ListarPersonasController
 */
@WebServlet("/ListarVehiculosController")
public class ListarVehiculosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarVehiculosController() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Object loginString = session.getAttribute("login");
		if (session != null  && loginString != null) {
			VehiculoDAO vehiculoDAO = new VehiculoDAO();
			List<Vehiculo> listaVehiculos = vehiculoDAO.getVehiculos();
			request.setAttribute("listaVehiculos", listaVehiculos);
			request.getRequestDispatcher("/jsp/listarVehiculos.jsp").forward(request, response);			
		}
		else {
			response.sendRedirect("LogOutController");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
