package Lista06;

import Lista05.PilhaVaziaException;
import Lista05.PilhaVetor;
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
