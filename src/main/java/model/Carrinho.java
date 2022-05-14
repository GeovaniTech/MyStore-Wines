package model;

import java.util.ArrayList;
import view.Interface;

public class Carrinho implements Interface {
	public ArrayList<Produto> produtos_carrinho = new ArrayList<Produto>();
	
	@Override
	public void addProduto(Produto prod) {
		produtos_carrinho.add(prod);
	}

	@Override
	public void removeProduto(int id) {
		produtos_carrinho.remove(id);
	}

	@Override
	public Produto getProduto(int id) {
		return produtos_carrinho.get(id);
	}

	@Override
	public ArrayList<Produto> getProdutos() {
		return produtos_carrinho;
	}
}
