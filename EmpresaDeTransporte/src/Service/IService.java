package Service;

import java.util.List;

public interface IService<T> {

    public List<T> carregar();
    public void salvar(List<T> dados);
    public void adicionar(List<T> dados, T objeto);
    public void listar(List<T> dados);
    public T buscar(List<T> dados, Integer indice);
    public T atualizar(List<T> dados, Integer indice, T objeto);
    public void excluir(List<T> dados, T objeto);
    
}
