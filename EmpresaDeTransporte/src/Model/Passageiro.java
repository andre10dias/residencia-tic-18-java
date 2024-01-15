package Model;

import java.util.Objects;

public class Passageiro {
	
	private String nome;
    private String numeroCartao;
    
	public Passageiro(String nome, String numeroCartao) {
		this.nome = nome;
		this.numeroCartao = numeroCartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	@Override
	public String toString() {
		return "Passageiro{" +
                "nome='" + nome + '\'' +
                "numeroCartao='" + numeroCartao + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, numeroCartao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(numeroCartao, other.numeroCartao);
	}
    
}
