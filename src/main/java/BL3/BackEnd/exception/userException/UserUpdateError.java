package BL3.BackEnd.exception.userException;

public class UserUpdateError extends RuntimeException{

    public UserUpdateError() {
        super("Erro ao atualizar o usuário, pode ser causado por valores inválidos ou erro do servidor");
    }

    public UserUpdateError(String message) {
        super(message);
    }
}

