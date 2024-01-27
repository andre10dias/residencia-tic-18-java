package Models;

import java.util.Date;

import Utils.Util;

public class Pagamento {
	
	private Fatura fatura;
	private double valor;
	private Date data;

	public Pagamento() {
		// TODO Auto-generated constructor stub
	}
	
	public Pagamento(Fatura fatura, double valor) {
        this.fatura = fatura;
        this.valor = valor;
        this.data = new Date();
    }

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
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
