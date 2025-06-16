package com.example.Simulado.exception;

import com.example.Simulado.model.TarefaModel;

public class TarefaAlreadyConcluidaException extends RuntimeException {
    public TarefaAlreadyConcluidaException(TarefaModel tarefa) {
        super(String.format("Tarefa %s já concluída", tarefa));
    }
}
