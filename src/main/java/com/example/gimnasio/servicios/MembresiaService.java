package com.example.gimnasio.servicios;

import com.example.gimnasio.dto.MembresiaCrearDTO;
import com.example.gimnasio.modelos.Membresia;
import com.example.gimnasio.modelos.Socio;
import com.example.gimnasio.modelos.TipoMembresia;
import com.example.gimnasio.repositorios.IMembresiaRepository;
import com.example.gimnasio.repositorios.ISocioRepository;
import com.example.gimnasio.repositorios.ITipoMembresiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor


public class MembresiaService {

    private IMembresiaRepository repository; //me da acceso a la tabla `membresia`(instancia)

    private ITipoMembresiaRepository tipoMembresiaRepository;

    private ISocioRepository socioRepository;


    public List<Membresia> buscarTodas(){
        return repository.findAll();
    }

    public Membresia buscarPorId(Integer id){
        Membresia membresia = repository.findById(id).orElse(null);
        return membresia;
    }

    public void crearMembresia(MembresiaCrearDTO dto) {
        Membresia nueva = new Membresia();
        nueva.setFechaInicio(dto.getFechaInicio());
        nueva.setFechaFin(dto.getFechaFin());
        nueva.setEstado(dto.getEstado());

        TipoMembresia tipo = tipoMembresiaRepository.findById(dto.getIdTipoMembresia()).orElse(null);
        nueva.setTipoMembresia(tipo);

        Socio socio = socioRepository.findById(dto.getIdSocio()).orElse(null);
        nueva.setSocio(socio);

        repository.save(nueva);
    }

    public void editarMembresia(Integer id, MembresiaCrearDTO dto) {
        Membresia membresiaNueva = repository.findById(id).orElse(null);
        if (membresiaNueva != null) {
            membresiaNueva.setFechaInicio(dto.getFechaInicio());
            membresiaNueva.setFechaFin(dto.getFechaFin());
            membresiaNueva.setEstado(dto.getEstado());

            TipoMembresia tipo = tipoMembresiaRepository.findById(dto.getIdTipoMembresia()).orElse(null);
            membresiaNueva.setTipoMembresia(tipo);

            Socio socio = socioRepository.findById(dto.getIdSocio()).orElse(null);
            membresiaNueva.setSocio(socio);


            repository.save(membresiaNueva);
        }
    }

    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }

}

