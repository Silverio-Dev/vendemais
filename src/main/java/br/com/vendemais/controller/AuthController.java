package br.com.vendemais.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendemais.dto.request.LoginRequest;
import br.com.vendemais.dto.response.LoginResponse;
import br.com.vendemais.service.UsuarioService;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;    
  
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return usuarioService.autenticar(request);
      
    }

    
}
