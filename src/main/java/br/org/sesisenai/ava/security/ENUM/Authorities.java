package br.org.sesisenai.ava.security.ENUM;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public enum Authorities implements GrantedAuthority {

    GET("Get"),
    POST("Post"),
    PUT("Put"),
    DELETE("Delete");

    private String name;

    @Override
    public String getAuthority() {
        return name();
    }
}
