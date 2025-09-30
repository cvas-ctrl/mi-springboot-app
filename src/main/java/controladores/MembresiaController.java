package controladores;

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
    public List<Membresia> obtenerTodasMembresias(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Membresia obtenerPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping("/{crear}")
    public void crearMembresia(@RequestBody MembresiaCrearDTO dto){
        service.crearMembresia(dto);
    }

//    @PutMapping("/{editar/id}")
//    public void editarMembresia(@PathVariable Integer id,@RequestBody MembresiaEditarDTO dto){
//        service.editarMembresia(id,dto);
//    }

//    @DeleteMapping("/{eliminar}")
//    public void eliminarMembresia(@RequestBody MembresiaEliminarDTO dto){
//        service.eliminarMembresia(dto);
//    }

}