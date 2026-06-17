package BL3.BackEnd.transferencia;

import BL3.BackEnd.transferencia.dto.CreateTransferenciaDTO;
import BL3.BackEnd.transferencia.dto.TransferenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    private TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping("{userId}")
    public ResponseEntity getAllByUser(@PathVariable int userId){
        List<TransferenciaDTO> response = transferenciaService.getAllByUser(userId);
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity createTranferencia(@RequestBody CreateTransferenciaDTO dto){
        transferenciaService.makeTransferencia(dto);

        return ResponseEntity.ok().build();
    }
}
