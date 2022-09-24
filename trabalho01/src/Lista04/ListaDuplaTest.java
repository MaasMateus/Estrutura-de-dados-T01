package Lista04;

import Lista04.ListaDupla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDuplaTest {

    ListaDupla<Integer> lista = new ListaDupla<>();

    @Test
    public void testeListaVazia() {
        assertEquals(lista.estaVazia(), true);
    }

    @Test
    public void testeIncluirElementos() {

        for (int i=1; i<5;i++) {
            lista.inserir(i*5);
        }


        NoListaDupla no = lista.getPrimeiro();

        for (int i=4;i>0;i--) {
            assertEquals(no.getInfo(), i*5);
            no = no.getProximo();
        }

    }

    @Test
    public void buscarNo20() {

        for (int i=1; i<5;i++) {
            lista.inserir(i*5);
        }

        NoListaDupla no = lista.buscar(20);

        System.out.println(no.getInfo());

        assertEquals(no.getInfo(),20);

    }

    @Test
    public void testeLiberarLista() {

        for (int i=1; i<5;i++) {
            lista.inserir(i*5);
        }

        lista.liberar();

        lista.exibirOrdemInversa();

    }



}