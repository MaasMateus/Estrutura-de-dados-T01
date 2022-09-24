package Lista04;

public class ListaDupla<T> {

    NoListaDupla<T> ultimo;
    NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {

        NoListaDupla<T> no = new NoListaDupla<>(info);

        no.setProximo(primeiro);

        if (primeiro !=null) {
            primeiro.setAnterior(no);
        } else {
            ultimo = no;
        }

        primeiro = no;
    }

    public void retirar(T info) {

        NoListaDupla<T> no = primeiro;
        NoListaDupla<T> anterior = null;
        while (no != null && !(no.getInfo().equals(info))) {
            anterior = no;
            no = no.getProximo();
        }

        if (no != null) {
            if (no == primeiro) {
                primeiro = primeiro.getProximo();
                primeiro.setAnterior(null);
            } else if (no == ultimo) {
                ultimo = ultimo.getAnterior();
                ultimo.setProximo(null);
            } else {
                no.getAnterior().setProximo(no.getProximo());
                no.getProximo().setAnterior(no.getAnterior());
            }
        }

    }

    public int obterComprimento() {

        int tamanho = 0;

        NoListaDupla<T> no = primeiro;

        while (no != null) {
            tamanho++;
            no = no.getProximo();
        }
        return tamanho;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoListaDupla<T> buscar(T info) {

        NoListaDupla<T> no = primeiro;

        while (no != null) {
            if (no.getInfo().equals(info)) {
                return no;
            }
            no = no.getProximo();
        }

        return null;

    }

    public void exibirOrdemInversa() {

        NoListaDupla<T> no = ultimo;

        while (no != null) {
            System.out.println(no.getInfo());
            no = no.getAnterior();
        }
    }

    public void liberar() {

        NoListaDupla no = primeiro;
        NoListaDupla noProx;

        while (no != null) {
            no.setAnterior(null);

            noProx = no.getProximo();

            no.setProximo(null);

            no = noProx;
        }

        this.primeiro = null;
        this.ultimo = null;

    }

    public NoListaDupla<T> obterNo(int i) {

        if (i < 0) {
            throw new IndexOutOfBoundsException("Não é possível acessar index negativo da lista");
        }

        NoListaDupla<T> no = primeiro;

        int j=0;

        while (j!= i && no != null) {
            j++;
            no = no.getProximo();
        }

        if (no == null) {
            throw new IndexOutOfBoundsException("Index " + i + " fora de alcance para a lista");
        }
        return no;
    }

    @Override
    public String toString() {

        String str = "";

        NoListaDupla<T> no = primeiro;

        while (no != null) {

            str += no.getInfo();

            if (no != ultimo) {
                str += ",";
            }

            no = no.getProximo();
        }
        return str;
    }
}
