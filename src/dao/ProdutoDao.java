package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import model.Produto;

public class ProdutoDao {
	
	public void inserirProduto(Produto produto) {
	
		String sql = "INSERT INTO produto "
				+ "(nome, quantidade, preco) "
				+ "VALUES "
				+ "(?, ?, ?) ";
		
		try (Connection conn = DB.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql)) {
					
			pst.setString(1, produto.getNome());
			pst.setInt(2, produto.getQuantidade());
			pst.setDouble(3, produto.getPreco());
			
			pst.executeUpdate();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirProduto(int id) {
		
		String sql = "DELETE FROM produto "
				+ "WHERE "
				+ "id = ? ";
				
		try (Connection conn = DB.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql)) {
			
			pst.setInt(1, id);
			
			pst.executeUpdate();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarPrecoProduto(double preco, int id) {
		
		String sql = "UPDATE produto "
				+ "SET preco = ?"
				+ "WHERE "
				+ "id = ? ";
		
		try (Connection conn = DB.getConnection();
			 PreparedStatement pst = conn.prepareStatement(sql)) {
			
			pst.setDouble(1, preco);
			pst.setInt(2, id);
			
			pst.executeUpdate();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listarProdutos() {
		String sql = "SELECT * FROM produto";

	    try (Connection conn = DB.getConnection();
	         PreparedStatement pst = conn.prepareStatement(sql);
	         ResultSet rs = pst.executeQuery()) {

	        while (rs.next()) {
	            System.out.println(rs.getInt("id")
	                    + ", " + rs.getString("nome")
	                    + ", " + rs.getInt("quantidade")
	                    + ", " + rs.getDouble("preco"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
