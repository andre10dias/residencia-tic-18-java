package Models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private String cpf;
	private List<Imovel> imoveis;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.imoveis = new ArrayList<>();
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

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	
	@Override
	public String toString() {
		return this.cpf + "\t" + this.nome;
	}
	// Método para adicionar um imóvel ao cliente
    public void adicionarImovel(Imovel imovel) {
        this.imoveis.add(imovel);
    }

    // Método para alterar dados do cliente
    public void alterarDados(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

}
