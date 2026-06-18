package BL3.BackEnd.user.dto;

public record UserCreationDto(
        String firstName,
        String lastName,
        String email,
        String password,
        String cpf
){
}
