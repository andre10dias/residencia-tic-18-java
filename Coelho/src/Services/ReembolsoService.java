package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Fatura;
import Models.Reembolso;

public class ReembolsoService {
	
	private static List<Reembolso> reembolsos;
	
	public static List<Reembolso> getReembolsos() {
		if (reembolsos == null) {
			reembolsos = new ArrayList<>();
		}
		
		return reembolsos;
	}
	
	public static void addReembolso(Reembolso p) {
		if (reembolsos == null) {
			reembolsos = new ArrayList<>();
		}
		
		reembolsos.add(p);
	}
	
	public static List<Reembolso> getReembolsosByFatura(Fatura f) {
		List<Reembolso> reembolsosFatura = new ArrayList<>();
		
		for (Reembolso reembolso : getReembolsos()) {
			if (reembolso.getFatura().equals(f)) {
				reembolsosFatura.add(reembolso);
			}
		}
		
		return reembolsosFatura;
	}
	
}
