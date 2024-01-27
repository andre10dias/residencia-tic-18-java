package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Models.Fatura;
import Models.Imovel;

class FaturaServiceTest {

	@Test
	void registraLeituraTest() {
		/**
		 * Caso 1: Quando se faz a leitura de consumo de 
		 * um imóvel, procede-se à geração de uma fatura. 
		 * Para isto é necessário que o imóvel seja 
		 * identificado (matrícula) e o valor da leitura 
		 * atual seja apresentado ao sistema. 
		 * */
		Imovel imovel = new Imovel("12345", "Rua XPO");
		Fatura fatura = new Fatura(imovel, 100);
		assertNotNull(imovel.getMatricula());
		assertNotNull(fatura.getLeituraAtual());
		
		/**
		 * Caso 2: Neste momento, o valor que estava como 
		 * "Última Leitura" no imóvel é passado para 
		 * "Penúltima Leitura". E o valor da leitura atual 
		 * é registrado como "Última Leitura". 
		 * */
		Fatura faturaAnterior = fatura;
		Fatura faturaAtual = new Fatura(imovel, 50, faturaAnterior.getLeituraAtual());
		assertEquals(faturaAnterior.getLeituraAtual(), faturaAtual.getLeituraAnterior());
		assertEquals(faturaAtual.getLeituraAtual(), faturaAtual.getLeituraAtual());
		
		/**
		 * Caso 3: cria-se uma instãncia do tipo fatura,
		 * onde se registra os dados das últimas duas 
		 * faturas, a data de emissão da fatura o valor 
		 * calculado e um flag, inicialmente setado para 
		 * false.
		 * */
		assertNotNull(faturaAtual.getLeituraAtual());
		assertNotNull(faturaAtual.getLeituraAnterior());
		assertNotNull(faturaAtual.getDataEmissao());
		assertNotNull(faturaAtual.getValorCalculado());
		assertNotNull(faturaAtual.getValorCalculado());
		assertFalse(faturaAtual.isQuitada());
		
		/**
		 * Caso 4: a data de emissão da fatura (que é a 
		 * data atual do sistema)
		 * */
		assertEquals(new Date(), faturaAtual.getDataEmissao());
		
		/**
		 * Caso 5: admita que é calculado ao custo de 10 reais 
		 * por KWh 
		 * */
		double calculo = faturaAtual.getLeituraAtual() * 10;
		assertEquals(calculo, faturaAtual.getValorCalculado());
	}

}
