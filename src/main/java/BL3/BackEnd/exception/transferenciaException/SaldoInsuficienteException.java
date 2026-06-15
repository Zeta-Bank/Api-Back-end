package BL3.BackEnd.exception.transferenciaException;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException() {
        super("Saldo insuficiente");
    }

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
