package com.example.Simulado.dto.tarefa;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaRequestDTO {

    @NotNull(message = "A tarefa precisa de um título")
    @NotEmpty(message = "O título não pode ser vazio")
    @Size(max = 150, message = "O título deve ter no máximo 150 caracteres")
    private String titulo;

    @NotEmpty(message = "A descrição não pode ser vazia")
    private String descricao;
}
