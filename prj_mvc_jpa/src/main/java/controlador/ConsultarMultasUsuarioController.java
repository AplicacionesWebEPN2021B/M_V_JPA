package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.dao.MultaDAO;
import modelo.dao.VehiculoDAO;
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
				Vehiculo vehiculoPlaca = DAOFactory.getDAOFactory().getVehiculoDAO().getVehiculoByPlaca(placaChasis);
				Vehiculo vehiculoChasis = DAOFactory.getDAOFactory().getVehiculoDAO().getVehiculoByChasis(placaChasis);
				
				if(vehiculoPlaca != null && opcion.equals("r")) {
					
					HttpSession miSesion = request.getSession();
					miSesion.setAttribute("usuario", vehiculoPlaca);
					List<Multa> multaByPlaca = (List<Multa>) multaDAO.getAllMultas(vehiculoPlaca.getIdVehiculo());
					request.setAttribute("multasUsuario", multaByPlaca);
					request.getRequestDispatcher("/jsp/listarMultasUsuario.jsp").forward(request, response);
					
				}else if(vehiculoChasis != null && opcion.equals("r1")){
					HttpSession miSesion = request.getSession();
					miSesion.setAttribute("usuario", vehiculoChasis);
					List<Multa> multaByChasis = (List<Multa>) multaDAO.getAllMultas(vehiculoChasis.getIdVehiculo());
					request.setAttribute("multasUsuario", multaByChasis);
					request.getRequestDispatcher("/jsp/listarMultasUsuario.jsp").forward(request, response);
					
				}else if(vehiculoPlaca == null || opcion.equals("") || vehiculoChasis == null){
					response.sendRedirect("ConsultarMultasUsuarioController");
					
				}
	}

}
