package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Utils.Util;

@Entity
public class Fatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idImovel", referencedColumnName = "id", nullable = false)
	private Imovel imovel;
	
	@Column(name = "dataEmissao", nullable = false)
	private Date dataEmissao;
	
	@Column(name = "leituraAnterior")
	private Double leituraAnterior;
	
	@Column(name = "leituraAtual", nullable = false)
	private Double leituraAtual;
	
	@Column(name = "valorCalculado", nullable = false)
	private Double valorCalculado;
	
	@Column(nullable = false)
	private Boolean quitada;
	
	@OneToMany(mappedBy = "fatura", fetch = FetchType.LAZY)
	private List<Pagamento> pagamentos;

	public Fatura() {
		// TODO Auto-generated constructor stub
	}

	public Fatura(Imovel imovel, Double leituraAtual) {
        this.imovel = imovel;
        this.leituraAtual = leituraAtual;
        this.dataEmissao = new Date();
        this.valorCalculado = 10 * leituraAtual;
        this.quitada = false;
    }
	
	public Fatura(Imovel imovel, Double leituraAtual, Double leituraAnterior) {
		this.imovel = imovel;
		this.leituraAtual = leituraAtual;
		this.leituraAnterior = leituraAnterior;
		this.dataEmissao = new Date();
		this.valorCalculado = 10 * leituraAtual;
		this.quitada = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
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

	public Double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(Double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public Boolean isQuitada() {
		return quitada;
	}

	public void setQuitada(Boolean quitada) {
		this.quitada = quitada;
	}
	
	public String getDataEmissaoFormatada() {
        return Util.formatDate(dataEmissao);
    }
	
	public String getValorCalculadoFormatado() {
		return Util.formatCurrency(this.valorCalculado);
	}
	
	public String isQuitadaPorExtenso() {
		return this.quitada ? "Sim" : "Não";
	}
	
	public String getLeituraAtualFormatada() {
		return Util.formatReadingValue(this.leituraAtual);
	}
	
	public String getLeituraAnteriorFormatada() {
		return Util.formatReadingValue(this.leituraAnterior);
	}

    @Override
    public String toString() {
        return imovel.getMatricula() + "\t" + getDataEmissaoFormatada() + "\t" + getLeituraAtualFormatada()
                + "\t\t" + getValorCalculadoFormatado() + "\t" + isQuitadaPorExtenso();
    }

}
