package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.MultaDAO;
import modelo.dao.VehiculoDAO;
import modelo.entidades.Multa;
import modelo.entidades.Vehiculo;

@WebServlet("/RegistrarMultaController")
public class RegistrarMultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public RegistrarMultaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
		Vehiculo vehiculo = VehiculoDAO.getVehiculo(idVehiculo);
		request.setAttribute("vehiculo", vehiculo);
		request.getRequestDispatcher("/jsp/registrarMulta.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
		double valor = Double.parseDouble(request.getParameter("txtValor"));
		String anio = request.getParameter("txtAnio");
		String descripcion = request.getParameter("txtDescripcion");
		
		MultaDAO.insertar(new Multa(idVehiculo, valor, anio, descripcion));
		response.sendRedirect("ListarMultasController?idVehiculo="+idVehiculo);
	}

}
