package Factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Checkpoint;
import Model.Passageiro;
import Model.PontoParada;
import Model.Trajeto;
import Model.Trecho;
import Model.Veiculo;
import Util.ConversaoDeDatasUtil;

public class EmpresaDeTransporteFactory {

	public static Passageiro criarPassageiroDeJSONObject(JSONObject objJson) {
		String nome = objJson.getString("nome");
        String numeroCartao = objJson.getString("numeroCartao");

        return new Passageiro(nome, numeroCartao);
	}
	
	public static Veiculo criarVeiculoDeJSONObject(JSONObject objJson) {
		String numero = objJson.getString("numero");

        return new Veiculo(numero);
	}
	
	public static PontoParada criarPontoParadaDeJSONObject(JSONObject objJson) {
		String nome = objJson.getString("nome");

        return new PontoParada(nome);
	}
	
	public static Trecho criarTrechoDeJSONObject(JSONObject objJson) {
		Integer codigo = objJson.getInt("codigo");
		
		JSONObject jsonObjectOrigem = objJson.getJSONObject("origem");
		PontoParada origem = criarPontoParadaDeJSONObject(jsonObjectOrigem);
		
		JSONObject jsonObjectDestino = objJson.getJSONObject("destino");
		PontoParada destino = criarPontoParadaDeJSONObject(jsonObjectDestino);
		
	    Integer intervaloEstimado = objJson.getInt("intervaloEstimado");
		
		return new Trecho(codigo, origem, destino, intervaloEstimado);
	}

	public static Trajeto criarTrajetoDeJSONObject(JSONObject objJson) {
		List<Trecho> listaTrechos = new ArrayList<>();
		
		Integer codigo = objJson.getInt("codigo");
		JSONArray jsonArray = objJson.getJSONArray("listaTrechos");
		
		for (int i = 0; i < jsonArray.length(); i++) {
        	JSONObject objJsonTrecho = jsonArray.getJSONObject(i);
            Trecho trecho = EmpresaDeTransporteFactory.criarTrechoDeJSONObject(objJsonTrecho);
            listaTrechos.add(trecho);
		}
		
		return new Trajeto(codigo, listaTrechos);
	}
	
	public static Checkpoint criarChekpointDeJSONObject(JSONObject objJson) {
		JSONObject jsonObjectTrajeto = objJson.getJSONObject("trajeto");
		Trajeto trajeto = criarTrajetoDeJSONObject(jsonObjectTrajeto);
		
		JSONObject jsonObjectPontoParada = objJson.getJSONObject("pontoDeParada");
		PontoParada pontoParada = criarPontoParadaDeJSONObject(jsonObjectPontoParada);
		
		String data = objJson.getString("dataHoraChegada");
		Date dataHora = ConversaoDeDatasUtil.stringToDate(data);
		
		return new Checkpoint(trajeto, pontoParada, dataHora);
	}

}
