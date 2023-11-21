package ConversorMoedas;

public class ConversorDeMoedas {
	
	private double taxaCambio;
	private double valorDolar;

	public ConversorDeMoedas() {
		// TODO Auto-generated constructor stub
	}

	public ConversorDeMoedas(double taxaCambio, double valorDolar) {
		this.taxaCambio = taxaCambio;
		this.valorDolar = valorDolar;
	}

	public double getTaxaCambio() {
		return taxaCambio;
	}

	public void setTaxaCambio(double taxaCambio) {
		this.taxaCambio = taxaCambio;
	}

	public double getValorDolar() {
		return valorDolar;
	}

	public void setValorDolar(double valorDolar) {
		this.valorDolar = valorDolar;
	}
	
	public double converte() {
		return valorDolar * taxaCambio;
	}

}
