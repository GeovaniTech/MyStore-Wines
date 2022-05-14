package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estoque;

@WebServlet("/RemoverProduto")
public class RemoverProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Estoque.produtos_estoque.remove(id);
		
		for (int i = 0; i < Estoque.produtos_estoque.size(); i++) {
			if (Estoque.produtos_estoque.get(i).getId() > id) {
				Estoque.produtos_estoque.get(i).setId(Estoque.produtos_estoque.get(i).getId() - 1);
			}
		}
		response.sendRedirect("/loja/pages/produtos.jsp");
	}
}
