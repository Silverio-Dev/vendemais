    package br.com.vendemais.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vendemais.model.Usuario;
import br.com.vendemais.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}


