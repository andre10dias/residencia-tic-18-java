package Model;

import java.util.ArrayList;
import java.util.List;

public class Garagem {
	
	private List<Veiculo> veiculos;
    private boolean tomadaEletrica;

    public Garagem(boolean tomadaEletrica) {
        this.veiculos = new ArrayList<>();
        this.tomadaEletrica = tomadaEletrica;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        System.out.println(veiculo.getClass().getSimpleName() + " estacionado(a)");

        if (tomadaEletrica && veiculo.isEletrico()) {
            System.out.println(veiculo.getClass().getSimpleName() + " carregando...");
        }
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
        System.out.println(veiculo.getClass().getSimpleName() + " removido(a) da garagem");
    }

}
