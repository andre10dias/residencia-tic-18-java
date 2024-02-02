package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Fatura;
import Models.Pagamento;
import Services.FaturaService;

public class PagamentoDAO {
	
	public static List<Pagamento> getAll() throws SQLException {
		List<Pagamento> pagamentos = new ArrayList<>();
		Connection connection = DAO.getConnection();
		
		try {			
			String query = "SELECT id, valor, data, faturaId FROM Pagamento";
			ResultSet rs = DAO.executeQuery(connection, query, null);
			
			while (rs.next()) {
				Fatura fatura = FaturaService.getFaturaById(rs.getInt("faturaId"));
				double valor = Double.valueOf(rs.getDouble("valor"));
				Date data = rs.getDate("data");
				Integer pagamentoId = rs.getInt("id");
				
				Pagamento p = new Pagamento(pagamentoId, fatura, valor, data);
				pagamentos.add(p);
			}
		} catch (Exception e) {
			System.err.println("Falha ao retornar os dados: " + e);
		} finally {
        	if (connection != null) {				
        		connection.close();
			}
		}
		
		return pagamentos;
	}
	
	public static Pagamento getPagamentoById(Integer id) throws SQLException {
		Pagamento pagamento = null;
		Connection connection = DAO.getConnection();
		
		try {			
			String query = "SELECT id, valor, data, faturaId FROM Pagamento WHERE id = ?";
			List<Object> params = List.of(id);
			ResultSet rs = DAO.executeQuery(connection, query, params);
			
			while (rs.next()) {
				Fatura fatura = FaturaService.getFaturaById(rs.getInt("faturaId"));
				double valor = Double.valueOf(rs.getDouble("valor"));
				Date data = rs.getDate("data");
				Integer pagamentoId = rs.getInt("id");
				
				pagamento = new Pagamento(pagamentoId, fatura, valor, data);
			}
		} catch (Exception e) {
			System.err.println("Falha ao retornar os dados: " + e);
		} finally {
        	if (connection != null) {				
        		connection.close();
			}
		}
		
		return pagamento;
	}
	
	public static Integer getMaxIdPagamento() throws SQLException {
		Connection connection = DAO.getConnection();
		Integer maxId = null;
		
		try {			
			String query = "SELECT MAX(id) AS id FROM Pagamento";
			ResultSet rs = DAO.executeQuery(connection, query, null);

			if (rs.next()) {
	            maxId = rs.getInt("id");
	        }
		} catch (Exception e) {
			System.err.println("Falha ao retornar os dados: " + e);
		} finally {
        	if (connection != null) {				
        		connection.close();
			}
		}
		
		return maxId;
	}
	
	public static Integer save(Pagamento p) throws SQLException {
		Integer rowsAffected = 0;
		Connection connection = DAO.getConnection();
		
		try {
			String query = "INSERT INTO Pagamento (valor, data, faturaId) VALUES (?, ?, ?)";
			List<Object> params = List.of(p.getValor(), p.getData(), p.getFatura().getId());
			rowsAffected = DAO.executeUpdate(connection, query, params);
		} catch (Exception e) {
			System.err.println("Falha ao salvar os dados: " + e);
		} finally {
        	if (connection != null) {				
        		connection.close();
			}
		}
		
		return rowsAffected;
	}
	
	public static Integer update(Pagamento p) throws SQLException {
		Integer rowsAffected = 0;
		Connection connection = DAO.getConnection();
		
		try {			
			String query = "UPDATE Pagamento SET valor = ?, data = ?, faturaId = ? WHERE id = ?";
			List<Object> params = List.of(p.getValor(), p.getData(), p.getFatura().getId());
			rowsAffected = DAO.executeUpdate(connection, query, params);
		} catch (Exception e) {
			System.err.println("Falha ao salvar os dados: " + e);
		} finally {
        	if (connection != null) {				
        		connection.close();
			}
		}
		
		return rowsAffected;
	}

}
