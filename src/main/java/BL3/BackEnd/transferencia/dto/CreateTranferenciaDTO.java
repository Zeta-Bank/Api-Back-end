package BL3.BackEnd.transferencia.dto;

import java.math.BigDecimal;

public record CreateTranferenciaDTO (
        int idRemetente,
        String chavePixDestinario,
        BigDecimal amount
) {
}
