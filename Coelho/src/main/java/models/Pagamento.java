package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Utils.Util;

@Entity
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFatura", referencedColumnName = "id", nullable = false)
	private Fatura fatura;
	
	@Column(nullable = false)
	private Double valor;
	
	@Column(nullable = false)
	private Date data;

	public Pagamento() {
		// TODO Auto-generated constructor stub
	}
	
	public Pagamento(Fatura fatura, Double valor) {
        this.fatura = fatura;
        this.valor = valor;
        this.data = new Date();
    }
	
	public Pagamento(Integer id, Fatura fatura, Double valor, Date data) {
        this.fatura = fatura;
        this.valor = valor;
        this.data = data;
        this.id = id;
    }
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
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
	
	public String getDataFormatada() {
        return Util.formatDate(this.data);
    }
    @Override
    public String toString() {
        return fatura.getImovel().getMatricula() + "\t" + getDataFormatada() 
        + "\t" + fatura.getValorCalculado() + "\t" + this.valor 
        + "\t" + fatura.isQuitadaPorExtenso();
    }
}
