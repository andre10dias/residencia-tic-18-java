package Util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ControllerUtil {
	
	public static <T> List<String> obterNomesAtributos(T objeto) {
	    List<String> listaNomesAtributos = new ArrayList<>();

	    for (Field field : objeto.getClass().getDeclaredFields()) {
	    	listaNomesAtributos.add(field.getName());
	    }

	    return listaNomesAtributos;
	}

}
