package com.example.Simulado.dto.usuario;

import com.example.Simulado.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private LocalDateTime dataCadastro;

    public UsuarioResponseDTO(UsuarioModel usuarioModel) {
        this.id = usuarioModel.getId();
        this.nome = usuarioModel.getNome();
        this.email = usuarioModel.getEmail();
        this.dataCadastro = usuarioModel.getDataCadastro();
    }
}
