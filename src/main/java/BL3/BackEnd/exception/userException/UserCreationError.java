package BL3.BackEnd.exception.userException;

public class UserCreationError extends RuntimeException{

    public UserCreationError() {
        super("Erro ao criar usuário, pode ser causado por valores inválidos ou erro do servidor");
    }

    public UserCreationError(String message) {
        super(message);
    }
}

