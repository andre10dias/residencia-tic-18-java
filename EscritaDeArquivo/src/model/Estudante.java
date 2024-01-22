package model;

public class Estudante {
	
	private String nome;
	private String cpf;
	private Float cra;
	private Integer AnoDeAdmissão;

	public Estudante(String nome, String cpf, Float cra, Integer anoDeAdmissão) {
		this.nome = nome;
		this.cpf = cpf;
		this.cra = cra;
		AnoDeAdmissão = anoDeAdmissão;
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

	public Integer getAnoDeAdmissão() {
		return AnoDeAdmissão;
	}

	public void setAnoDeAdmissão(Integer anoDeAdmissão) {
		AnoDeAdmissão = anoDeAdmissão;
	}

}
