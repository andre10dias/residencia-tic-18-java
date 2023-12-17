package App;

import Model.Carro;
import Model.Moto;

public class Aplicacao {

	public static void main(String[] args) {

		Carro carro = new Carro("Fusca", "branco", 1980, 2);
        Moto moto = new Moto("CG500", "preto", 2000, true);
        
        carro.abrirPortas();
        carro.ligar();
        carro.acelerar();
        
        System.out.println("----------------------");
        
        moto.ligar();
        moto.acelerar();
        moto.parar();
        

	}

}
