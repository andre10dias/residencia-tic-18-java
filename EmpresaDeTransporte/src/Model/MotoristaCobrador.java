package Model;

import java.util.Date;
import java.util.Objects;

public class MotoristaCobrador {
	
	private String nome;
    private Date inicioJornada;
    private Date fimJornada;
    
	public MotoristaCobrador(String nome, Date inicioJornada, Date fimJornada) {
		this.nome = nome;
		this.inicioJornada = inicioJornada;
		this.fimJornada = fimJornada;
	}
	
	public MotoristaCobrador(String nome, Date inicioJornada) {
		this.nome = nome;
		this.inicioJornada = inicioJornada;
	}

	public MotoristaCobrador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInicioJornada() {
		return inicioJornada;
	}

	public void setInicioJornada(Date inicioJornada) {
		this.inicioJornada = inicioJornada;
	}

	public Date getFimJornada() {
		return fimJornada;
	}

	public void setFimJornada(Date fimJornada) {
		this.fimJornada = fimJornada;
	}

	@Override
	public String toString() {
		return "MotoristaCobrador{" +
                "nome='" + nome + '\'' +
                "inicioJornada='" + inicioJornada + '\'' +
                "fimJornada='" + fimJornada + '\'' +
                '}';
	}

	@Override
	public int hashCode() {
		if (inicioJornada == null && fimJornada == null) {
			return Objects.hash(nome);
		}
		else if (inicioJornada != null) {
			return Objects.hash(nome, inicioJornada);
		}
		
		return Objects.hash(fimJornada, inicioJornada, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		MotoristaCobrador other = (MotoristaCobrador) obj;
		
		if (inicioJornada == null && fimJornada == null) {
			return Objects.equals(nome, other.nome);
		}
		else if (inicioJornada != null) {
			return Objects.equals(nome, other.nome) && Objects.equals(fimJornada, other.fimJornada);
		}
		
		return Objects.equals(fimJornada, other.fimJornada) && Objects.equals(inicioJornada, other.inicioJornada)
				&& Objects.equals(nome, other.nome);
	}

}
