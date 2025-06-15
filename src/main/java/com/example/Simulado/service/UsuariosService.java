package com.example.Simulado.service;


import com.example.Simulado.dto.usuario.UsuarioRequestDTO;
import com.example.Simulado.dto.usuario.UsuarioResponseDTO;
import com.example.Simulado.model.UsuarioModel;
import com.example.Simulado.repository.UsuariosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public List<UsuarioResponseDTO> findAll() {
        return usuariosRepository.findAll()
                .stream()
                .map(UsuarioResponseDTO::new)
                .toList();
    }

    UsuarioModel findModelById(Long id) {
        return usuariosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário de id '" + id + "' não encontrado"));
    }

    public UsuarioResponseDTO findById(Long id) {
        UsuarioModel usuarioModel = findModelById(id);
        return new UsuarioResponseDTO(usuarioModel);
    }

    public UsuarioResponseDTO create(UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRequestDTO, usuarioModel);
        usuarioModel.setDataCadastro(LocalDateTime.now());
        UsuarioModel usuarioSalvo = usuariosRepository.save(usuarioModel);

        return new UsuarioResponseDTO(usuarioSalvo);
    }

    public UsuarioResponseDTO update(Long id_usuario, UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioModel usuarioExistente = findModelById(id_usuario);
        BeanUtils.copyProperties(usuarioRequestDTO, usuarioExistente);

        UsuarioModel usuarioSalvo = usuariosRepository.save(usuarioExistente);
        return new UsuarioResponseDTO(usuarioSalvo);
    }

    public UsuarioResponseDTO delete(Long id) {
        UsuarioModel usuarioExistente = findModelById(id);
        usuariosRepository.delete(usuarioExistente);
        return new UsuarioResponseDTO(usuarioExistente);
    }
}
