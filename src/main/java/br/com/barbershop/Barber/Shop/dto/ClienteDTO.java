package br.com.barbershop.Barber.Shop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



public record ClienteDTO(@NotBlank
                         String nome,
                         @NotBlank
                         String telefone,
                         @NotBlank
                         String senha)  {

}
