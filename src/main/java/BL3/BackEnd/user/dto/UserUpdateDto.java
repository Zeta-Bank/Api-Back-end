package BL3.BackEnd.user.dto;

public record UserUpdateDto(
        int id,
        String fistName,
        String lastName,
        String email,
        String password
){
}
