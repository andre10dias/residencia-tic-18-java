package Models;

import java.util.Date;

import Utils.Util;

public class Fatura {
	
	private Integer id;
	private Imovel imovel;
	private Date dataEmissao;
	private Double leituraAnterior;
	private Double leituraAtual;
	private Double valorCalculado;
	private Boolean quitada;

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
