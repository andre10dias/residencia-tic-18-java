package App;

import Controller.PontoParadaController;
import Model.PontoParada;

public class Aplicacao {

	public static void main(String[] args) {
		PontoParadaController controller = new PontoParadaController();
		controller.carregar();
//		
//		PontoParada p = new PontoParada("Pedro");
//		controller.salvar(p);
//		
//		PontoParada p2 = new PontoParada("Maria");
//		controller.salvar(p2);
//		
//		PontoParada p3 = new PontoParada("Fernanda");
//		controller.salvar(p3);
//		
//		PontoParada p4 = new PontoParada("João");
//		controller.salvar(p4);
		
		controller.listar();
		
		PontoParada p2 = controller.buscar(3);
//		p2.setNome("0015223");
//		controller.atualizar(1, p2);
		
		controller.excluir(p2);
		
		controller.listar();
	}

}
