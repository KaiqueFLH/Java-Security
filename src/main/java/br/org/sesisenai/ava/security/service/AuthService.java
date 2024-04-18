package br.org.sesisenai.ava.security.service;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthService implements UserDetailsService {
    private final UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> userOptional = userRepository.findByUserDetailsENTITY_Username(username);

        if (userOptional.isPresent()){
            return userOptional.get().getUserDetailsENTITY();
        }
        else throw new UsernameNotFoundException("Dados Inválidos!!");
    }
}
