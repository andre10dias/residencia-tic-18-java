package Util;

import java.text.DecimalFormat;

public class Util {
	
	public static int stringToInt(String str) {
		int retorno = -1;
		
		if (str != null && str != "") {
			retorno = Integer.parseInt(str);
		}
		
		return retorno;
	}
	
	public static float stringToFloat(String str) {
		float retorno = -1;
		
		if (str != null && str != "") {
			retorno = Float.parseFloat(str);
		}
		
		return retorno;
	}
	
	public static String formatNumber(float num) {
		DecimalFormat formato = new DecimalFormat("#.##");
        return formato.format(num);
	}

}
