package BL3.BackEnd.transferencia.dto;

import java.math.BigDecimal;

public record TransferenciaDTO(
    String remetente,
    String destinatario,
    BigDecimal amount
) {

}
