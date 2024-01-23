package Factory;

import org.json.JSONObject;

import Model.Passageiro;

public class PassageiroFactory implements IFactory<Passageiro> {
	
	public static PassageiroFactory getInstance() {
		return new PassageiroFactory();
	}

	@Override
	public Passageiro criarObjetoDeJSONObject(JSONObject objJson) {
		String nome = objJson.getString("nome");
        String numeroCartao = objJson.getString("numeroCartao");

        return new Passageiro(nome, numeroCartao);
	}

}
