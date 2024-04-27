package br.com.barbershop.Barber.Shop.repository;

import br.com.barbershop.Barber.Shop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByTelefone(String telefone);
}
