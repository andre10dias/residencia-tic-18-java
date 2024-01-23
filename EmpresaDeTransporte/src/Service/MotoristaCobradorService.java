package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Jornada;
import Model.MotoristaCobrador;
import Util.ControllerUtil;

public class MotoristaCobradorService implements IService<MotoristaCobrador> {
	
	private static final String MOTORISTA_COBRADOR_PATH = PathService.MOTORISTA_COBRADOR_PATH;
	
    public MotoristaCobradorService() {
	}

	@Override
	public List<MotoristaCobrador> carregar() {
		List<MotoristaCobrador> lista = new ArrayList<>();
        File arquivo = new File(MOTORISTA_COBRADOR_PATH);
        
        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new MotoristaCobrador());
        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo, MotoristaCobrador.class, nomesAtributos);
        for (String linha : dados) {
        	String[] attr = linha.split(";");
        	
        	if (attr.length > 1) {				
        		lista.add(new MotoristaCobrador(attr[0], new Jornada(Integer.valueOf(attr[1]))));
			}
        	else {        		
        		lista.add(new MotoristaCobrador(attr[0]));
        	}
		}
        
        return lista;
	}

	@Override
	public void salvar(List<MotoristaCobrador> dados) {
//		List<String> lista = new ArrayList<>();
		File arquivo = new File(MOTORISTA_COBRADOR_PATH);
    	
//    	for (MotoristaCobrador dado : dados) {
//			lista.add(dado.getNome());
//		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, MotoristaCobrador.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<MotoristaCobrador> dados, MotoristaCobrador objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<MotoristaCobrador> dados) {
		for (MotoristaCobrador dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public MotoristaCobrador buscar(List<MotoristaCobrador> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public MotoristaCobrador atualizar(List<MotoristaCobrador> dados, Integer indice, MotoristaCobrador objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<MotoristaCobrador> dados, MotoristaCobrador objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
