package controller;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuarios;

@WebFilter("/pages/carrinho.jsp")

public class FilterCarrinho extends HttpFilter implements javax.servlet.Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req; // Casting - Conversão de tipos de request
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession(true);
		
		Usuarios user = (Usuarios) session.getAttribute("user");
		try {
			if (!user.getNome().isEmpty()) {
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			response.setStatus(401);
			response.sendRedirect("/loja/pages/login.html");
		}
	}
}
