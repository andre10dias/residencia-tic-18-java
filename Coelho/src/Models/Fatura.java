package Models;

import java.util.Date;

import Utils.Util;

public class Fatura {
	
	private Integer id;
	private Imovel imovel;
	private Date dataEmissao;
	private int leituraAnterior;
	private int leituraAtual;
	private double valorCalculado;
	private boolean quitada;

	public Fatura() {
		// TODO Auto-generated constructor stub
	}

	public Fatura(Imovel imovel, int leituraAtual) {
        this.imovel = imovel;
        this.leituraAtual = leituraAtual;
        this.dataEmissao = new Date();
        this.valorCalculado = 10 * leituraAtual;
        this.quitada = false;
    }
	
	public Fatura(Imovel imovel, int leituraAtual, int leituraAnterior) {
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

	public int getLeituraAnterior() {
		return leituraAnterior;
	}

	public void setLeituraAnterior(int leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public int getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(int leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	public double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public boolean isQuitada() {
		return quitada;
	}

	public void setQuitada(boolean quitada) {
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
