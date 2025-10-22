package com.example.gimnasio.controladores;

import com.example.gimnasio.dto.SocioCrearDTO;
import com.example.gimnasio.modelos.Socio;
import com.example.gimnasio.servicios.SocioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/socio")
public class SocioController {

    private SocioService service;

    @GetMapping("/all")
    public List<Socio> obtenerTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Socio obtenerPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/crear")
    public void crear(@RequestBody SocioCrearDTO dto) {
        service.crearSocio(dto);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable Integer id, @RequestBody SocioCrearDTO dto) {
        service.editarSocio(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminarPorId(id);
    }
}
