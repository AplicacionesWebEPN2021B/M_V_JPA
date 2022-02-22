package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.MultaDAO;
import modelo.dao.VehiculoDAO;
import modelo.entidades.Multa;
import modelo.entidades.Vehiculo;



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
				
				Vehiculo vehiculoPlaca = VehiculoDAO.getVehiculoByPlaca(placaChasis);
				Vehiculo vehiculoChasis = VehiculoDAO.getVehiculoByChasis(placaChasis);
				
				if(vehiculoPlaca != null && opcion.equals("r")) {
					
					HttpSession miSesion = request.getSession();
					miSesion.setAttribute("usuario", vehiculoPlaca);
					ArrayList<Multa> multaByPlaca = (ArrayList<Multa>) MultaDAO.getMultas(vehiculoPlaca.getIdVehiculo());
					request.setAttribute("multasUsuario", multaByPlaca);
					request.getRequestDispatcher("/jsp/listarMultasUsuario.jsp").forward(request, response);
					
				}else if(vehiculoChasis != null && opcion.equals("r1")){
					HttpSession miSesion = request.getSession();
					miSesion.setAttribute("usuario", vehiculoChasis);
					ArrayList<Multa> multaByChasis = (ArrayList<Multa>) MultaDAO.getMultas(vehiculoChasis.getIdVehiculo());
					request.setAttribute("multasUsuario", multaByChasis);
					request.getRequestDispatcher("/jsp/listarMultasUsuario.jsp").forward(request, response);
					
				}else if(vehiculoPlaca == null || opcion.equals("") || vehiculoChasis == null){
					response.sendRedirect("ConsultarMultasUsuarioController");
					
				}
	}

}
