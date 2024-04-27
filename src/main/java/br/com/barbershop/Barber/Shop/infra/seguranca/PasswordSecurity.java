package br.com.barbershop.Barber.Shop.infra.seguranca;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordSecurity {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordSecurity() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
