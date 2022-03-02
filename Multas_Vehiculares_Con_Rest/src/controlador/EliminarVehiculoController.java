package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;

/**
 * Servlet implementation class EliminarVehiculoController
 */
@WebServlet("/EliminarVehiculoController")
public class EliminarVehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EliminarVehiculoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
		DAOFactory.getDAOFactory().getVehiculoDAO().deleteById(idVehiculo);
		response.sendRedirect("ListarVehiculosController");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
