package BL3.BackEnd.exception.PixException;

public class ChavePixNaoEncontradaException extends RuntimeException{
    public ChavePixNaoEncontradaException() {
        super("Chave pix não encontrada");
    }

    public ChavePixNaoEncontradaException(String message) {
        super(message);
    }
}
