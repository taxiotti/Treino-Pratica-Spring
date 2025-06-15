package com.example.Simulado.service;


import com.example.Simulado.model.Usuarios;
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

    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    public Usuarios findById(Long id) {
        return usuariosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Usuarios save(String nome, String email) {
        Usuarios usuarios = new Usuarios();
        usuarios.setNome(nome);
        usuarios.setEmail(email);
        usuarios.setDataCadastro(LocalDateTime.now());
        usuarios.setTarefas(null);
        return usuariosRepository.save(usuarios);
    }

    public Usuarios update(Long id, Usuarios usuarios) {
        Usuarios usuarioExistente = findById(id);
        usuarioExistente.setNome(usuarios.getNome());
        usuarioExistente.setEmail(usuarios.getEmail());
        usuarioExistente.setTarefas(usuarios.getTarefas());

        return usuariosRepository.save(usuarioExistente);
    }

    public Usuarios delete(Long id) {
        Usuarios usuarioExistente = findById(id);
        usuariosRepository.delete(usuarioExistente);
        return usuarioExistente;
    }
}
