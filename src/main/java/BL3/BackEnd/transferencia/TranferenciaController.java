package BL3.BackEnd.transferencia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranferenciaController {

    @GetMapping
    public ResponseEntity getAllByUser(){
        return ResponseEntity.ok().build();
    }


    @PostMapping
    public ResponseEntity createTranferencia(){


        return ResponseEntity.ok().build();
    }
}
