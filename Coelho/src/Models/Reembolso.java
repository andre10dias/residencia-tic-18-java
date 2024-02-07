package Models;

import java.util.Date;

import Utils.Util;

public class Reembolso {
	
	private Integer id;
	private Pagamento pagamento;
	private Double valor;
	private Date data;

	public Reembolso() {
		// TODO Auto-generated constructor stub
	}

	public Reembolso(Pagamento pagamento, Double valorTodosPagamentos) {
		this.pagamento = pagamento;
		this.valor = valorTodosPagamentos - getFatura().getValorCalculado();
		this.data = new Date();
	}
	
	public Reembolso(Pagamento pagamento, Double valor, Date data) {
		this.pagamento = pagamento;
		this.valor = valor;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Fatura getFatura() {
		return this.pagamento.getFatura();
	}
	
	public String getDataFormatada() {
		return Util.formatDate(data);
	}
	
	@Override
	public String toString() {
		return getDataFormatada() + "\t" + this.getFatura().getValorCalculado() 
				+ "\t\t" + (this.getFatura().getValorCalculado()+this.valor) + "\t" + this.valor;
	}
}
