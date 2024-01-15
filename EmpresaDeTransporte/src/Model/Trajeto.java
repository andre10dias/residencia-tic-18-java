package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trajeto {
	
	private Integer codigo;
	private List<Trecho> listaTrechos;

	public Trajeto(Integer codigo) {
		this.codigo = codigo;
		this.listaTrechos = new ArrayList<>();
	}

	public List<Trecho> getListaTrechos() {
		return listaTrechos;
	}

	public void setListaTrechos(List<Trecho> listaTrechos) {
		this.listaTrechos = listaTrechos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Trajeto{" +
        "codigo='" + codigo + '\'' +
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
