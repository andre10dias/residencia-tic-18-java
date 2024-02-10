package services;

import java.util.List;

import dao.ReembolsoDAO;
import models.Fatura;
import models.Pagamento;
import models.Reembolso;

public class ReembolsoService {
	
	public static List<Reembolso> getReembolsos() {
		return ReembolsoDAO.getAll();
	}
	
	public static List<Reembolso> getReembolsosByFatura(Fatura f) {
		return ReembolsoDAO.getReembolsosByFatura(f);
	}
	
	public static double reembolsar(Pagamento pagamento, double valorTodosPagamentos) {
		Reembolso reembolso = new Reembolso(pagamento, valorTodosPagamentos);
		ReembolsoDAO.save(reembolso);
		return reembolso.getValor();
	}
	
}
