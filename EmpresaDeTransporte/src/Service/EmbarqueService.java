package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Embarque;
import Model.Passageiro;
import Model.PontoParada;
import Util.ConversaoDeDatasUtil;

public class EmbarqueService implements IService<Embarque> {
	
	private static final String EMBARQUE_PATH = PathService.EMBARQUE_PATH;
	
	private final Integer PASSAGEIRO_NOME = 0;
	private final Integer PASSAGEIRO_NUM_CARTAO = 1;
	private final Integer PONTO_EMBARQUE = 2;
	private final Integer TIPO_CARTAO = 3;
	private final Integer DATA_HORA = 4;
	
    public EmbarqueService() {
	}

	@Override
	public List<Embarque> carregar() {
		List<Embarque> lista = new ArrayList<>();
        File arquivo = new File(EMBARQUE_PATH);

        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {
        	String[] attr = linha.split(";");
			
			Passageiro passageiro = new Passageiro(attr[PASSAGEIRO_NOME], attr[PASSAGEIRO_NUM_CARTAO]);
			PontoParada pontoEmbarque = new PontoParada(attr[PONTO_EMBARQUE]);
			String tipoCartao = attr[TIPO_CARTAO];
			Date dataHora = ConversaoDeDatasUtil.stringToDate(attr[DATA_HORA]);
			
			lista.add(new Embarque(passageiro, pontoEmbarque, tipoCartao, dataHora));
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Embarque> dados) {
		List<String> lista = new ArrayList<>();
    	File arquivo = new File(EMBARQUE_PATH);
    	
		for (Embarque dado : dados) {
			lista.add(dado.getPassageiro().getNome() + ";" + dado.getPassageiro().getNumeroCartao() 
					+ ";" + dado.getPontoDeEmbarque().getNome()+ ";" + dado.getTipoCartao() 
					+ ";" + dado.getDataHoraFormatada());
		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, lista)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Embarque> dados, Embarque objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Embarque> dados) {
		for (Embarque dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Embarque buscar(List<Embarque> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Embarque atualizar(List<Embarque> dados, Integer indice, Embarque objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Embarque> dados, Embarque objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
}
