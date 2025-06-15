package com.example.Simulado.dto.tarefa;

import com.example.Simulado.model.TarefaModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean concluida;
    private Long usuarioId;

    public TarefaResponseDTO(TarefaModel tarefaModel) {
        this.id = tarefaModel.getId();
        this.titulo = tarefaModel.getTitulo();
        this.descricao = tarefaModel.getDescricao();
        this.concluida = tarefaModel.getConcluida();
        this.usuarioId = tarefaModel.getUsuario().getId();
    }
}