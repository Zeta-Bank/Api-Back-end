package BL3.BackEnd.Advice;

import BL3.BackEnd.exception.userException.UserAlreadyExistsException;
import BL3.BackEnd.exception.userException.UserExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionAdvice {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity userAlreadyExistException(RuntimeException exception){
        UserExceptionResponse response = new UserExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }



}
