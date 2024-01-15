package Model;

import java.util.List;
import java.util.Objects;

public class Trajeto {
	
	private String codigo;
	private List<Trecho> listaTrechos;

	public Trajeto(String codigo, List<Trecho> listaTrechos) {
		this.codigo = codigo;
		this.listaTrechos = listaTrechos;
	}

	public List<Trecho> getListaTrechos() {
		return listaTrechos;
	}

	public void setListaTrechos(List<Trecho> listaTrechos) {
		this.listaTrechos = listaTrechos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Trajeto{" +
        "listaTrechos='" + listaTrechos + '\'' +
        '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trajeto other = (Trajeto) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
