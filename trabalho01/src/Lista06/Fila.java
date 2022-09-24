package Lista06;

public interface Fila<T> {

    public void inserir(T obj);

    public boolean estaVazia();

    public T peek();

    public T retirar();

    public void liberar();

}
