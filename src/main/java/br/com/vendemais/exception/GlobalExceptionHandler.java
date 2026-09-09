package br.com.vendemais.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<String> recursoNaoEncontrado(RecursoNaoEncontradoException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EstoqueInsuficienteException.class)
    public ResponseEntity<String> semEstoque(EstoqueInsuficienteException ei){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ei.getMessage());
    }

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<String> regraNegocio(RegraNegocioException rn){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rn.getMessage());
    }

    @ExceptionHandler(VendaNaoPodeSerCanceladaException.class)
    public ResponseEntity<String> vendaNaoPodeSerCancelada(VendaNaoPodeSerCanceladaException vc){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vc.getMessage());
    }


}
