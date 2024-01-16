package Model;

import java.util.Objects;

public class MotoristaCobrador {
	
	private String nome;
    private Jornada codigoJornada;

	public MotoristaCobrador() {}

	public MotoristaCobrador(String nome) {
		this.nome = nome;
	}
	
	public MotoristaCobrador(String nome, Jornada codigoJornada) {
		this.nome = nome;
		this.codigoJornada = codigoJornada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Jornada getJornada() {
		return codigoJornada;
	}

	public void setJornada(Jornada codigoJornada) {
		this.codigoJornada = codigoJornada;
	}

	@Override
	public String toString() {
		return "MotoristaCobrador{" +
                "nome='" + nome + '\'' +
                "codigoJornada='" + codigoJornada + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoJornada, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MotoristaCobrador other = (MotoristaCobrador) obj;
		return Objects.equals(codigoJornada, other.codigoJornada) && Objects.equals(nome, other.nome);
	}

}
