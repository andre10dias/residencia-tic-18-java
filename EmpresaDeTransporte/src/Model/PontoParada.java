package Model;

import java.util.Objects;

public class PontoParada {
	
	private String nome;

	public PontoParada(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "PontoParada{" +
                "nome='" + nome + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoParada other = (PontoParada) obj;
		return Objects.equals(nome, other.nome);
	}

}
