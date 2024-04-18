package br.org.sesisenai.ava.security.controller;

import br.org.sesisenai.ava.security.DTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;


    @PostMapping("/auth/login")
    public ResponseEntity<String> auth(@RequestBody DTO userLoginDTO){
        try {
            Authentication authenticationToken =
                    new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(),userLoginDTO.getPassword());

            Authentication authentication = authenticationManager.authenticate(authenticationToken);

//            SecurityContext context = SecurityContextHolder.createEmptyContext();
//            context.setAuthentication(authentication);
//            SecurityContextHolder.setContext(context);
//            securityContextRepository.saveContext(context,request,response);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();


            return ResponseEntity.ok("Autenticação bem-sucedida!");

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação!");
        }
    }

}
