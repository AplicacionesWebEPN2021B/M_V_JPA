package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Multa;
import modelo.entidades.Vehiculo;
import modelo.implementacionJPA.JPAMultaDAO;


@WebServlet("/ListarMultasController")
public class ListarMultasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarMultasController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JPAMultaDAO multaDAO = (JPAMultaDAO) DAOFactory.getDAOFactory().getMultaDAO();
		int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
		Vehiculo vehiculo = DAOFactory.getDAOFactory().getVehiculoDAO().getById(idVehiculo);
		List<Multa> multas = (List<Multa>) multaDAO.getAllMultas(idVehiculo);
		request.setAttribute("multas", multas);
		request.setAttribute("vehiculo", vehiculo);
		request.getRequestDispatcher("/jsp/listarMultas.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
