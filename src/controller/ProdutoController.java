package controller;

import java.util.List;

import dao.ProdutoDao;
import model.Produto;

public class ProdutoController {
	
	ProdutoDao dao = new ProdutoDao(); 
	
	 public void inserirProduto(Produto produto) {
	     dao.inserirProduto(produto);
	 }
	 
	 public void excluirProduto(int id) {
		 dao.excluirProduto(id);
	 }
	 
	 public void atualizarPrecoProduto(double preco, int id) {
		 dao.atualizarPrecoProduto(preco, id);
	 }
	 
	 public void listarProduto(){
		 dao.listarProdutos();
	 }
}
