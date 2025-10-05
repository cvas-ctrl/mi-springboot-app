package com.example.gimnasio.controladores;

import com.example.gimnasio.dto.MembresiaCrearDTO;
import com.example.gimnasio.modelos.Membresia;
import com.example.gimnasio.servicios.MembresiaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/membresia")

public class MembresiaController {

    MembresiaService service;

    @GetMapping("/all")
    public List<Membresia> obtenerTodas(){
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    public Membresia obtenerPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping("/crear")
    public void crearMembresia(@RequestBody MembresiaCrearDTO dto){
        service.crearMembresia(dto);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable Integer id, @RequestBody MembresiaCrearDTO dto) {
        service.editarMembresia(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminarPorId(id);
    }

}