package com.example.gimnasio.controladores;

import com.example.gimnasio.dto.DuracionCrearDTO;
import com.example.gimnasio.modelos.Duracion;
import com.example.gimnasio.servicios.DuracionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/duracion")
public class DuracionController {

    private DuracionService service;

    @GetMapping("/all")
    public List<Duracion> obtenerTodas() {
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    public Duracion obtenerPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/crear")
    public void crear(@RequestBody DuracionCrearDTO dto) {
        service.crearDuracion(dto);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable Integer id, @RequestBody DuracionCrearDTO dto) {
        service.editarDuracion(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminarPorId(id);
    }
}
