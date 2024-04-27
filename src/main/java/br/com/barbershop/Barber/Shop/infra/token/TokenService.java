package br.com.barbershop.Barber.Shop.infra.token;

import br.com.barbershop.Barber.Shop.model.Cliente;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Cliente cliente) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("BarberShop")
                    .withSubject(cliente.getTelefone())
                    .withExpiresAt(getDataDeExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Erro ao gerar token", ex);
        }
    }
    public Instant getDataDeExpiracao() {
        return Instant.now().plusSeconds(7200);
    }
    public String getSubject(String token) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("BarberShop")
                    .build()
                    .verify(token).getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token inválido", e);
        }
    }
}
