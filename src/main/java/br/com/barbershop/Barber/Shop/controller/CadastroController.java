package br.com.barbershop.Barber.Shop.controller;

import br.com.barbershop.Barber.Shop.dto.ClienteDTO;
import br.com.barbershop.Barber.Shop.infra.seguranca.PasswordSecurity;
import br.com.barbershop.Barber.Shop.model.Cliente;
import br.com.barbershop.Barber.Shop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PasswordSecurity passwordSecurity;

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        String senhaCriptografada = passwordSecurity.encode(clienteDTO.senha());
        Cliente cliente = new Cliente(clienteDTO,senhaCriptografada);
        clienteRepository.save(cliente);
    }
}
