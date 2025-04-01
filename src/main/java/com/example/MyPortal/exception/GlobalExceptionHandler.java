package com.example.MyPortal.exception;

import com.example.MyPortal.exception.throwable.EntityAlreadyExistsException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ResponseEntity<ResponseMessage> handleValidationException(
            MethodArgumentNotValidException exception
    ) {
        String fieldError = Objects.requireNonNull(
                exception.getBindingResult().getFieldError()
        ).getDefaultMessage();
        return new ResponseEntity<>(new ResponseMessage(fieldError), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<Object> exception(EntityAlreadyExistsException exception) {
        return new ResponseEntity<>(new ResponseMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<Object> exception(BadCredentialsException exception) {
        return new ResponseEntity<>(new ResponseMessage(exception.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> exception(HttpRequestMethodNotSupportedException exception) {
        return new ResponseEntity<>(new ResponseMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MalformedJwtException.class)
    public ResponseEntity<Object> exception(MalformedJwtException exception) {
        return new ResponseEntity<>(new ResponseMessage(exception.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
