package trabalho1;

import java.security.InvalidParameterException;

public class SintaxeInvalidaException extends RuntimeException {

    public SintaxeInvalidaException(String msg) {
        super(msg);
    }
}
