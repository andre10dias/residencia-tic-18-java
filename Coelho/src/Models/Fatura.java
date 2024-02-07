package Models;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idImovel", referencedColumnName = "id", nullable = false)
	private Imovel imovel;
	
	@Column(name = "dataEmissao", nullable = false)
	private Date dataEmissao;
	
	@Column(name = "leituraAnterior", nullable = false)
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
	
	public String isQuitadaPorExtenso() {
		return this.quitada ? "Sim" : "Não";
	}

    @Override
    public String toString() {
        return this.id + "\t" + imovel.getMatricula() + "\t" + getDataEmissaoFormatada() + "\t" + this.leituraAtual
                + "\t\t" + this.valorCalculado + "\t" + isQuitadaPorExtenso();
    }

}
