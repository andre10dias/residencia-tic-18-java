package Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Controller.ReembolsoController;
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
	
	public static void registraPagamento(Fatura faturaSelecionada, double valorPagamento) {
		try {
			if (faturaSelecionada.isQuitada()) {
				throw new Exception("Não é permitido o pagamento de faturas quitadas.");
			}
			
			Pagamento pagamento = new Pagamento(faturaSelecionada, valorPagamento);
			List<Pagamento> pagamentosAnteriores = PagamentoService.getPagamentosByFatura(faturaSelecionada);
			
			double valorPagamentosAnteriores = 0;
			for (Pagamento p : pagamentosAnteriores) {
				valorPagamentosAnteriores += p.getValor();
			}
			
			if ((valorPagamentosAnteriores + valorPagamento) == pagamento.getFatura().getValorCalculado()) {
				pagamento.getFatura().setQuitada(true);
			}
			else if ((valorPagamentosAnteriores + valorPagamento) > pagamento.getFatura().getValorCalculado()) {
				pagamento.getFatura().setQuitada(true);
				ReembolsoController.realizarReembolso(pagamento, (valorPagamento + valorPagamentosAnteriores));
			}
			
			PagamentoService.addPagamento(pagamento);
		} catch (Exception e) {
			e.getMessage();
		}
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
