package com.example.Simulado.controller;

import com.example.Simulado.dto.usuario.UsuarioRequestDTO;
import com.example.Simulado.dto.usuario.UsuarioResponseDTO;
import com.example.Simulado.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @ResponseBody
    @GetMapping
    public List<UsuarioResponseDTO> findAll() {
        return usuariosService.findAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public UsuarioResponseDTO findById(@PathVariable Long id) {
        return usuariosService.findById(id);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public UsuarioResponseDTO save(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuariosService.create(usuarioRequestDTO);
    }

    @ResponseBody
    @PutMapping("/{id_usuario}")
    public UsuarioResponseDTO update(@PathVariable Long id_usuario,
                                     @Valid @RequestBody UsuarioRequestDTO usuarioModel) {
        return usuariosService.update(id_usuario, usuarioModel);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuariosService.delete(id);
    }
}
