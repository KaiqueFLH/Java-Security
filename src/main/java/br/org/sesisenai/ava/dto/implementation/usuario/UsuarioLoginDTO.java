package br.org.sesisenai.ava.dto.implementation.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioLoginDTO {
    private String username;
    private String password;
}
