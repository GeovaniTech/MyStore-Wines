package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrinho;
import model.Estoque;
import model.Usuarios;

@WebServlet("/ComprasServlet")
public class ComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		
		Usuarios user = (Usuarios) session.getAttribute("user");
		
		try {
			if (!user.getNome().isEmpty()) {
				Carrinho carrinho = user.getCarrinho();
				for (int i = 0; i < Estoque.produtos_estoque.size(); i++) {
					if (Estoque.produtos_estoque.get(i).getId() == id) {
						if (carrinho == null) {
							carrinho = new Carrinho();
						}
						carrinho.getProdutos().add(Estoque.produtos_estoque.get(i));
						user.setCarrinho(carrinho);	
						break;
					}
				}
			response.sendRedirect("/loja");
			}
		} catch (Exception e) {
			response.sendRedirect("/loja/pages/login.html");
		}
		

		

		

	}
}

