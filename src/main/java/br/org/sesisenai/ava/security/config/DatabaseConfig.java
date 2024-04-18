package br.org.sesisenai.ava.security.config;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import br.org.sesisenai.ava.security.ENUM.Authorities;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@AllArgsConstructor
@Configuration
public class DatabaseConfig {

    private final UsuarioRepository usuarioRepository;

    @PostConstruct
    public void init() {
        Usuario usuario = new Usuario();
        usuario.setNome("Kaique");
        usuario.setUsername("kaique222");
        usuario.setPassword(new BCryptPasswordEncoder().encode("kaique222"));
        usuario.setEnabled(true);
        usuario.setAccountNonExpired(true);
        usuario.setAccountNonLocked(true);
        usuario.setCredentialsNonExpired(true);
        usuario.setAuthorities(List.of(Authorities.GET));

        usuarioRepository.save(usuario);
    }

}
