package BL3.BackEnd.exception.advice;

import BL3.BackEnd.exception.ExceptionResponse;
import BL3.BackEnd.exception.userException.UserAlreadyExistsException;
import BL3.BackEnd.exception.userException.UserNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionAdvice {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity userAlreadyExistException(RuntimeException exception){
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(UserNotExistsException.class)
    public ResponseEntity userNotExists(RuntimeException exception){
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
