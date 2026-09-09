package br.com.vendemais.exception;

public class EstoqueInsuficienteException extends RuntimeException {
    public EstoqueInsuficienteException(String mensagem){
        super(mensagem);

    }
}