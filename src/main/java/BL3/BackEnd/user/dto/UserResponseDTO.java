package BL3.BackEnd.user.dto;
import java.math.BigDecimal;

public record UserResponseDTO(
        int id,
        String firstName,
        String lastName,
        String email
) {
}
