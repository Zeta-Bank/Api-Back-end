package BL3.BackEnd.exception.PixException;

public class ChavePixJaExisteException extends RuntimeException {
    public ChavePixJaExisteException() {
        super("Chave pix já existe");
    }

    public ChavePixJaExisteException(String message) {
        super(message);
    }
}
