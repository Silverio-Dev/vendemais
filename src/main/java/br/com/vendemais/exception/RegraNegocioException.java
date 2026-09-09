package br.com.vendemais.exception;

public class RegraNegocioException extends RuntimeException{
    
    public RegraNegocioException(String mensagem) {
        super(mensagem);
    }
}
