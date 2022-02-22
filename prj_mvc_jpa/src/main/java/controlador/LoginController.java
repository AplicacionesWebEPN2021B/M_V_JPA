package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.PersonaDAO;
import modelo.implementacionJPA.JPAPersonaDAO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		JPAPersonaDAO pd = new JPAPersonaDAO();
		if(pd.autenticar(usuario, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario",usuario); 
			session.setAttribute("login","loged in"); 
			response.sendRedirect("ListarVehiculosController");
		}
		else {
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

}