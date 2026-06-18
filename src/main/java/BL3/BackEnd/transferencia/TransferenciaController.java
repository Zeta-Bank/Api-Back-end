package BL3.BackEnd.transferencia;

import BL3.BackEnd.transferencia.dto.CreateTransferenciaDTO;
import BL3.BackEnd.transferencia.dto.TransferenciaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tranferências", description = "Operações de tranferências via pix.")

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    private TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retornar todas as transferências do usuário solicitado"),
            @ApiResponse(responseCode = "400", description = "Usuário não existe, não encontrado e/ou não possuí transferências")
    })
    @GetMapping("{userId}")
    public ResponseEntity getAllByUser(
        @Parameter(description = "Id do usuário.") @PathVariable int userId
    ){
        List<TransferenciaDTO> response = transferenciaService.getAllByUser(userId);
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Realiza uma transferência via pix",
            description = "Debita do remetente e credita no destinatário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Transferência realizada sem problemas.")
    })
    @PostMapping
    public ResponseEntity createTranferencia(@RequestBody CreateTransferenciaDTO dto){
        transferenciaService.makeTransferencia(dto);

        return ResponseEntity.ok().build();
    }
}
