package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuarios;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getSession().invalidate();
		
		String nome = request.getParameter("user");
		String senha = request.getParameter("password");
		boolean correta = false;
		
		if (Usuarios.users.size() > 0) {
			for (int i = 0; i < Usuarios.users.size(); i++) {
				if (Usuarios.users.get(i).getNome().equals(nome) && Usuarios.users.get(i).getSenha().equals(senha)) {
					correta = true;
					HttpSession session = request.getSession(true);
					session.setAttribute("user", Usuarios.users.get(i));
					response.sendRedirect("/loja/home.jsp");
					break;
				}
			}
		}
		if (correta == false) {
			response.sendRedirect("/loja/pages/login.html");
		}
	}
}
