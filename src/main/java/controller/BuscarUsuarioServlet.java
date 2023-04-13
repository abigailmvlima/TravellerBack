package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet("/buscar")
public class BuscarUsuarioServlet extends HttpServlet {

	
	public void show(HttpServletRequest request, HttpServletResponse response, String pagina) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
             throws IOException, ServletException {
		
				
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		lista.add(new Usuario(1,"Abigail Lima", "abigail@gmail.com"));
		lista.add(new Usuario(2,"Kaique Bernardo", "kaique@gmail.com"));
		
		
		int id = Integer.parseInt(request.getParameter("id"));

		if (id == 0) {
			this.show(request, response, "erro.jsp");
			return;
		}
		
		Usuario result = null;
		for (Usuario user : lista) {
			if (user.getId() == id) {
				result = user;	
				break;
			}
		}
		
		
		if (result == null) {
			this.show(request, response, "erro.jsp");
			return;
		}
		request.setAttribute("Usuario", result);
		this.show(request, response, "listaUsuario.jsp");
	}

}
