package Models;

public class Imovel {
	
	private String matricula;
	private String endereco;
	private int leituraAnterior;
	private int leituraAtual;

	public Imovel() {
		// TODO Auto-generated constructor stub
	}

	public Imovel(String matricula, String endereco) {
		this.matricula = matricula;
		this.endereco = endereco;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getLeituraAnterior() {
		return leituraAnterior;
	}

	public void setLeituraAnterior(int leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public int getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(int leituraAtual) {
		this.leituraAtual = leituraAtual;
	}
	
	@Override
	public String toString() {
		return this.matricula + "\t" + this.endereco;
	}

}
