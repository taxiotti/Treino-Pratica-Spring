package com.example.Simulado.exception;

import com.example.Simulado.model.TarefaModel;

public class TarefaAlreadyConcluida extends RuntimeException {
    public TarefaAlreadyConcluida(TarefaModel tarefa) {
        super(String.format("Tarefa %s já concluída", tarefa));
    }
}
