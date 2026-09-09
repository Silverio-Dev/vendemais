package br.com.vendemais.exception;

public class VendaNaoPodeSerCanceladaException extends RuntimeException{
    
    public VendaNaoPodeSerCanceladaException(String mensagem) {
        super(mensagem);
    }
}
