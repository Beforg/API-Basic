package br.com.barbershop.Barber.Shop.domain.cortes;


import br.com.barbershop.Barber.Shop.dto.CortesDTO;
import br.com.barbershop.Barber.Shop.model.Cortes;
import br.com.barbershop.Barber.Shop.repository.CortesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaConsulta {
    @Autowired
    private CortesRepository cortesRepository;
    public CortesDTO agendarCorte(CortesDTO cortesDTO) {
        if (cortesDTO.data() == null) {
            throw new IllegalArgumentException("Data não pode ser nula");
        }

        System.out.println("Passou mdas validaceos");
        var corte = new Cortes(cortesDTO, "Teste");
        cortesRepository.save(corte);
        return new CortesDTO(corte);
    }
}
