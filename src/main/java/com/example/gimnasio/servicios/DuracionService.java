package com.example.gimnasio.servicios;

import com.example.gimnasio.dto.DuracionCrearDTO;
import com.example.gimnasio.modelos.Duracion;
import com.example.gimnasio.repositorios.IDuracionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DuracionService {

    private IDuracionRepository repository;

    public List<Duracion> buscarTodas() {
        return repository.findAll();
    }

    public Duracion buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void crearDuracion(DuracionCrearDTO dto) {
        Duracion nueva = new Duracion();
        nueva.setNombre(dto.getNombre());
        repository.save(nueva);
    }

    public void editarDuracion(Integer id, DuracionCrearDTO dto) {
        Duracion duracion = repository.findById(id).orElse(null);
        if (duracion != null) {
            duracion.setNombre(dto.getNombre());
            repository.save(duracion);
        }
    }

    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }
}
