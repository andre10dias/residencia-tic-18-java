package Factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Checkpoint;
import Model.Embarque;
import Model.Jornada;
import Model.MotoristaCobrador;
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
	
	public static Embarque criarEmbarqueDeJSONObject(JSONObject objJson) {
		JSONObject jsonObjectPassageiro = objJson.getJSONObject("passageiro");
		Passageiro passageiro = criarPassageiroDeJSONObject(jsonObjectPassageiro);
		
		JSONObject jsonObjectPontoEmbarque = objJson.getJSONObject("pontoDeEmbarque");
		PontoParada pontoDeEmbarque = criarPontoParadaDeJSONObject(jsonObjectPontoEmbarque);
		
		String tipoCartao = objJson.getString("tipoCartao");
		
		String data = objJson.getString("dataHora");
		Date dataHora = ConversaoDeDatasUtil.stringToDate(data);
		
		return new Embarque(passageiro, pontoDeEmbarque, tipoCartao, dataHora);
	}
	
	public static Jornada criarJornadaDeJSONObject(JSONObject objJson) {
		Integer codigo = objJson.getInt("codigo");
		
		String dataInicio = objJson.getString("inicio");
		Date inicio = ConversaoDeDatasUtil.stringToDate(dataInicio);
		
		String dataFim = objJson.getString("fim");
		Date fim = ConversaoDeDatasUtil.stringToDate(dataFim);
		
		JSONObject jsonObjectTrajeto = objJson.getJSONObject("trajeto");
		Trajeto trajeto = criarTrajetoDeJSONObject(jsonObjectTrajeto);
		
		JSONObject jsonObjectVeiculo = objJson.getJSONObject("veiculo");
		Veiculo veiculo = criarVeiculoDeJSONObject(jsonObjectVeiculo);
		
		return new Jornada(codigo, inicio, fim, trajeto, veiculo);
	}
	
	public static MotoristaCobrador criarMotoristaCobradorDeJSONObject(JSONObject objJson) {
		String nome = objJson.getString("nome");
		
		JSONObject jsonObjectJornada = objJson.getJSONObject("jornada");
		Jornada jornada = criarJornadaDeJSONObject(jsonObjectJornada);
		
		return new MotoristaCobrador(nome, jornada);
	}

}
