package Models;

import java.util.Date;

import Utils.Util;

public class Reparo {
	
	private String descricao;
	private String previsaoInicial;
	private Date dataInicio;
	private Date dataFim;
	private boolean resolvido;
	private Reparo proximoReparo;

	public Reparo() {
		// TODO Auto-generated constructor stub
	}
	
	public Reparo(String descricao, String previsaoInicial) {
        this.descricao = descricao;
        this.previsaoInicial = previsaoInicial;
        this.dataInicio = new Date();
        this.resolvido = false;
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrevisaoInicial() {
		return previsaoInicial;
	}

	public void setPrevisaoInicial(String previsaoInicial) {
		this.previsaoInicial = previsaoInicial;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isResolvido() {
		return resolvido;
	}

	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}

	public Reparo getProximoReparo() {
		return proximoReparo;
	}

	public void setProximoReparo(Reparo proximoReparo) {
		this.proximoReparo = proximoReparo;
	}
	 // Métodos adicionados para formatar a data e representação em string
	 public String getDataFormatada() {
        return Util.formatDate(dataInicio);
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + "\tPrevisão Inicial: " + previsaoInicial + "\tData Início: " + getDataFormatada() + "\tResolvido: " + resolvido;
    }

}
