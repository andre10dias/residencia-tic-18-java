package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.PontoParada;
import Model.Trajeto;
import Model.Trecho;

public class TrechoService implements IService<Trecho> {
	
	public static List<Trecho> listaTrechos;
	
	private static final String TRECHO_PATH = PathService.TRECHO_PATH;
	
	private final Integer CODIGO = 0;
	private final Integer ORIGEM = 1;
	private final Integer DESTINO = 2;
	private final Integer INTERVALO = 3;
	
    public TrechoService() {
	}

	@Override
	public List<Trecho> carregar() {
		List<Trecho> lista = new ArrayList<>();
        File arquivo = new File(TRECHO_PATH);

        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {		
    		String[] attr = linha.split(";");
    		
    		Integer codigo = Integer.valueOf(attr[CODIGO]);
    		PontoParada origem = new PontoParada(attr[ORIGEM]);
    		PontoParada destino = new PontoParada(attr[DESTINO]);
    		Integer intervaloEstimado = Integer.valueOf(attr[INTERVALO]);
    		
    		lista.add(new Trecho(codigo, origem, destino, intervaloEstimado));
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Trecho> dados) {
		List<String> lista = new ArrayList<>();
    	File arquivo = new File(TRECHO_PATH);
    	
		for (Trecho dado : dados) {
			
			lista.add(dado.getCodigo() + ";" + dado.getOrigem().getNome() 
					+ ";" + dado.getDestino().getNome() + ";" + dado.getIntervaloEstimado());
		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, lista)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Trecho> dados, Trecho objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Trecho> dados) {
		for (Trecho dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Trecho buscar(List<Trecho> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Trecho atualizar(List<Trecho> dados, Integer indice, Trecho objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Trecho> dados, Trecho objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public static Trecho buscarTrechoPorCodigo(List<Trecho> dados, Integer codigo) {
		for (Trecho dado : dados) {
			if (dado.getCodigo().equals(codigo)) {
				return dado;
			}
		}

		return null;
	}
	
}
