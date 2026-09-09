package br.com.vendemais.service;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import br.com.vendemais.model.Usuario;
import io.jsonwebtoken.Jwts;
@Service 
public class JwtService {

    private  final SecretKey secretKey;

    public  JwtService(){
    this.secretKey = Jwts.SIG.HS256.key().build();
    }
    
    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .signWith(secretKey)
                .compact();
    }

    public String extrairEmail(String token) {
        return Jwts.parser()
             .verifyWith(secretKey)
             .build().parseSignedClaims(token)
             .getPayload()
             .getSubject();
    }
}
