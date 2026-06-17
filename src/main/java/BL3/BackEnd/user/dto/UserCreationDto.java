package BL3.BackEnd.user.dto;

public record UserCreationDto(
        String fistName,
        String lastName,
        String email,
        String password
){
}
