package App;

import Model.Carro;
import Model.Garagem;
import Model.Moto;

public class Aplicacao {

	public static void main(String[] args) {
		
		Garagem garagem = new Garagem(true);
		
		Carro carro = new Carro("Fusca", "branco", 1980, false, 2);
        Moto moto = new Moto("CG500", "preto", 2000, true, true);
        
        carro.abrirPortas();
        carro.ligar();
        carro.acelerar();
        carro.estacionar(garagem);
        
        System.out.println("----------------------");
        
        moto.ligar();
        moto.acelerar();
        moto.parar();
        moto.estacionar(garagem);
        

	}

}
