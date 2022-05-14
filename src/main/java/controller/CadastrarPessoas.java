package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuarios;

@WebServlet("/CadastrarPessoas")
public class CadastrarPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome_completo");
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		String data = request.getParameter("date");
		
		Usuarios user = new Usuarios();
		
		user.setNome(nome);
		user.setEmail(email);
		user.setData_nascimento(data);
		user.setSenha(senha);
		
		Usuarios.users.add(user);
		response.sendRedirect("/loja/pages/login.html");
	}
}
