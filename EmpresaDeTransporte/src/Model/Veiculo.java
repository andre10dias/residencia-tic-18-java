package Model;

import java.util.Objects;

public class Veiculo {
	
	private String numero;

	public Veiculo() {}
	
	public Veiculo(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Veiculo{" +
                "numero='" + numero + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(numero, other.numero);
	}

}
