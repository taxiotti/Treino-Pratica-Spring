package com.example.Simulado.controller;

import com.example.Simulado.model.Usuarios;
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
    public List<Usuarios> findAll() {
        return usuariosService.findAll();
    }

    @GetMapping("/{id}")
    public Usuarios findById(@PathVariable Long id) {
        return usuariosService.findById(id);
    }

    @PostMapping
    public Usuarios save(@RequestParam String nome, @RequestParam String email) {
        return usuariosService.save(nome, email);
    }

    @PutMapping("/{id}")
    public Usuarios update(@PathVariable Long id, @RequestBody Usuarios usuarios) {
        return usuariosService.update(id, usuarios);
    }

    @DeleteMapping("/{id}")
    public Usuarios delete(@PathVariable Long id) {
        return usuariosService.delete(id);
    }
}
