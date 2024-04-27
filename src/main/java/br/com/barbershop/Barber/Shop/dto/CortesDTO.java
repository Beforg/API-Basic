package br.com.barbershop.Barber.Shop.dto;

import br.com.barbershop.Barber.Shop.model.Cortes;
import jakarta.validation.constraints.NotNull;

public record CortesDTO(@NotNull String data,
                        @NotNull String clienteNome) {
    public CortesDTO(Cortes cortes) {
        this(cortes.getData(), cortes.getNomeCliente());
    }
}
