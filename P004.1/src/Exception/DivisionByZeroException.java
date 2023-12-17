package Exception;

public class DivisionByZeroException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DivisionByZeroException () {
	}
	
	public String getMessage(){
		return "Não é possível dividir por zero.";
	}

}
