<%@page import="model.Estoque"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styles/home.css">
<link rel="stylesheet" href="styles/menu.css">
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
		<a href="home.jsp" class="active"><img src="imagens/home.png"
			alt="img casa" class="img">Home</a> <a href="pages/produtos.jsp"><img
			src="imagens/shop.png" class="img" alt="" id="tst">Produtos</a>
		<a href="pages/carrinho.jsp"><img src="imagens/shopping-cart.png"
			class="img" alt="">Carrinho</a>
	</nav>

	<header>
		<h1>Wines</h1>
	</header>

	<main>
		<div class="pai">			
			<%
			for (int i = 0; i < Estoque.produtos_estoque.size(); i++) {
			%>
			<div class="card">
				<form action="/loja/ComprasServlet" method="POST">
					<img src=<%=Estoque.produtos_estoque.get(i).getUrl_imagem()%>
						class="img-prod" alt="imagem de vinho">
					<h1><%=Estoque.produtos_estoque.get(i).getNome()%></h1>
					<h2>
						R$
						<%=Estoque.produtos_estoque.get(i).getPreco()%></h2>
					<input type="number" style="visibility: hidden; width: 0px; heigth: 0px;" name="id" value=<%=Estoque.produtos_estoque.get(i).getId()%>></input>
					<input type="submit" class="add-carrinho" value="Adicionar ao Carrinho"></input>
				</form>
			</div>
			<%	
			}
			%>
		</div>
	</main>

	<div class="footer-pai">
		<footer>
			<p>Copyright &copy; MyStore, 2022</p>
		</footer>
	</div>

</body>
</html>