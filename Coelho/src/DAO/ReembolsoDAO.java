package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Pagamento;
import Models.Reembolso;

public class ReembolsoDAO {
	
	public static List<Reembolso> getAll() {
		List<Reembolso> reembolsos = new ArrayList<>();
		
		try {			
			String query = "SELECT id, valor, data, pagamentoId FROM Reembolso";
			ResultSet rs = DAO.executeQuery(query, null);
			
			while (rs.next()) {
				Pagamento pagamento = PagamentoDAO.getPagamentoById(rs.getInt("pagamentoId"));
				double valor = Double.valueOf(rs.getDouble("valor"));
				Date data = rs.getDate("data");
				
				Reembolso r = new Reembolso(pagamento, valor, data);
				reembolsos.add(r);
			}
		} catch (Exception e) {
			System.err.println("Falha ao retornar os dados: " + e);
		}
		
		return reembolsos;
	}
	
	public static Integer save(Reembolso r) {
		Integer rowsAffected = 0;
		
		try {
			String query = "INSERT INTO Reembolso (valor, data, pagamentoId) VALUES (?, ?, ?)";
			List<Object> params = List.of(r.getValor(), r.getData(), r.getPagamento().getId());
			rowsAffected = DAO.executeUpdate(query, params);
		} catch (Exception e) {
			System.err.println("Falha ao salvar os dados: " + e);
		}
		
		return rowsAffected;
	}
	
	public static Integer update(Reembolso r) {
		Integer rowsAffected = 0;
		
		try {			
			String query = "UPDATE Reembolso SET valor = ?, data = ?, pagamentoId = ? WHERE id = ?";
			List<Object> params = List.of(r.getValor(), r.getData(), r.getPagamento().getId());
			rowsAffected = DAO.executeUpdate(query, params);
		} catch (Exception e) {
			System.err.println("Falha ao salvar os dados: " + e);
		}
		
		return rowsAffected;
	}
	
	public static Integer delete(Reembolso r) {
		Integer rowsAffected = 0;
		
		try {			
			String query = "DELETE FROM Reembolso WHERE id = ?";
			List<Object> params = List.of(r.getId());
			rowsAffected = DAO.executeUpdate(query, params);
		} catch (Exception e) {
			System.err.println("Falha ao salvar os dados: " + e);
		}
		
		return rowsAffected;
	}

}
