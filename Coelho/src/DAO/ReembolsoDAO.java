package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Pagamento;
import Models.Reembolso;

public class ReembolsoDAO {
	
	public static List<Reembolso> getAll() throws SQLException {
		List<Reembolso> reembolsos = new ArrayList<>();
		Connection connection = DAO.getConnection();
		
		try {			
			String query = "SELECT id, valor, data, pagamentoId FROM Reembolso";
			ResultSet rs = DAO.executeQuery(connection, query, null);
			
			while (rs.next()) {
				Pagamento pagamento = PagamentoDAO.getPagamentoById(rs.getInt("id"));
				double valor = Double.valueOf(rs.getDouble("valor"));
				Date data = rs.getDate("data");
				
				Reembolso r = new Reembolso(pagamento, valor, data);
				reembolsos.add(r);
			}
		} catch (Exception e) {
			System.err.println("Falha ao retornar os dados: " + e);
		} finally {
        	if (connection != null) {				
        		connection.close();
			}
		}
		
		return reembolsos;
	}
	
	public static Integer save(Reembolso r) throws SQLException {
		Integer rowsAffected = 0;
		Connection connection = DAO.getConnection();
		
		try {
			String query = "INSERT INTO Reembolso (valor, data, pagamentoId) VALUES (?, ?, ?)";
			List<Object> params = List.of(r.getValor(), r.getData(), r.getPagamento().getId());
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
	
	public static Integer update(Reembolso r) throws SQLException {
		Integer rowsAffected = 0;
		Connection connection = DAO.getConnection();
		
		try {			
			String query = "UPDATE Reembolso SET valor = ?, data = ?, pagamentoId = ? WHERE id = ?";
			List<Object> params = List.of(r.getValor(), r.getData(), r.getPagamento().getId());
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
	
	public static Integer delete(Reembolso r) throws SQLException {
		Integer rowsAffected = 0;
		Connection connection = DAO.getConnection();
		
		try {			
			String query = "DELETE FROM Reembolso WHERE id = ?";
			List<Object> params = List.of(r.getId());
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
