public class PilhaLista implements Pilha {
    private ListaEncadeada lista;

    public PilhaLista() {
        this.lista = new ListaEncadeada();
    }

    public void push(String info) {
        lista.inserir(info);
    }

    public String peek() {
        if (estaVazia()) {
            return "A pilha está vazia.";
        }
        return lista.getPrimeiro().getInfo();
    }

    public String pop() {
        String tag = peek();
        lista.retirar(tag);
        return tag;
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public void liberar() {
        while(!estaVazia()) {
            pop();
        }
    }
}
