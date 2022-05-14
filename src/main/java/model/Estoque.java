package model;
import java.util.ArrayList;

import view.Interface;

public class Estoque implements Interface {
	public static ArrayList<Produto> produtos_estoque = new ArrayList<Produto>();
	
	@Override
	public void addProduto(Produto prod) {
		produtos_estoque.add(prod);
	}

	@Override
	public void removeProduto(int id) {
		produtos_estoque.remove(id);
	}

	@Override
	public Produto getProduto(int id) {
		return produtos_estoque.get(id);
	}

	@Override
	public ArrayList<Produto> getProdutos() {
		return produtos_estoque;
	}
}
