package br.com.barbershop.Barber.Shop.model;

import br.com.barbershop.Barber.Shop.dto.CortesDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Cortes")
@Table(name = "cortes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cortes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    private String nomeCliente;

    public Cortes(CortesDTO cortesDTO, String cliente) {
        this.data = cortesDTO.data();
        this.nomeCliente = cliente;
    }

}
