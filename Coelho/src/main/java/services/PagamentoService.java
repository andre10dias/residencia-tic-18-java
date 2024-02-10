package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.FaturaDAO;
import dao.PagamentoDAO;
import models.Fatura;
import models.Pagamento;

public class PagamentoService {
	
	public static List<Pagamento> getPagamentos() {
		return PagamentoDAO.getAll();
	}
	
	public static double registraPagamento(Fatura faturaSelecionada, double valorPagamento) {
		double valorReembolso = 0;
		
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
				Fatura fatura = pagamento.getFatura();
				fatura.setQuitada(true);
				
				FaturaDAO.update(fatura);
				PagamentoDAO.save(pagamento);
			}
			else if ((valorPagamentosAnteriores + valorPagamento) > pagamento.getFatura().getValorCalculado()) {
				Fatura fatura = pagamento.getFatura();
				fatura.setQuitada(true);
				
				PagamentoDAO.save(pagamento);
				FaturaDAO.update(fatura);
				
				if (pagamento.getId() != null) {	
					valorReembolso = ReembolsoService.reembolsar(pagamento, (valorPagamento + valorPagamentosAnteriores));
				}
			}
			else {
				PagamentoDAO.save(pagamento);
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return valorReembolso;
	}
	
	public static List<Pagamento> getPagamentosByFatura(Fatura f) {
		return PagamentoDAO.getPagamentosByFatura(f);
	}

}
