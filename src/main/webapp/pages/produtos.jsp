<%@page import="model.Estoque"%>
<%@page import="model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../styles/produtos.css">
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
			class="img">Home</a> <a href="produtos.jsp" class="active"><img
			src="../imagens/shop.png" class="img" alt="" id="tst">Produtos</a>
		<a href="carrinho.jsp"><img src="../imagens/shopping-cart.png"
			class="img" alt="">Carrinho</a>
	</nav>

	<header>
		<h1>Produtos</h1>
	</header>

	<main>
		<form action="/loja/AdminLojaServlet" method="POST" class="form-prod">
				<input type="text" name="name" id="1" placeholder="Nome"> <input
				type="number" name="preco" id="2" placeholder="Preço"> <input
				type="text" name="img" id="3" placeholder="URL imagem"> <input
				type="submit" name="button" id="4" value="Cadastrar">
		</form>
		<table>
			<thead>
				<tr>
					<th>Id Prod</th>
					<th>Nome</th>
					<th>Preço</th>
					<th>Remover</th>
				</tr>
			</thead>
		
			<tbody>
				<%
				for (int i = 0; i < Estoque.produtos_estoque.size(); i++) {
				%>
				<tr>
					<td><%=Estoque.produtos_estoque.get(i).getId()%></td>
					<td><%=Estoque.produtos_estoque.get(i).getNome()%></td>
					<td>R$ <%=Estoque.produtos_estoque.get(i).getPreco()%></td>
					<td><a class="remover-prod" href="/loja/RemoverProduto?id=<%=Estoque.produtos_estoque.get(i).getId()%>">
							<img src="../imagens/trash.png" alt="" id="img-trash">
						</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>

	<div class="footer-pai">
		<footer>
			<p>Copyright &copy; MyStore, 2022</p>
		</footer>
	</div>


</body>
</html>