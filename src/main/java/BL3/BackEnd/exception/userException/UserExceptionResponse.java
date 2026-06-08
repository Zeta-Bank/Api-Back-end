package BL3.BackEnd.exception.userException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

public record UserExceptionResponse(HttpStatus status, String message) {
}
