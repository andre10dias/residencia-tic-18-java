package Models;

public class Falha {
	
	private String descricao;
	private String tipo;
	private Imovel imovelAssociado;
	private Reparo reparo;

	public Falha() {
		// TODO Auto-generated constructor stub
	}
	
	public Falha(String descricao, String tipo, Imovel imovelAssociado) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.imovelAssociado = imovelAssociado;
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Imovel getImovelAssociado() {
		return imovelAssociado;
	}

	public void setImovelAssociado(Imovel imovelAssociado) {
		this.imovelAssociado = imovelAssociado;
	}

	public Reparo getReparo() {
		return reparo;
	}

	public void setReparo(Reparo reparo) {
		this.reparo = reparo;
	}

}
