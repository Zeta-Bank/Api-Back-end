package BL3.BackEnd.exception.transferenciaException;

public class UserHaventTranferenciasException extends RuntimeException{
    public UserHaventTranferenciasException() {
        super("Usuário não possuí transferências ");
    }

    public UserHaventTranferenciasException(String message) {
        super(message);
    }
}
