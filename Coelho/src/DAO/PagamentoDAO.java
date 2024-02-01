package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Fatura;
import Models.Pagamento;
import Services.FaturaService;

public class PagamentoDAO {
	
	public static List<Pagamento> getAll() {
		List<Pagamento> pagamentos = new ArrayList<>();
		
		try {			
			String query = "SELECT id, valor, data, faturaId FROM Pagamento";
			ResultSet rs = DAO.executeQuery(query, null);
			
			while (rs.next()) {
				Fatura fatura = FaturaService.getFaturaById(rs.getInt("faturaId"));
				double valor = Double.valueOf(rs.getDouble("valor"));
				Date data = rs.getDate("data");
				
				Pagamento p = new Pagamento(fatura, valor, data);
				pagamentos.add(p);
			}
		} catch (Exception e) {
			System.err.println("Falha ao retornar os dados: " + e);
		}
		
		return pagamentos;
	}
	
	public static Pagamento getPagamentoById(Integer id) {
		Pagamento pagamento = null;
		
		try {			
			String query = "SELECT id, valor, data, faturaId FROM Pagamento WHERE id = ?";
			List<Object> params = List.of(id);
			ResultSet rs = DAO.executeQuery(query, params);
			
			while (rs.next()) {
				Fatura fatura = FaturaService.getFaturaById(rs.getInt("faturaId"));
				double valor = Double.valueOf(rs.getDouble("valor"));
				Date data = rs.getDate("data");
				
				pagamento = new Pagamento(fatura, valor, data);
			}
		} catch (Exception e) {
			System.err.println("Falha ao retornar os dados: " + e);
		}
		
		return pagamento;
	}
	
	public static Integer save(Pagamento p) {
		Integer rowsAffected = 0;
		
		try {
			String query = "INSERT INTO Pagamento (valor, data, faturaId) VALUES (?, ?, ?)";
			List<Object> params = List.of(p.getValor(), p.getData(), p.getFatura().getId());
			rowsAffected = DAO.executeUpdate(query, params);
		} catch (Exception e) {
			System.err.println("Falha ao salvar os dados: " + e);
		}
		
		return rowsAffected;
	}
	
	public static Integer update(Pagamento p) {
		Integer rowsAffected = 0;
		
		try {			
			String query = "UPDATE Pagamento SET valor = ?, data = ?, faturaId = ? WHERE id = ?";
			List<Object> params = List.of(p.getValor(), p.getData(), p.getFatura().getId());
			rowsAffected = DAO.executeUpdate(query, params);
		} catch (Exception e) {
			System.err.println("Falha ao salvar os dados: " + e);
		}
		
		return rowsAffected;
	}

}
