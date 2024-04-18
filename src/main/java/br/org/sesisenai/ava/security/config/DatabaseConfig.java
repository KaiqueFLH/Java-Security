package br.org.sesisenai.ava.security.config;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import br.org.sesisenai.ava.security.ENUM.Authorities;
import br.org.sesisenai.ava.security.model.entity.UsuarioDetailsEntity;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@AllArgsConstructor
public class DatabaseConfig {

    private final UsuarioRepository usuarioRepository;

    @PostConstruct
    public void init(){
        Usuario user = new Usuario();
        user.setNome("TESTE");
        user.setUserDetailsENTITY(
                UsuarioDetailsEntity.builder()
                        .user(user)
                        .enabled(true)
                        .accountNonExpired(true)
                        .accountNonLocked(true).credentialsNonExpired(true)
                        .username("kaique1222")
                        .password(new BCryptPasswordEncoder().encode("kaique1222"))
                        .authorities(List.of(Authorities.GET))
                        .build());
        usuarioRepository.save(user);
    }
}
