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

@Tag(name = "Transferências", description = "Operações de tranferências via pix.")

@RestController
@RequestMapping("/transferencia")
// isso aqui em baixo serve por ser um projeto local
@CrossOrigin(origins = "*")
public class TransferenciaController {

    private TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @Operation(summary = "Retornar todo o historico de transferências de um usuário.")
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
        @ApiResponse(responseCode = "201", description = "Transferência realizada sem problemas."),
        @ApiResponse(responseCode = "400", description = "Erro ao fazer transferências, como saldo insuficiente por exemplo.")
    })
    @PostMapping
    public ResponseEntity createTranferencia(@RequestBody CreateTransferenciaDTO dto){
        transferenciaService.makeTransferencia(dto);

        return ResponseEntity.ok().build();
    }
}
