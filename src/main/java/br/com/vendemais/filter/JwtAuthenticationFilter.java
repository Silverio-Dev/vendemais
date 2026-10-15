package br.com.vendemais.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.vendemais.model.Usuario;
import br.com.vendemais.repository.UsuarioRepository;
import br.com.vendemais.service.JwtService;
import java.util.Collections;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
 
    public JwtAuthenticationFilter(JwtService jwtService, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override 
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
            throws ServletException, IOException {
      String authHeader = request.getHeader("Authorization");
      if(request.getServletPath().startsWith("/auth/")) {
          filterChain.doFilter(request, response);
          return;
      }
      String token = authHeader.substring(7);
      System.out.println("Token recebido: " + !token.isBlank());
      String email = jwtService.extrairEmail(token);
      Usuario usuario = usuarioRepository.findByEmail(email)
              .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        

      UsernamePasswordAuthenticationToken authentication =
       new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("Autenticado: " + SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        filterChain.doFilter(request, response);
      
    }
}
