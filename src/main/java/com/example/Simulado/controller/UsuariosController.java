package com.example.Simulado.controller;

import com.example.Simulado.model.UsuarioModel;
import com.example.Simulado.service.UsuariosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<UsuarioModel> findAll() {
        return usuariosService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioModel findById(@PathVariable Long id) {
        return usuariosService.findById(id);
    }

    @PostMapping
    public UsuarioModel save(@RequestParam String nome, @RequestParam String email) {
        return usuariosService.save(nome, email);
    }

    @PutMapping("/{id}")
    public UsuarioModel update(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        return usuariosService.update(id, usuarioModel);
    }

    @DeleteMapping("/{id}")
    public UsuarioModel delete(@PathVariable Long id) {
        return usuariosService.delete(id);
    }
}
