package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import model.Produto;

public class ProdutoDao {
	
	Connection conn = null;
	PreparedStatement pst = null;
	Statement st = null;
	ResultSet rs = null;
	
	
	public void inserirProduto(Produto produto) {
	
		try {
			conn = DB.getConnection();
			
			pst = conn.prepareStatement(
					"INSERT INTO produto "
					+ "(nome, quantidade, preco) "
					+ "VALUES "
					+ "(?, ?, ?) ");
			pst.setString(1, produto.getNome());
			pst.setInt(2, produto.getQuantidade());
			pst.setDouble(3, produto.getPreco());
			
			pst.executeUpdate();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
	        DB.closeStatement(pst);
	        DB.closeConnection();
	    }
	}
	
	public void excluirProduto(int id) {
		try {
			conn = DB.getConnection();
			
			pst = conn.prepareStatement(
					"DELETE FROM produto "
					+ "WHERE "
					+ "id = ? ");
			
			pst.setInt(1, id);
			
			pst.executeUpdate();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
	        DB.closeStatement(pst);
	        DB.closeConnection();
	    }
	}
	
	public void atualizarPrecoProduto(double preco, int id) {
		try {
			conn = DB.getConnection();
			
			pst = conn.prepareStatement(
					"UPDATE produto "
					+ "SET preco = ?"
					+ "WHERE "
					+ "id = ? ");
			
			pst.setDouble(1, preco);
			pst.setInt(2, id);
			
			pst.executeUpdate();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
	        DB.closeStatement(pst);
	        DB.closeConnection();
	    }
	}
	
	public void listarProdutos() {
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM produto");
			
			while (rs.next()) {
				System.out.println(rs.getInt("id") 
						+ ", " 
						+ rs.getString("nome") 
						+ ", " 
						+ rs.getInt("quantidade") 
						+ ", " 
						+ rs.getDouble("preco"));
			}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			 DB.closeResultSet(rs);
		     DB.closeStatement(st);
		     DB.closeConnection();
	    }
	}
}
