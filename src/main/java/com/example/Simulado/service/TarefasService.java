package com.example.Simulado.service;

import com.example.Simulado.exception.TarefaAlreadyConcluida;
import com.example.Simulado.model.Tarefas;
import com.example.Simulado.repository.TarefasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {
    private final TarefasRepository tarefasRepository;

    public TarefasService(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    public List<Tarefas> getAll(){
        return tarefasRepository.findAll();
    }

    public Tarefas getById(long id) {
        return tarefasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
    }

    public Tarefas create(Tarefas tarefa) {
        // Verificar se o usuário da tarefa existe
        if (tarefa.getUsuario() == null) {
            throw new IllegalArgumentException("O usuário da tarefa não pode ser nulo");
        }

        return tarefasRepository.save(tarefa);
    }

    public Tarefas update(Tarefas tarefa) {
        return tarefasRepository.save(tarefa);
    }

    public Tarefas delete(long id) {
        Tarefas tarefa = getById(id);
        tarefasRepository.delete(tarefa);
        return tarefa;
    }

    public void concluirTarefa(long id) {
        Tarefas tarefa = getById(id);
        if (tarefa.getConcluida()) {
            throw new TarefaAlreadyConcluida(tarefa);
        }
        tarefa.setConcluida(true);
        tarefasRepository.save(tarefa);
    }
}
