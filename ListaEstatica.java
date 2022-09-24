package Lista02;

public class ListaEstatica <T>{

    private T[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }

    public void inserir(T t) {

        if (info.length == tamanho) {
            this.redimensionar();
        }

        info[tamanho] = t;
        tamanho++;
    }

    private void redimensionar() {

        T[] novo = (T[]) new Object[info.length + 10];

        for (int i=0; i < tamanho; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    public void exibir() {
        System.out.println(this.toString());
    }

    public int buscar(T t) {

        for (int i=0;i<tamanho;i++) {
            if (t == info[i]) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T t) {

        int indexI = this.buscar(t);

        if (indexI != -1) {

            for (int i=indexI;i<tamanho-1;i++) {
                if (i == tamanho-1) {
                    info[i] = null;
                }
                else {
                    info[i] = info[i+1];
                }
            }
            tamanho--;
        }

    }

    public void liberar() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int i) throws IndexOutOfBoundsException {

        if (i > tamanho -1) {
            throw new IndexOutOfBoundsException("Elemento não existe");
        }
        return info[i];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {

        String str = "";

        for (int i=0; i<tamanho;i++) {

            str += info[i];

            if (i != tamanho -1) {
                str += ",";
            }
        }

        return str;
    }
}
