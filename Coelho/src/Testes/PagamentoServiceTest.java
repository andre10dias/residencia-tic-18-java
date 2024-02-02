package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import Models.Fatura;
import Models.Imovel;
import Models.Pagamento;
import Models.Reembolso;
import Services.PagamentoService;
import Services.ReembolsoService;

class PagamentoServiceTest {

	@Test
	void registraPagamentoTest() {
		/**
		 * Caso 1: Ao se incluir um pagamento no sistema, 
		 * é necessário se registrar o valor e a data 
		 * (considere a data atual do sistema). 
		 * */
		Imovel imovel = new Imovel("12345", "Rua XPO");
		Fatura fatura = new Fatura(imovel, 100);
		Pagamento pagamento = new Pagamento(fatura, 100);
		assertNotNull(pagamento.getValor());
		assertNotNull(pagamento.getData());
//		assertEquals(new Date(), pagamento.getData());
		
		/**
		 * Caso 2: Pode ocorre, porém, de o cliente não 
		 * pagar integralmente a fatura de uma única vez; 
		 * neste caso, mais de um pagamento pode ser 
		 * registrado para uma mesma fatura, até que seu 
		 * valor esteja integralmente cumprido. 
		 * */
		fatura = new Fatura(imovel, 30);
		
		Pagamento pag1 = new Pagamento(fatura, 50);
		PagamentoService.registraPagamento(fatura, pag1.getValor());
		
		Pagamento pag2 = new Pagamento(fatura, 100);
		PagamentoService.registraPagamento(fatura, pag2.getValor());
		
		Pagamento pag3 = new Pagamento(fatura, 150);
		PagamentoService.registraPagamento(fatura, pag3.getValor());
		
		double pagamentos = pag1.getValor() + pag2.getValor() + pag3.getValor();
		assertEquals(fatura.getValorCalculado(), pagamentos);
		
		/**
		 * Caso 3: Quando o a soma dos pagamentos 
		 * associados a uma fatura completar seu valor, 
		 * a fatura é marcada como "Quitado" 
		 * (o flag vai para True). 
		 * */
		assertTrue(fatura.isQuitada());
		
		/**
		 * Caso 4: O sistema não aceita pagamento de 
		 * faturas já quitadas.
		 * */
		try {
			Pagamento pag4 = new Pagamento(fatura, 30);
			PagamentoService.registraPagamento(fatura, pag4.getValor());
		}catch(Exception e) {
			assertEquals("Não é permitido o pagamento de faturas quitadas.", e.getMessage());
		}
		
		/**
		 * Caso 5: Mas pode acontecer de um pagamento 
		 * superar, sozinho ou com a soma de outros, 
		 * o valor da fatura. Neste caso o sistema gera 
		 * um Reembolso, com o valor pago a mais, e 
		 * registrado na data atual do sistema, no 
		 * momento do pagamento.
		 * */
		Fatura fatura1 = new Fatura(imovel, 10);
		Pagamento pagamento1 = new Pagamento(fatura1, 120);
		PagamentoService.registraPagamento(fatura1, pagamento1.getValor());
		List<Reembolso> reembolsos = new ArrayList<>();
		try {
			reembolsos = ReembolsoService.getReembolsos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, reembolsos.size());
		
		double valorFatura = fatura1.getValorCalculado();
		double valorPagamento = pagamento1.getValor();
		double valorPagoAmais = valorPagamento - valorFatura;
		assertEquals(valorPagoAmais, reembolsos.get(0).getValor());
		
		Date dataAtual = new Date();
		//assertEquals(dataAtual, reembolsos.get(0).getData());
		
		Fatura fatura2 = new Fatura(imovel, 100);
		
		Pagamento pagt1 = new Pagamento(fatura2, 520);
		PagamentoService.registraPagamento(fatura2, pagt1.getValor());
		
		Pagamento pagt2 = new Pagamento(fatura2, 280);
		PagamentoService.registraPagamento(fatura2, pagt2.getValor());
		
		Pagamento pagt3 = new Pagamento(fatura2, 150);
		PagamentoService.registraPagamento(fatura2, pagt3.getValor());
		
		Pagamento pagt4 = new Pagamento(fatura2, 150);
		PagamentoService.registraPagamento(fatura2, pagt4.getValor());
		
		assertEquals(2, reembolsos.size());
		
		valorFatura = fatura2.getValorCalculado();
		valorPagamento = pagt1.getValor() + pagt2.getValor() + pagt3.getValor() + pagt4.getValor();
		valorPagoAmais = valorPagamento - valorFatura;
		assertEquals(valorPagoAmais, reembolsos.get(1).getValor());
		
	}

}
