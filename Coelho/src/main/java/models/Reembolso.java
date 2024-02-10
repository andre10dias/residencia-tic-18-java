package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import Utils.Util;

@Entity
public class Reembolso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPagamento", referencedColumnName = "id", nullable = false)
	private Pagamento pagamento;
	
	@Column(nullable = false)
	private Double valor;
	
	@Column(nullable = false)
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
