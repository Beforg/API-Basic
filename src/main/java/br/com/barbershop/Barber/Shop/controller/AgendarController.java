package br.com.barbershop.Barber.Shop.controller;

import br.com.barbershop.Barber.Shop.domain.cortes.AgendaConsulta;
import br.com.barbershop.Barber.Shop.dto.CortesDTO;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class AgendarController {

    @Autowired
    private AgendaConsulta agendaConsulta;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@RequestBody @Valid CortesDTO cortesDTO) {
        System.out.println("AgendarController.agendarConsulta");
        var dto = agendaConsulta.agendarCorte(cortesDTO);
        return ResponseEntity.ok(dto);
    }
}
