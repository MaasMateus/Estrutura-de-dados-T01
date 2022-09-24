package Lista06;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho = 0;
    private int inicio = 0;

    public FilaVetor(int limite) {
        this.limite = limite;
    }

    @Override
    public void inserir(T obj) {

        if (tamanho >= limite) {
            throw new RuntimeException("A pilha já atingiu sua capacidade máxima");
        }

        info[(inicio + tamanho) % limite] = obj;

        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho<=0;
    }

    @Override
    public T peek() {

        return info[inicio];
    }

    @Override
    public T retirar() {

        if (tamanho==0) {
            throw new RuntimeException("Não foi possível retirar o item da pilha - já está vazia");
        }

        T primeiro = info[inicio];

        inicio = (inicio + 1) % limite;

        tamanho--;

        return primeiro;
    }

    @Override
    public void liberar() {

    }
}
