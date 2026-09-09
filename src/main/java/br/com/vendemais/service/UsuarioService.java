package br.com.vendemais.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vendemais.dto.request.LoginRequest;
import br.com.vendemais.dto.response.LoginResponse;
import br.com.vendemais.model.Usuario;
import br.com.vendemais.repository.UsuarioRepository;


@Service
public class UsuarioService {
    
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }

    public Usuario cadastrar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public LoginResponse autenticar(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }
        LoginResponse response = new LoginResponse();
        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setToken(jwtService.gerarToken(usuario));

        return response;
      
    }
}
