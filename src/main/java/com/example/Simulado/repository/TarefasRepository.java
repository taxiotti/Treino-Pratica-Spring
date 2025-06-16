package com.example.Simulado.repository;

import com.example.Simulado.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<TarefaModel, Long> {
}
