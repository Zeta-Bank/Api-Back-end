package BL3.BackEnd.exception;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(HttpStatus status, String message) {
}
