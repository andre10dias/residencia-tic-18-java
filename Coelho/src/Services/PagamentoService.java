package Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DAO.PagamentoDAO;
import Models.Fatura;
import Models.Pagamento;

public class PagamentoService {
	
	public static List<Pagamento> getPagamentos() throws SQLException {
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
				pagamento.getFatura().setQuitada(true);
				PagamentoDAO.save(pagamento);
			}
			else if ((valorPagamentosAnteriores + valorPagamento) > pagamento.getFatura().getValorCalculado()) {
				pagamento.getFatura().setQuitada(true);
				Integer rowsAffected = PagamentoDAO.save(pagamento);
				
				if (rowsAffected > 0) {	
					Integer maxId = PagamentoDAO.getMaxIdPagamento();
					pagamento.setId(maxId);// = PagamentoDAO.getPagamentoById(maxId);
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
	
	public static List<Pagamento> getPagamentosByFatura(Fatura f) throws SQLException {
		Set<Pagamento> pagamentosFatura = new HashSet<>();
		
		for (Pagamento pagamento : getPagamentos()) {
			if (pagamento.getFatura().equals(f)) {
				pagamentosFatura.add(pagamento);
			}
		}
		
		return new ArrayList<Pagamento>(pagamentosFatura);
	}

}
