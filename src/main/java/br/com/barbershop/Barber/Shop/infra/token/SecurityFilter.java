package br.com.barbershop.Barber.Shop.infra.token;

import br.com.barbershop.Barber.Shop.repository.ClienteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = getToken(request);
        if (tokenJWT != null) {
            var  subject = tokenService.getSubject(tokenJWT);
            var cliente = clienteRepository.findByTelefone(subject);
            var authentication = new UsernamePasswordAuthenticationToken(cliente, null, cliente.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);

    }
    private String getToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null) {
            return authorization.replace("Bearer ", "");
        }
        return null;
    }
}
