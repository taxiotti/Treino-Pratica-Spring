package com.example.Simulado.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDTO {

    @NotNull(message = "O nome é obrigatório")
    @NotEmpty(message = "O nome não pode ser vazio")
    @Size(max = 100, min = 2, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotNull(message = "O email é obrigatório")
    @NotEmpty(message = "O email não pode ser vazio")
    @Email(message = "O email deve ser válido")
    @Size(max = 150, message = "O email deve ter no máximo 150 caracteres")
    private String email;
}
