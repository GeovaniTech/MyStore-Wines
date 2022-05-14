<%@page import="model.Carrinho"%>
<%@page import="model.Usuarios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../styles/carrinho.css">
<link rel="stylesheet" href="../styles/tabela.css">
<link rel="stylesheet" href="../styles/menu.css">
<title>MyStore</title>

</head>
<body>
	<nav id="menu">
		<div class="MyStore">
			<div>
				<h1 id="nome_menu">My</h1>
			</div>
			<div>
				<h1 id="nome_store">Store</h1>
			</div>
		</div>
		<a href="../home.jsp"><img src="../imagens/home.png" alt="img casa"
			class="img">Home</a> <a href="produtos.jsp"><img
			src="../imagens/shop.png" class="img" alt="" id="tst">Produtos</a>
		<a href="carrinho.jsp" class="active"><img
			src="../imagens/shopping-cart.png" class="img" alt="">Carrinho</a>
	</nav>
	<header>
		<h1>Carrinho</h1>
	</header>
	<main>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Preço</th>
					<th>Remover</th>
				</tr>
			</thead>
			<tbody>
				<%
				HttpSession sessao = request.getSession();
				Usuarios user = (Usuarios) sessao.getAttribute("user");	
				
				if (user.getCarrinho() != null) {
					if (user.getCarrinho().getProdutos().size() > 0) {
						
						Carrinho carrinho = user.getCarrinho();
						
						for (int i = 0; i < carrinho.getProdutos().size(); i++) {
						%>
						<tr>
							<td><%=user.getCarrinho().getProdutos().get(i).getNome()%></td>
							<td>R$ <%=user.getCarrinho().getProdutos().get(i).getPreco()%></td>
							<td><a class="remover-prod" href="/loja/RemoverProdutoCarrinho?id=<%=i%>"><img src="../imagens/trash.png" id="img-trash"></img></a>
							</td>
						</tr>
						<%	
						}
					} else {
						response.sendRedirect("/loja/pages/carrinho-empty.html");
					}
				} else {
					response.sendRedirect("/loja/pages/carrinho-empty.html");
				}
				
				%>
			</tbody>
		</table>
		
		<a href="/loja/EncerrarCompra" class="btn-encerrar">Encerrar Compra</a>
	</main>

	<footer class="footer-pai">
		<p>Copyright &copy; MyStore, 2022</p>
	</footer>
</body>
</html>