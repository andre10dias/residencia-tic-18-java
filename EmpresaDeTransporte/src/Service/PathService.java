package Service;

import java.io.File;

public class PathService {
	
	private static final String PATH = "src" + File.separator + "Bd" + File.separator;
	private static final String EXTENSAO = ".json";
	
	protected static final String VEICULO_PATH = PATH + "veiculo" + EXTENSAO;
	protected static final String PASSAGEIRO_PATH = PATH + "passageiro" + EXTENSAO;
	protected static final String MOTORISTA_COBRADOR_PATH = PATH + "motoristaCobrador" + EXTENSAO;
	protected static final String PONTO_PARADA_PATH = PATH + "pontoParada" + EXTENSAO;
	protected static final String TRECHO_PATH = PATH + "trecho" + EXTENSAO;
	protected static final String TRAJETO_PATH = PATH + "trajeto" + EXTENSAO;
	protected static final String CHECKPOINT_PATH = PATH + "checkpoint" + EXTENSAO;
	protected static final String EMBARQUE_PATH = PATH + "embarque" + EXTENSAO;
	protected static final String JORNADA_PATH = PATH + "jornada" + EXTENSAO;

}
