package com.example.Simulado.repository;

import com.example.Simulado.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<UsuarioModel, Long> {
}
