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
		lista.add(new Usuario(1,"Abigail Lima", "feminino" , "abigail@gmail.com", "11/03/1986", "Lima"));
		lista.add(new Usuario(2,"Kaique Bernanrdo", "masculino", "kaique@gmail.com", "02/09/1994", "Bernardo"));
		
		
		if (request.getParameter("id")== null) {
			this.show(request, response, "/erro.jsp");
			return;			
		}
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id == 0) {
			this.show(request, response, "/erro.jsp");
			return;
		}
		
		ArrayList<Usuario> resultado = new ArrayList<Usuario>();
		
		for (Usuario user : lista) {
			if (user.getId() == id) {
				resultado.add(user);	
				break;
			}
		}
		
		
		
		request.setAttribute("listaUsuario", resultado);
		this.show(request, response, "/listaUsuario.jsp");
	}

}
