package br.com.barbershop.Barber.Shop.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank
                       String telefone,
                       @NotBlank
                       String senha) {
}
