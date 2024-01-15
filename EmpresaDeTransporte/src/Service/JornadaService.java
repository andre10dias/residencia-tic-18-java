package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Jornada;
import Model.MotoristaCobrador;
import Model.Trajeto;
import Model.Veiculo;
import Util.EmpresaDeTransporteUtil;

public class JornadaService implements IService<Jornada> {
	
	private static final String JORNADA_PATH = PathService.JORNADA_PATH;
	
	private final Integer INICIO = 0;
	private final Integer FIM = 1;
	private final Integer TRAJETO = 2;
	private final Integer MOTORISTA_COBRADOR = 3;
	private final Integer VEICULO = 4;
	
    public JornadaService() {
	}

	@Override
	public List<Jornada> carregar() {
		List<Jornada> lista = new ArrayList<>();
        File arquivo = new File(JORNADA_PATH);

        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {
        	String[] attr = linha.split(";");
			
        	Date inicio = EmpresaDeTransporteUtil.stringToDate(attr[INICIO]);
        	Date fim = EmpresaDeTransporteUtil.stringToDate(attr[FIM]);
			Trajeto trajeto = new Trajeto(attr[TRAJETO]);
			MotoristaCobrador motoristaCobrador = new MotoristaCobrador(attr[MOTORISTA_COBRADOR]);
			Veiculo veiculo = new Veiculo(attr[VEICULO]);
			
			lista.add(new Jornada(inicio, fim, trajeto, motoristaCobrador, veiculo));
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Jornada> dados) {
		List<String> lista = new ArrayList<>();
    	File arquivo = new File(JORNADA_PATH);
    	
		for (Jornada dado : dados) {
			lista.add(dado.getDataInicioFormatada() + ";" + dado.getDataFimFormatada() 
					+ ";" + dado.getTrajeto().getCodigo()+ ";" + dado.getMotoristaCobrador().getNome()
					+ ";" + dado.getVeiculo().getNumero());
		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, lista)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Jornada> dados, Jornada objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Jornada> dados) {
		for (Jornada dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Jornada buscar(List<Jornada> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Jornada atualizar(List<Jornada> dados, Integer indice, Jornada objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Jornada> dados, Jornada objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
}
