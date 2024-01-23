package Factory;

import org.json.JSONObject;

import Model.Passageiro;
import Model.Veiculo;

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

}
