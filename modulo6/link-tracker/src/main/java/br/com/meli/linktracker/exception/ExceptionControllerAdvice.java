package br.com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErroDTO> linkNaoEncontrado(NoSuchElementException ex) {
        ErroDTO erroDTO = new ErroDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDTO);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErroDTO> linkNaoPermitido(UnauthorizedException ex) {
        ErroDTO erroDTO = new ErroDTO(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erroDTO);
    }

}
