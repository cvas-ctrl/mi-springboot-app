package com.example.gimnasio.controladores;

import com.example.gimnasio.dto.TipoMembresiaCrearDTO;
import com.example.gimnasio.modelos.TipoMembresia;
import com.example.gimnasio.servicios.TipoMembresiaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tipo-membresia")
public class TipoMembresiaController {

    private TipoMembresiaService service;

    @GetMapping("/all")
    public List<TipoMembresia> obtenerTodas() {
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    public TipoMembresia obtenerPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/crear")
    public void crear(@RequestBody TipoMembresiaCrearDTO dto) {
        service.crearTipoMembresia(dto);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable Integer id, @RequestBody TipoMembresiaCrearDTO dto) {
        service.editarTipoMembresia(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminarPorId(id);
    }
}
