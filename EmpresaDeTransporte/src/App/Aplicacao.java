package App;

import java.util.ArrayList;
import java.util.List;

import Controller.TrajetoController;
import Controller.TrechoController;
import Model.Trajeto;
import Model.Trecho;

public class Aplicacao {

	public static void main(String[] args) {
//		TrechoController controller = new TrechoController();
//		PontoParadaController ppController = new PontoParadaController();
//		
//		controller.carregar();
//		ppController.carregar();
//		
//		List<PontoParada> lista = PontoParadaController.listaPontoParadas;
//		
//		PontoParada origem = lista.get(0);
//		PontoParada destino = lista.get(1);
//		Trecho p = new Trecho("A174", origem, destino, 2);
//		controller.salvar(p);
//		
//		PontoParada origem2 = lista.get(2);
//		PontoParada destino2 = lista.get(3);
//		Trecho p2 = new Trecho("B159", origem2, destino2, 3);
//		controller.salvar(p2);
//		
//		PontoParada origem3 = lista.get(1);
//		PontoParada destino3 = lista.get(0);
//		Trecho p3 = new Trecho("C357", origem3, destino3, 5);
//		controller.salvar(p3);
//		
//		PontoParada origem4 = lista.get(3);
//		PontoParada destino4 = lista.get(2);
//		Trecho p4 = new Trecho("C357", origem4, destino4, 10);
//		controller.salvar(p4);
//		
//		PontoParada origem5 = lista.get(2);
//		PontoParada destino5 = lista.get(3);
//		Trecho p5 = new Trecho("B159", origem5, destino5, 8);
//		controller.salvar(p5);
//		
//		PontoParada origem6 = lista.get(0);
//		PontoParada destino6 = lista.get(1);
//		Trecho p6 = new Trecho("C357", origem6, destino6, 1);
//		controller.salvar(p6);
//		
//		controller.listar();
//		
//		PontoParada origem4 = lista.get(3);
//		PontoParada destino = lista.get(1);
//		Trecho p2 = controller.buscar(1);
//		p2.setOrigem(origem4);
//		p2.setDestino(destino);
//		controller.atualizar(1, p2);
//		
//		controller.excluir(p2);
//		
//		controller.listar();
		
//		==================================================
		
		TrechoController tController = new TrechoController();
		TrajetoController  controller = new TrajetoController();
		
		tController.carregar();
		controller.carregar();
		
		List<Trecho> lista = TrechoController.listaTrechos;
		
		Trecho trecho = lista.get(0);
		Trecho trecho1 = lista.get(1);
		Trecho trecho2 = lista.get(2);
		Trecho trecho3 = lista.get(3);
		
		List<Trecho> listaTrecho1 = new ArrayList<>();
		List<Trecho> listaTrecho2 = new ArrayList<>();
		List<Trecho> listaTrecho3 = new ArrayList<>();
		
		listaTrecho1.add(trecho3);
		listaTrecho1.add(trecho2);
		listaTrecho1.add(trecho);
		
		listaTrecho2.add(trecho);
		listaTrecho2.add(trecho2);
		listaTrecho2.add(trecho1);
		
		listaTrecho3.add(trecho3);
		listaTrecho3.add(trecho2);
		listaTrecho3.add(trecho);
		listaTrecho3.add(trecho1);
		
		Trajeto p = new Trajeto("A174", listaTrecho1);
		controller.salvar(p);
		
		Trajeto p1 = new Trajeto("B159", listaTrecho2);
		controller.salvar(p1);
		
		Trajeto p2 = new Trajeto("C357", listaTrecho3);
		controller.salvar(p2);
		
		controller.listar();
//		
//		Trecho p2 = controller.buscar(1);
//		p2.setOrigem(origem4);
//		p2.setDestino(destino);
//		controller.atualizar(1, p2);
//		
//		controller.excluir(p2);
//		
//		controller.listar();
	}

}
