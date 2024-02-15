package com.formula1.vencedoresformula1.util;

import java.text.DecimalFormat;

public class VencedoresUtil {
	
	public static String defineCasasDecimais(Double valor, int casasDecimais) {
		String pattern = "#." + "0".repeat(casasDecimais);
		DecimalFormat df = new DecimalFormat(pattern);
		
		if (casasDecimais == 0) {
			return df.format(valor).replace(",", "").replace(".", "");
		}
		
		return df.format(valor);
	}

}
