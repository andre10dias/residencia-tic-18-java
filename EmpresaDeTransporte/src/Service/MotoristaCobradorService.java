package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.MotoristaCobrador;
import Util.EmpresaDeTransporteUtil;

public class MotoristaCobradorService implements IService<MotoristaCobrador> {
	
	private static final String MOTORISTA_COBRADOR_PATH = PathService.MOTORISTA_COBRADOR_PATH;
	
	private final Integer NOME = 0;
	private final Integer INICIO_JORNADA = 1;
	private final Integer FIM_JORNADA = 2;
	
    public MotoristaCobradorService() {
	}

	@Override
	public List<MotoristaCobrador> carregar() {
		List<MotoristaCobrador> lista = new ArrayList<>();
        File arquivo = new File(MOTORISTA_COBRADOR_PATH);
        
        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {
        	String[] attr = linha.split(";");
            
            String nome = attr[NOME];
            Date inicioJornada = null;
            Date fimJornada = null;
            
            switch (attr.length) {
				case 1:
					lista.add(new MotoristaCobrador(nome));
					break;
				case 2:
					inicioJornada = EmpresaDeTransporteUtil.stringToDate(attr[INICIO_JORNADA]);
					lista.add(new MotoristaCobrador(nome, inicioJornada));
					break;
				default:
					inicioJornada = EmpresaDeTransporteUtil.stringToDate(attr[INICIO_JORNADA]);
					fimJornada = EmpresaDeTransporteUtil.stringToDate(attr[FIM_JORNADA]);
					lista.add(new MotoristaCobrador(nome, inicioJornada, fimJornada));
					break;
			}
		}
        
        return lista;
	}

	@Override
	public void salvar(List<MotoristaCobrador> dados) {
		List<String> lista = new ArrayList<>();
		File arquivo = new File(MOTORISTA_COBRADOR_PATH);
    	
    	for (MotoristaCobrador dado : dados) {
			lista.add(dado.getNome() + ";" + dado.getInicioJornadaFormatado() 
					+ ";" + dado.getFimJornadaFormatado());
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
		for (MotoristaCobrador motoristaCobrador : dados) {
            System.out.println(motoristaCobrador);
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
