package com.example.Simulado.controller;
import com.example.Simulado.dto.tarefa.TarefaRequestDTO;
import com.example.Simulado.dto.tarefa.TarefaResponseDTO;
import com.example.Simulado.model.TarefaModel;
import com.example.Simulado.service.TarefasService;
import jakarta.validation.Valid;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @ResponseBody
    @GetMapping("/")
    public List<TarefaResponseDTO> getAll() {
        return tarefasService.getAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public TarefaResponseDTO getById(@NonNull Long id) {
        return tarefasService.getById(id);
    }

    @ResponseBody
    @PostMapping("/")
    public TarefaResponseDTO create(@Valid TarefaRequestDTO tarefa) {
        return tarefasService.create(tarefa);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public TarefaModel update(
            @NonNull Long id,
            @Valid TarefaRequestDTO tarefa
    ) {
        return tarefasService.update(id, tarefa);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public TarefaModel delete(@NonNull Long id) {
        return tarefasService.delete(id);
    }

    @ResponseBody
    @PatchMapping("/{id}/concluir")
    public void concluirTarefa(@NonNull Long id) {
        tarefasService.concluirTarefa(id);
    }

}
