package models;

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
public class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
	private Cliente cliente;
	
	@Column(unique = true, nullable = false)
	private String matricula;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(name = "leituraAnterior")
	private Double leituraAnterior;
	
	@Column(name = "leituraAtual")
	private Double leituraAtual;

	public Imovel() {
		// TODO Auto-generated constructor stub
	}

	public Imovel(String matricula, String endereco, Cliente cliente) {
		this.matricula = matricula;
		this.endereco = endereco;
		this.cliente = cliente;
	}
	
	public Integer getId() {
		return this.id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getLeituraAnterior() {
		return leituraAnterior;
	}

	public void setLeituraAnterior(Double leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public Double getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(Double leituraAtual) {
		this.leituraAtual = leituraAtual;
	}
	
	public String getLeituraAtualFormatada() {
		return Util.formatReadingValue(this.leituraAtual);
	}
	
	public String getLeituraAnteriorFormatada() {
		return Util.formatReadingValue(this.leituraAnterior);
	}
	
	@Override
	public String toString() {
		return this.matricula + "\t" + this.endereco;
	}

}
