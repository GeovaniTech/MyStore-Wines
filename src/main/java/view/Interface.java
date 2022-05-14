package view;

import java.util.ArrayList;

import model.Produto;

public abstract interface Interface {
	public abstract void addProduto(Produto prod);
	public abstract void removeProduto(int id);
	public abstract Produto getProduto(int id);
	public abstract ArrayList<Produto> getProdutos();
}
