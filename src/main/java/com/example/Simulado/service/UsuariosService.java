package com.example.Simulado.service;


import com.example.Simulado.model.UsuarioModel;
import com.example.Simulado.repository.UsuariosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public List<UsuarioModel> findAll() {
        return usuariosRepository.findAll();
    }

    public UsuarioModel findById(Long id) {
        return usuariosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public UsuarioModel save(String nome, String email) {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(nome);
        usuarioModel.setEmail(email);
        usuarioModel.setDataCadastro(LocalDateTime.now());
        usuarioModel.setTarefas(null);
        return usuariosRepository.save(usuarioModel);
    }

    public UsuarioModel update(Long id, UsuarioModel usuarioModel) {
        UsuarioModel usuarioExistente = findById(id);
        usuarioExistente.setNome(usuarioModel.getNome());
        usuarioExistente.setEmail(usuarioModel.getEmail());
        usuarioExistente.setTarefas(usuarioModel.getTarefas());

        return usuariosRepository.save(usuarioExistente);
    }

    public UsuarioModel delete(Long id) {
        UsuarioModel usuarioExistente = findById(id);
        usuariosRepository.delete(usuarioExistente);
        return usuarioExistente;
    }
}
