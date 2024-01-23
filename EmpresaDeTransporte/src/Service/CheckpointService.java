package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Checkpoint;
import Model.PontoParada;
import Model.Trajeto;
import Util.ControllerUtil;
import Util.ConversaoDeDatasUtil;

public class CheckpointService implements IService<Checkpoint> {
	
	private static final String CHECKPOINT_PATH = PathService.CHECKPOINT_PATH;
	
	private final Integer TRAJETO = 0;
	private final Integer PONTO_PARADA = 1;
	private final Integer DATA_HORA = 2;
	
    public CheckpointService() {
	}

	@Override
	public List<Checkpoint> carregar() {
		List<Checkpoint> lista = new ArrayList<>();
        File arquivo = new File(CHECKPOINT_PATH);
        
        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Checkpoint());
        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo, Checkpoint.class, nomesAtributos);
        for (String linha : dados) {
        	String[] attr = linha.split(";");
			
			Trajeto trajeto = new Trajeto(Integer.valueOf(attr[TRAJETO]));
			PontoParada pontoParada = new PontoParada(attr[PONTO_PARADA]);
			Date dataHora = ConversaoDeDatasUtil.stringToDate(attr[DATA_HORA]);
			
			lista.add(new Checkpoint(trajeto, pontoParada, dataHora));
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Checkpoint> dados) {
//		List<String> lista = new ArrayList<>();
    	File arquivo = new File(CHECKPOINT_PATH);
    	
//		for (Checkpoint dado : dados) {
//			lista.add(dado.getTrajeto().getCodigo() + ";" + dado.getPontoDeParada().getNome() 
//					+ ";" + dado.getDataHoraFormatada());
//		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Checkpoint.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Checkpoint> dados, Checkpoint objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Checkpoint> dados) {
		for (Checkpoint dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Checkpoint buscar(List<Checkpoint> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Checkpoint atualizar(List<Checkpoint> dados, Integer indice, Checkpoint objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Checkpoint> dados, Checkpoint objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
}
