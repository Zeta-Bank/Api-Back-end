package BL3.BackEnd.exception.advice;

import BL3.BackEnd.exception.ExceptionResponse;
import BL3.BackEnd.exception.transferenciaException.SaldoInsuficienteException;
import BL3.BackEnd.exception.transferenciaException.UserHaventTranferenciasException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransferenciaExceptionAdvice {

    @ExceptionHandler(UserHaventTranferenciasException.class)
    public ResponseEntity userNaoTemTranferencias(RuntimeException exception){
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity SaldoInsuficiente(RuntimeException exception){
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
