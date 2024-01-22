package model;

public class Estudante {
	
	private String nome;
	private String cpf;
	private Float cra;
	private Integer anoDeAdmissao;

	public Estudante(String nome, String cpf, Float cra, Integer anoDeAdmissao) {
		this.nome = nome;
		this.cpf = cpf;
		this.cra = cra;
		this.anoDeAdmissao = anoDeAdmissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Float getCra() {
		return cra;
	}

	public void setCra(Float cra) {
		this.cra = cra;
	}

	public Integer getAnoDeAdmissao() {
		return anoDeAdmissao;
	}

	public void setAnoDeAdmissão(Integer anoDeAdmissao) {
		this.anoDeAdmissao = anoDeAdmissao;
	}
	
	@Override
	public String toString() {
		return "{" +
                "nome='" + nome + '\'' +
                "cpf='" + cpf + '\'' +
                "cra='" + cra + '\'' +
                "anoDeAdmissão='" + anoDeAdmissao + '\'' +
                '}';
	}

}
