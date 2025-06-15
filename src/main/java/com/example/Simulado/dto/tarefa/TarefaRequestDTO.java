package com.example.Simulado.dto.tarefa;

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
    @Size(max = 150)
    private String titulo;

    private String descricao;

    @NotNull
    private Long usuarioId;
}
