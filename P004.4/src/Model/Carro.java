package Model;

public class Carro extends Veiculo {
	
	private int numeroPortas;

    public Carro(String modelo, String cor, int ano, boolean eletrico, int numeroPortas) {
        super(modelo, cor, ano, eletrico);
        this.numeroPortas = numeroPortas;
    }

    @Override
    public void ligar() {
        System.out.println("Carro ligado.");
    }

    public void abrirPortas() {
        System.out.println("Portas do carro abertas.");
    }
	
}
