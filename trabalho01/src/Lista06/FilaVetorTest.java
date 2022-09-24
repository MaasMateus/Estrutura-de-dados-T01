package Lista06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class FilaVetorTest {

    @Test
    public void testeException() {

        FilaVetor pilha = new FilaVetor(5);

        try {
            pilha.retirar();
            fail();
        } catch (RuntimeException e) {
        }
    }

}
