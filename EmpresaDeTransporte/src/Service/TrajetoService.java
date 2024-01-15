package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.PontoParada;
import Model.Trajeto;
import Model.Trecho;

public class TrajetoService implements IService<Trajeto> {
	
	private static final String TRAJETO_PATH = PathService.TRAJETO_PATH;
	
	private final Integer CODIGO = 0;
	private final Integer ORIGEM = 1;
	private final Integer DESTINO = 2;
	private final Integer INTERVALO = 3;
	
    public TrajetoService() {
	}

	@Override
	public List<Trajeto> carregar() {
		List<Trajeto> lista = new ArrayList<>();
        File arquivo = new File(TRAJETO_PATH);

        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {
        	List<Trecho> listaTrechos = new ArrayList<>();
        	String[] attr = linha.split(";");
			
        	String codigo = attr[CODIGO];
			PontoParada origem = new PontoParada(attr[ORIGEM]);
			PontoParada destino = new PontoParada(attr[DESTINO]);
			Integer intervaloEstimado = Integer.valueOf(attr[INTERVALO]);
			
			Trecho trecho = new Trecho(codigo, origem, destino, intervaloEstimado);
//			trecho.setCodigoTrajeto(codigo);
			listaTrechos.add(trecho);
			
			lista.add(new Trajeto(codigo, listaTrechos));
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Trajeto> dados) {
		List<String> lista = new ArrayList<>();
    	File arquivo = new File(TRAJETO_PATH);
    	
		for (Trajeto dado : dados) {
//			String codigoTrajeto = dado.getCodigo();
			
			for (Trecho trecho : dado.getListaTrechos()) {				
    			lista.add(trecho.getCodigo() + ";" + trecho.getOrigem().getNome() 
    					+ ";" + trecho.getDestino().getNome() + ";" + trecho.getIntervaloEstimado());
			}
		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, lista)) {
			System.out.println("\nDados gravados com sucesso.");
		}
		
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRAJETO_PATH))) {
//    		System.err.println("\nSalvando dados no arquivo " + TRAJETO_PATH + "...\n");
//    		
//    		for (Trajeto trajeto : dados) {	
//    			for (Trecho trecho : trajeto.getListaTrechos()) {				
//        			writer.write(trecho.getOrigem().getNome() + ";" + trecho.getDestino().getNome() 
//        					+ ";" + trecho.getIntervaloEstimado());
//        			writer.newLine();
//    			}
//			}
//        } catch (IOException e) {
//            System.err.println("\nErro ao salvar os dados: " + e.getMessage());
//        }
	}

	@Override
	public void adicionar(List<Trajeto> dados, Trajeto objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Trajeto> dados) {
		for (Trajeto trajeto : dados) {
            System.out.println(trajeto);
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
			System.out.println("\nPonto de parada removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
