package Lista04;

public class NoListaDupla<T> {

    private T info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;

    public NoListaDupla(T t) {
        this.setInfo(t);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T t) {
        info = t;
    }

    public NoListaDupla getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDupla<T> no) {
        proximo = no;
    }

    public NoListaDupla getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaDupla no) {
        anterior = no;
    }}
