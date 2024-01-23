package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Trajeto;
import Model.Trecho;
import Util.ControllerUtil;

public class TrajetoService implements IService<Trajeto> {
	
	public static List<Trajeto> listaTrajetos;
	
	private static final String TRAJETO_PATH = PathService.TRAJETO_PATH;
	
    public TrajetoService() {
	}

	@Override
	public List<Trajeto> carregar() {
		List<Trajeto> lista = new ArrayList<>();
        File arquivo = new File(TRAJETO_PATH);
        
        TrechoService trechoService = new TrechoService();
        List<Trecho> listaTrechos = trechoService.carregar();

        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Trajeto());
        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo, Trajeto.class, nomesAtributos);
        for (String linha : dados) {
        	List<Trecho> listaTT = new ArrayList<>();
        	Trecho trecho = null;
        	String[] attr = linha.split(";");
    		
    		Integer codigoTrajeto = Integer.valueOf(attr[0]);
    		for (int i = 1; i < attr.length; i++) {
				trecho = TrechoService.buscarTrechoPorCodigo(listaTrechos, Integer.valueOf(attr[i]));
				listaTT.add(trecho);
			}
    		
        	Trajeto trajeto = new Trajeto(codigoTrajeto, listaTT);
			lista.add(trajeto);
			
//			List<Trecho> listaTrecho = EmpresaDeTransporteService
//					.buscarTrechosPorCodigoTrajeto(trajeto.getCodigo());
//			trajeto.setListaTrechos(listaTrecho);
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Trajeto> dados) {
//		List<String> lista = new ArrayList<>();
    	File arquivo = new File(TRAJETO_PATH);
    	
//		for (Trajeto dado : dados) {
//			String str = "";
//			str += dado.getCodigo().toString();
//			
//			for (Trecho tt : dado.getListaTrechos()) {
//				str += ";" + tt.getCodigo().toString();
//			}
//			
//			if (str != "") {
//				lista.add(str);
//			}
//		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Trajeto.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Trajeto> dados, Trajeto objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Trajeto> dados) {
		for (Trajeto dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Trajeto buscar(List<Trajeto> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Trajeto atualizar(List<Trajeto> dados, Integer indice, Trajeto objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Trajeto> dados, Trajeto objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public static Trajeto buscarTrajetoPorCodigo(List<Trajeto> listaTrajetos, Integer codigoTrajeto) {
		for (Trajeto trajeto : listaTrajetos) {
			if (trajeto.getCodigo().equals(codigoTrajeto)) {
				return trajeto;
			}
		}
		
		return null;
	}

}
