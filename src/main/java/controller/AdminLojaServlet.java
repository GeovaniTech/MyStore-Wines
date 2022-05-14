package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estoque;
import model.Produto;

@WebServlet("/AdminLojaServlet")
public class AdminLojaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("name");
		float preco = Float.parseFloat(request.getParameter("preco"));
		String url_imagem = request.getParameter("img");
		
		Produto prod = new Produto();
	
		prod.setId(Estoque.produtos_estoque.size());
		prod.setNome(nome);
		prod.setPreco(preco);
		prod.setUrl_imagem(url_imagem);
		
		Estoque estoque = new Estoque();
		estoque.addProduto(prod);
		
		response.sendRedirect("/loja/pages/produtos.jsp");
	}
}
