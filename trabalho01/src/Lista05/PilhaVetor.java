public class PilhaVetor<T> implements Pilha {
    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
    }

    public void push(T valor) {
        if (tamanho == limite) {
            throw new PilhaEstaVaziaException();
        }
        this.info[tamanho] = valor;
        tamanho++;
    }

    public T peek() {
        return this.info[tamanho - 1];
    }

    public T pop() {
        if (tamanho == 0) {
            throw new PilhaEstaVaziaException();
        }
        T valor = peek();
        info[tamanho - 1] = null;
        tamanho--;
        return valor;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void liberar() {
        //info = (T[]) new Object[tamanho];
        //tamanho = 0;

        //implementação mais elegante:
        while (!estaVazia()) {
            pop();
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < tamanho - 1; i++) {
            str += this.info[i] + ", "; 
        }
        return str += this.info[tamanho - 1] + ".";       
    }

    public void concatenar(PilhaVetor<T> pv) {
        for (int i = 0; i < pv.tamanho; i++) {
            this.push(info[i]);
        }       
    }
}