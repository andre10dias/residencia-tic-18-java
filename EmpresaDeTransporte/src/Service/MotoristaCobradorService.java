package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.MotoristaCobrador;

public class MotoristaCobradorService implements IService<MotoristaCobrador> {
	
	private static final String MOTORISTA_COBRADOR_PATH = "src/Bd/motoristaCobrador.txt";
	
	private final Integer NOME = 0;
	private final Integer INICIO_JORNADA = 1;
	private final Integer FIM_JORNADA = 2;
	
    public MotoristaCobradorService() {
	}

	@Override
	public List<MotoristaCobrador> carregar() {
		List<MotoristaCobrador> lista = new ArrayList<>();
        File arquivo = new File(MOTORISTA_COBRADOR_PATH);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String linha;
        
        if (arquivo.exists()) {	
	        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
	            System.out.println("Lendo arquivo " + MOTORISTA_COBRADOR_PATH + "...\n");
	
	            while ((linha = reader.readLine()) != null) {
	                String[] attr = linha.split(";");
	                
	                String nome = attr[NOME];
	                Date inicioJornada = null;
	                Date fimJornada = null;
	                
					try {
						inicioJornada = sdf.parse(attr[INICIO_JORNADA]);
						fimJornada = sdf.parse(attr[FIM_JORNADA]);
					} catch (ParseException e) {
						System.err.println("Erro ao converter dados: " + e.getMessage());
					}
	                
	                switch (attr.length) {
						case 1:
							lista.add(new MotoristaCobrador(nome));
							break;
						case 2:
							lista.add(new MotoristaCobrador(nome, inicioJornada));
							break;
						default:
							lista.add(new MotoristaCobrador(nome, inicioJornada, fimJornada));
							break;
					}
	            }
	
	        } catch (IOException e) {
	            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
        }
        
        return lista;
	}

	@Override
	public void salvar(List<MotoristaCobrador> dados) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(MOTORISTA_COBRADOR_PATH))) {
            for (MotoristaCobrador motoristaCobrador : dados) {
                writer.write(motoristaCobrador.getNome() + ";" + motoristaCobrador.getInicioJornada() 
                	+ ";" + motoristaCobrador.getFimJornada());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
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
			System.out.println("\nMotorista/Cobrador removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
