package Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ReembolsoDAO;
import Models.Fatura;
import Models.Pagamento;
import Models.Reembolso;

public class ReembolsoService {
	
	public static List<Reembolso> getReembolsos() throws SQLException {
		return ReembolsoDAO.getAll();
	}
	
	public static List<Reembolso> getReembolsosByFatura(Fatura f) throws SQLException {
		List<Reembolso> reembolsosFatura = new ArrayList<>();
		
		for (Reembolso reembolso : getReembolsos()) {
			if (reembolso.getFatura().equals(f)) {
				reembolsosFatura.add(reembolso);
			}
		}
		
		return reembolsosFatura;
	}
	
	public static double reembolsar(Pagamento pagamento, double valorTodosPagamentos) throws SQLException {
		Reembolso reembolso = new Reembolso(pagamento, valorTodosPagamentos);
		ReembolsoDAO.save(reembolso);
		return reembolso.getValor();
	}
	
}
