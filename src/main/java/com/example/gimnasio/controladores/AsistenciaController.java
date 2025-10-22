package com.example.gimnasio.controladores;

import com.example.gimnasio.dto.AsistenciaCrearDTO;
import com.example.gimnasio.modelos.Asistencia;
import com.example.gimnasio.servicios.AsistenciaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/asistencia")
public class AsistenciaController {

    private AsistenciaService service;

    @GetMapping("/all")
    public List<Asistencia> obtenerTodas() {
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    public Asistencia obtenerPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/crear")
    public void crear(@RequestBody AsistenciaCrearDTO dto) {
        service.crearAsistencia(dto);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable Integer id, @RequestBody AsistenciaCrearDTO dto) {
        service.editarAsistencia(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminarPorId(id);
    }
}
