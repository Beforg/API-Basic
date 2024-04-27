package br.com.barbershop.Barber.Shop.controller;

import br.com.barbershop.Barber.Shop.dto.LoginDTO;
import br.com.barbershop.Barber.Shop.infra.token.TokenJWT;
import br.com.barbershop.Barber.Shop.infra.token.TokenService;
import br.com.barbershop.Barber.Shop.model.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping

    public ResponseEntity fazerLogin(@RequestBody @Valid LoginDTO loginDTO) {
        var autenticacaoDoToken = new UsernamePasswordAuthenticationToken(loginDTO.telefone(), loginDTO.senha());
        var autenticacao = authenticationManager.authenticate(autenticacaoDoToken);

        var tokenJWT = tokenService.gerarToken((Cliente )autenticacao.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}
