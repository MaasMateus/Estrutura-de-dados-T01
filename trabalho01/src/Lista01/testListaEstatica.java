package Lista01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testListaEstatica {

	@Test
	void testeInclusao() { // Caso 1
		
		ListaEstatica lista = new ListaEstatica();
		
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.inserir(12);
		
		assertEquals("5,10,12,15,20", lista.toString());
		
	}

	@Test
	void testeObtencao() { // Caso 2
		
		ListaEstatica lista = new ListaEstatica();
		
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(lista.getTamanho(), 4);
		
	}
	
	@Test
	void testeBuscar() { // Caso 3
		ListaEstatica lista = new ListaEstatica();
		
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(lista.buscar(15), 2);
		
	}
	
	@Test 
	void testeBuscarElementoNaoExistente() { // Caso 4
		ListaEstatica lista = new ListaEstatica();
		
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(lista.buscar(30), -1);
		
	}
	
	void testeRetirar() { // Caso 4
		ListaEstatica lista = new ListaEstatica();
		
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
	
		lista.retirar(10);
		
		assertEquals(lista.getTamanho(), 3);
	}
}
