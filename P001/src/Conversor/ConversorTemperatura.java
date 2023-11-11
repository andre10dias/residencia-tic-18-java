package Conversor;

public class ConversorTemperatura {
	
	public ConversorTemperatura() {
		// TODO Auto-generated constructor stub
	}
	
	public double converterFahrenheitParaCelsius(double f) {
		//(10 °F − 32) × 5/9
		return (f - 32) * 5 / 9;
	}
	
	public double converterCelsiusParaFahrenheit(double c) {
		//(10 °C × 9/5) + 32
		return c * 9 / 5 + 32;
	}

}
