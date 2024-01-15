package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Jornada;
import Model.MotoristaCobrador;

public class MotoristaCobradorService implements IService<MotoristaCobrador> {
	
	private static final String MOTORISTA_COBRADOR_PATH = PathService.MOTORISTA_COBRADOR_PATH;
	
    public MotoristaCobradorService() {
	}

	@Override
	public List<MotoristaCobrador> carregar() {
		List<MotoristaCobrador> lista = new ArrayList<>();
        File arquivo = new File(MOTORISTA_COBRADOR_PATH);
        
        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {
        	String[] attr = linha.split(";");
            lista.add(new MotoristaCobrador(attr[0], new Jornada(Integer.valueOf(attr[1]))));
		}
        
        return lista;
	}

	@Override
	public void salvar(List<MotoristaCobrador> dados) {
		List<String> lista = new ArrayList<>();
		File arquivo = new File(MOTORISTA_COBRADOR_PATH);
    	
    	for (MotoristaCobrador dado : dados) {
			lista.add(dado.getNome() + ";" + dado.getJornada().getCodigo());
		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, lista)) {
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
