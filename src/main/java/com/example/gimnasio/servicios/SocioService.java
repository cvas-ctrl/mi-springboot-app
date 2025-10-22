package com.example.gimnasio.servicios;

import com.example.gimnasio.dto.SocioCrearDTO;
import com.example.gimnasio.modelos.Membresia;
import com.example.gimnasio.modelos.Socio;
import com.example.gimnasio.repositorios.IMembresiaRepository;
import com.example.gimnasio.repositorios.ISocioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SocioService {

    private ISocioRepository socioRepository;
    private IMembresiaRepository membresiaRepository;

    public List<Socio> buscarTodos() {
        return socioRepository.findAll();
    }

    public Socio buscarPorId(Integer id) {
        return socioRepository.findById(id).orElse(null);
    }

    public void crearSocio(SocioCrearDTO dto) {
        Socio nuevo = new Socio();
        nuevo.setNombre(dto.getNombre());
        nuevo.setTelefono(dto.getTelefono());
        nuevo.setCorreo(dto.getCorreo());

        Set<Membresia> membresias = new HashSet<>(membresiaRepository.findAllById(dto.getIdsMembresias()));
        nuevo.setMembresias(membresias);

        socioRepository.save(nuevo);
    }

    public void editarSocio(Integer id, SocioCrearDTO dto) {
        Socio socio = socioRepository.findById(id).orElse(null);
        if (socio != null) {
            socio.setNombre(dto.getNombre());
            socio.setTelefono(dto.getTelefono());
            socio.setCorreo(dto.getCorreo());
            Set<Membresia> membresias = new HashSet<>(membresiaRepository.findAllById(dto.getIdsMembresias()));
            socio.setMembresias(membresias);
            socioRepository.save(socio);
        }
    }

    public void eliminarPorId(Integer id) {
        socioRepository.deleteById(id);
    }
}
