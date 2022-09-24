package Lista05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaVetorTest {

    @Test
    public void testeException() {

        PilhaVetor pilha = new PilhaVetor(15);

        try {
            pilha.pop();
            fail();
        } catch (PilhaVaziaException e) {
        }
    }

    @Test
    public void testeConcatenar() {
        PilhaVetor<Integer> p1 = new PilhaVetor(3);

        PilhaVetor<Integer> p2 = new PilhaVetor(2);

        p1.push(1);
        p2.push(2);
        p2.push(3);

        p1.concatenar(p2);

        assertEquals(p1.toString(), "1,2,3");
    }
}
