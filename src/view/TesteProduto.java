package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ProdutoController;
import dao.ProdutoDao;
import model.Produto;

public class TesteProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		
		ProdutoController produtoController = new ProdutoController();
		List<Produto> produtoArry = new ArrayList<>();
		int resp;
		char respP;
		
		System.out.println("");			
	
		Integer posicao;
		
		do {
		
			System.out.println("========================================");			
			System.out.println("                   Menu                 ");
			System.out.println("========================================");
			System.out.println("Digite 0 para sair do programa");
			System.out.println("Digite 1 para inserir os produtos");
			System.out.println("Digite 2 para listar os produtos");
			System.out.println("Digite 3 para alterar o preço do produto");
			System.out.println("Digite 4 para deletar o produto ");
			System.out.println("========================================");
			resp = entrada.nextInt();
			
			switch(resp) {
			
				case 1:
					do {
						
						entrada.nextLine();
						System.out.print("Digite o nome do produto: ");
						String nomeP = entrada.nextLine();
						System.out.print("Digite o quantidade do produto: ");
						int quantidadeP = entrada.nextInt();
						System.out.print("Digite o preço do produto: ");
						double precoP = entrada.nextDouble();
						
						Produto produtocc = new Produto(nomeP,quantidadeP,precoP);
						produtoArry.add(produtocc);
						produtoController.inserirProduto(produtocc);
						
						
						System.out.print("Digite 's' para continuar gravando produtos e 'n' para sair");
						respP = entrada.next().charAt(0);
						entrada.nextLine();
						
					}while(respP == 's');
				break;
				case 2:
					System.out.println("========================================");		
					System.out.println("            Lista dos Produtos          ");
					System.out.println("========================================");	
					produtoController.listarProduto();
				break;
				case 3:
					System.out.print("Digite o ID do produto que você deseja alterar o preço: ");
					int codigoProdutoAlterar = entrada.nextInt();
					System.out.println("Digite o novo valor");
					double novoPreco = entrada.nextDouble();
					produtoController.atualizarPrecoProduto(novoPreco, codigoProdutoAlterar);
				break;
				case 4:
					System.out.print("Digite o codigo  do produto que você deseja excluir: ");
					int idProduto = entrada.nextInt();
					produtoController.excluirProduto(idProduto);
			}
		}while(resp != 0);
		
		entrada.close();
	}
}
