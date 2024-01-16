package Controller;

public interface IController<T> {
	public String getNome();
    public void cadastrar();
    public void editar();
    public void listar();
    public void remover();
}

