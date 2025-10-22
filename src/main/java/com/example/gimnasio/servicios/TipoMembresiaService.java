package com.example.gimnasio.servicios;

import com.example.gimnasio.dto.TipoMembresiaCrearDTO;
import com.example.gimnasio.modelos.Duracion;
import com.example.gimnasio.modelos.TipoMembresia;
import com.example.gimnasio.repositorios.IDuracionRepository;
import com.example.gimnasio.repositorios.ITipoMembresiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoMembresiaService {

    private ITipoMembresiaRepository repository;
    private IDuracionRepository duracionRepository;

    public List<TipoMembresia> buscarTodas() {
        return repository.findAll();
    }

    public TipoMembresia buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void crearTipoMembresia(TipoMembresiaCrearDTO dto) {
        TipoMembresia nuevo = new TipoMembresia();
        nuevo.setPrecio(dto.getPrecio());
        Duracion duracion = duracionRepository.findById(dto.getIdDuracion()).orElse(null);
        nuevo.setDuracion(duracion);
        repository.save(nuevo);
    }

    public void editarTipoMembresia(Integer id, TipoMembresiaCrearDTO dto) {
        TipoMembresia tipo = repository.findById(id).orElse(null);
        if (tipo != null) {
            tipo.setPrecio(dto.getPrecio());
            Duracion duracion = duracionRepository.findById(dto.getIdDuracion()).orElse(null);
            tipo.setDuracion(duracion);
            repository.save(tipo);
        }
    }

    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }
}
