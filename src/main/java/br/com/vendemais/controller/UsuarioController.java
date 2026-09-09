package br.com.vendemais.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendemais.model.Usuario;
import br.com.vendemais.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private final UsuarioService usuarioService;   

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrar(usuario);
    }

}

