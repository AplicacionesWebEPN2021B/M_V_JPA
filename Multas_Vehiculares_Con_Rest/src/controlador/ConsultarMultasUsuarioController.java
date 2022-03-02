package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Multa;
import modelo.entidades.Vehiculo;
import modelo.implementacionJPA.JPAMultaDAO;



/**
 * Servlet implementation class ConsultarMutasUsuarioController
 */
@WebServlet("/ConsultarMultasUsuarioController")
public class ConsultarMultasUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ConsultarMultasUsuarioController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/consultarMultas.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.- Obtengo los parametros de la vista
				String placaChasis = request.getParameter("txtPlacaChasis");
				String opcion = request.getParameter("placaChasis");
				
				
				//2.- Llamo al modelo para conocer si puedo autenticar 
				JPAMultaDAO multaDAO = (JPAMultaDAO) DAOFactory.getDAOFactory().getMultaDAO();
				
				try {
					if(opcion.equals("r")) {
						Vehiculo vehiculoPlaca = DAOFactory.getDAOFactory().getVehiculoDAO().getVehiculoByPlaca(placaChasis);
						HttpSession miSesion = request.getSession();
						miSesion.setAttribute("usuario", vehiculoPlaca);
						List<Multa> multaByPlaca = (List<Multa>) multaDAO.getAllMultas(vehiculoPlaca.getIdVehiculo());
						request.setAttribute("multasUsuario", multaByPlaca);
						request.getRequestDispatcher("/jsp/listarMultasUsuario.jsp").forward(request, response);
						
					}else if(opcion.equals("r1")){
						Vehiculo vehiculoChasis = DAOFactory.getDAOFactory().getVehiculoDAO().getVehiculoByChasis(placaChasis);
						HttpSession miSesion = request.getSession();
						miSesion.setAttribute("usuario", vehiculoChasis);
						List<Multa> multaByChasis = (List<Multa>) multaDAO.getAllMultas(vehiculoChasis.getIdVehiculo());
						request.setAttribute("multasUsuario", multaByChasis);
						request.getRequestDispatcher("/jsp/listarMultasUsuario.jsp").forward(request, response);
						
					}
				}catch(Exception e) {
					response.sendRedirect("ConsultarMultasUsuarioController");
				}
	}

}
