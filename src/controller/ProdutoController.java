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
	 
	 public void AtualizarPrecoProduto(double preco, int id) {
		 dao.AtualizarPrecoProduto(preco, id);
	 }
	 
	 public void listarProduto(){
		 dao.listarProdutos();
	 }
	
	public void menuOpcao() {
		System.out.println("========================================");			
		System.out.println("                   Menu                 ");
		System.out.println("========================================");
		System.out.println("Digite 0 para sair do programa");
		System.out.println("Digite 1 para inserir os produtos");
		System.out.println("Digite 2 para listar os produtos");
		System.out.println("Digite 3 para alterar o preço do produto");
		System.out.println("Digite 4 para deletar o produto ");
		System.out.println("========================================");
		
	}
	
	public void listarProdutos() {
		System.out.println("========================================");		
		System.out.println("            Lista dos Produtos          ");
		System.out.println("========================================");		
	}
}
