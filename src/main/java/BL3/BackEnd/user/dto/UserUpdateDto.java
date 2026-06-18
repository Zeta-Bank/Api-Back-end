package BL3.BackEnd.user.dto;

public record UserUpdateDto(
        int id,
        String firstName,
        String lastName,
        String email,
        String password,
        String cpf
){
}
