package br.org.sesisenai.ava.security.model.entity;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.security.ENUM.Authorities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class UsuarioDetailsEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,updatable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private boolean enabled;
    private Collection<Authorities> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    @OneToOne(mappedBy = "userDetailsENTITY")
    private Usuario user;
}
