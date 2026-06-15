package BL3.BackEnd.exception.userException;

public class UserNotExistsException extends RuntimeException {
    public UserNotExistsException() {
        super("Usuário não encontrado");
    }

    public UserNotExistsException(String message) {
        super(message);
    }
}
