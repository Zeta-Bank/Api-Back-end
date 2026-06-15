package BL3.BackEnd.transferencia.dto;

import java.math.BigDecimal;

public record CreateTransferenciaDTO(
        Integer idRemetente,
        String chavePixDestinario,
        BigDecimal moneyAmount
) {
}
