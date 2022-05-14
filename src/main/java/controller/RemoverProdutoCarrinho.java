package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrinho;
import model.Usuarios;

@WebServlet("/RemoverProdutoCarrinho")
public class RemoverProdutoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuarios user = (Usuarios) request.getSession().getAttribute("user");
		
		Carrinho carrinho = user.getCarrinho();
		carrinho.getProdutos().remove(id);
		
		response.sendRedirect("/loja/pages/carrinho.jsp");
	}

}
