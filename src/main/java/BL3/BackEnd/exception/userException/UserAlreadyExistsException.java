package BL3.BackEnd.exception.userException;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {
        super("Essa conta já existe.");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
