package com.example.Simulado.service;

import com.example.Simulado.dto.tarefa.TarefaRequestDTO;
import com.example.Simulado.dto.tarefa.TarefaResponseDTO;
import com.example.Simulado.exception.TarefaAlreadyConcluida;
import com.example.Simulado.model.TarefaModel;
import com.example.Simulado.repository.TarefasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final UsuariosService usuariosService;

    public TarefasService(TarefasRepository tarefasRepository,  UsuariosService usuariosService) {
        this.tarefasRepository = tarefasRepository;
        this.usuariosService = usuariosService;
    }

    public List<TarefaResponseDTO> getAll() {
        List<TarefaModel> tarefas = tarefasRepository.findAll();

        return tarefas.stream()
                .map(TarefaResponseDTO::new)
                .collect(Collectors.toList());
    }

    private TarefaModel getModelById(@NonNull Long id) {
        return tarefasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
    }

    public TarefaResponseDTO findById(@NonNull Long id) {
        TarefaModel tarefa = getModelById(id);
        return new TarefaResponseDTO(tarefa);
    }


    public TarefaResponseDTO create(Long usuarioId, TarefaRequestDTO tarefa) {
        TarefaModel tarefaModel = new TarefaModel();
        BeanUtils.copyProperties(tarefa, tarefaModel, "id");
        tarefaModel.setConcluida(false);

        mapRelations(tarefaModel, usuarioId);

        TarefaModel tarefaSalva = tarefasRepository.save(tarefaModel);
        return new TarefaResponseDTO(tarefaSalva);
    }

    public TarefaResponseDTO update(Long id, TarefaRequestDTO tarefa) {
        TarefaModel tarefaExistente = getModelById(id);
        BeanUtils.copyProperties(tarefa, tarefaExistente, "id");
        TarefaModel tarefaSalva = tarefasRepository.save(tarefaExistente);
        return new TarefaResponseDTO(tarefaSalva);
    }

    public TarefaResponseDTO delete(@NonNull Long id) {
        TarefaModel tarefa = getModelById(id);
        tarefasRepository.delete(tarefa);
        return new TarefaResponseDTO(tarefa);
    }

    public void concluirTarefa(@NonNull Long id) {
        TarefaModel tarefa = getModelById(id);
        if (tarefa.getConcluida()) {
            throw new TarefaAlreadyConcluida(tarefa);
        }
        tarefa.setConcluida(true);
        tarefasRepository.save(tarefa);
    }

    public void mapRelations(TarefaModel tarefaModel, Long usuarioId) {
        tarefaModel.setUsuario(this.usuariosService.findModelById(usuarioId));
    }

}
