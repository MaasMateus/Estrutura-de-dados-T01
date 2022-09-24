package Lista03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEncadeadaTest {

    @Test
    public void testeListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        assertEquals(lista.estaVazia(), true);
    }

    @Test
    public void testeListaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);

        assertEquals(lista.estaVazia(), false);
    }

    @Test
    public void testeListaIncluirUmNumero() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);

        assertEquals(lista.getPrimeiro().getInfo(), 5);
        assertNull(lista.getPrimeiro().getProximo());
    }

    @Test
    public void testeListaIncluirTresNumeros() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        assertEquals(lista.obterNo(0).getInfo(), 15);
        assertEquals(lista.obterNo(1).getInfo(), 10);
        assertEquals(lista.obterNo(2).getInfo(), 5);
    }

    @Test
    public void testeListaBuscarPrimeiroItem() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.getPrimeiro().getInfo(), 20);
    }

    @Test
    public void testeListaBuscarItemNoMeioDaLista() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.buscar(15).getInfo(), 15);
    }


    @Test
    public void testeProva() {
        ListaEncadeada<Integer> numeros = new ListaEncadeada<>();
        numeros.inserir(70);
        numeros.inserir(60);
        numeros.inserir(50);
        numeros.inserir(40);
        numeros.inserir(30);
        numeros.inserir(20);
        numeros.inserir(10);

        System.out.println(numeros.toString());

        ListaEncadeada<Integer> novaLista;
        novaLista = numeros.criarSubLista(2,1);

        assertEquals("30,40,50,60", novaLista.toString());

    }
}