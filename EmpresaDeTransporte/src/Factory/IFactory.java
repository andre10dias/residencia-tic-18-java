package Factory;

import org.json.JSONObject;

public interface IFactory <T> {
	
	public T criarObjetoDeJSONObject(JSONObject objJson);

}
