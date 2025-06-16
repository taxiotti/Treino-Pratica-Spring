package com.example.Simulado.controller;
import com.example.Simulado.dto.tarefa.TarefaRequestDTO;
import com.example.Simulado.dto.tarefa.TarefaResponseDTO;
import com.example.Simulado.service.TarefasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/{tarefa_id}")
    public TarefaResponseDTO getById(@NonNull @PathVariable Long tarefa_id) {
        return tarefasService.findById(tarefa_id);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/{usuario_id}")
    public TarefaResponseDTO create(
            @Valid @RequestBody TarefaRequestDTO tarefa,
            @NonNull @PathVariable Long usuario_id
    ) {
        return tarefasService.create(usuario_id, tarefa);
    }

    @ResponseBody
    @PutMapping("/{tarefa_id}")
    public TarefaResponseDTO update(
            @NonNull @PathVariable Long tarefa_id,
            @Valid @RequestBody TarefaRequestDTO tarefa
    ) {
        return tarefasService.update(tarefa_id, tarefa);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{tarefa_id}")
    public void delete(@NonNull @PathVariable Long tarefa_id) {
        tarefasService.delete(tarefa_id);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping("/{tarefa_id}/concluir")
    public void concluirTarefa(@NonNull @PathVariable Long tarefa_id) {
        tarefasService.concluirTarefa(tarefa_id);
    }

}
