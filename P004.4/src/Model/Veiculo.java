package Model;

public class Veiculo {
	
	private String modelo;
    private String cor;
    private int ano;
    private boolean eletrico;
    
    public Veiculo(String modelo, String cor, int ano, boolean eletrico) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.eletrico = eletrico;
    }

    public void ligar() {
        System.out.println("Veículo ligado.");
    }

    public void acelerar() {
        System.out.println("Veículo acelerando...");
    }

    public void parar() {
        System.out.println("Veículo parado.");
    }
    
    public void estacionar(Garagem garagem) {
        garagem.adicionarVeiculo(this);
    }

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isEletrico() {
		return eletrico;
	}

	public void setEletrico(boolean eletrico) {
		this.eletrico = eletrico;
	}
	
}
