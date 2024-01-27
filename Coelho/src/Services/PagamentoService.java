package Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Models.Fatura;
import Models.Pagamento;

public class PagamentoService {
	
	private static List<Pagamento> pagamentos;
	
	public static List<Pagamento> getPagamentos() {
		if (pagamentos == null) {
			pagamentos = new ArrayList<>();
		}
		
		return pagamentos;
	}
	
	public static void addPagamento(Pagamento p) {
		if (pagamentos == null) {
			pagamentos = new ArrayList<>();
		}
		
		pagamentos.add(p);
	}
	
	public static List<Pagamento> getPagamentosByFatura(Fatura f) {
		Set<Pagamento> pagamentosFatura = new HashSet<>();
		
		for (Pagamento pagamento : getPagamentos()) {
			if (pagamento.getFatura().equals(f)) {
				pagamentosFatura.add(pagamento);
			}
		}
		
		return new ArrayList<Pagamento>(pagamentosFatura);
	}

}
