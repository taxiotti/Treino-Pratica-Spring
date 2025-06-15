package com.example.Simulado.exception;

import com.example.Simulado.model.Tarefas;

public class TarefaAlreadyConcluida extends RuntimeException {
    public TarefaAlreadyConcluida(Tarefas tarefa) {
        super(String.format("Tarefa %s já concluída", tarefa));
    }
}
