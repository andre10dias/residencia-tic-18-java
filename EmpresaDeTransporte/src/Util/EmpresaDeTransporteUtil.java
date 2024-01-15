package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpresaDeTransporteUtil {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static Date stringToDate(String data) {
		if (data != null && !"".equals(data.trim())) {			
			try {
				return sdf.parse(data);
			} catch (Exception e) {
				System.err.println("Erro ao converter dados: " + e.getMessage());
			}
		}
		
		return null;
	}
	
	public static String dateToString(Date data) {
		if (data != null) {			
			try {
				return sdf.format(data);
			} catch (Exception e) {
				System.err.println("Erro ao converter dados: " + e.getMessage());
			}
		}
		
		return null;
	}

}
