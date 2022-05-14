package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuarios;

@WebServlet("/EncerrarCompra")
public class EncerrarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Usuarios user = (Usuarios) session.getAttribute("user");
		
		user.getCarrinho().getProdutos().clear();
		response.sendRedirect("/loja");
	}

}
