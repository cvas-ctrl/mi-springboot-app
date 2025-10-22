package com.example.gimnasio.servicios;

import com.example.gimnasio.dto.AsistenciaCrearDTO;
import com.example.gimnasio.modelos.Asistencia;
import com.example.gimnasio.modelos.Socio;
import com.example.gimnasio.repositorios.IAsistenciaRepository;
import com.example.gimnasio.repositorios.ISocioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AsistenciaService {

    private IAsistenciaRepository asistenciaRepository;
    private ISocioRepository socioRepository;

    public List<Asistencia> buscarTodas() {
        return asistenciaRepository.findAll();
    }

    public Asistencia buscarPorId(Integer id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    public void crearAsistencia(AsistenciaCrearDTO dto) {
        Asistencia nueva = new Asistencia();
        nueva.setFecha(dto.getFecha());
        nueva.setDiasSemana(dto.getDiasSemana());

        Socio socio = socioRepository.findById(dto.getIdSocio()).orElse(null);
        nueva.setSocio(socio);

        asistenciaRepository.save(nueva);
    }

    public void editarAsistencia(Integer id, AsistenciaCrearDTO dto) {
        Asistencia asistencia = asistenciaRepository.findById(id).orElse(null);
        if (asistencia != null) {
            asistencia.setFecha(dto.getFecha());
            asistencia.setDiasSemana(dto.getDiasSemana());
            Socio socio = socioRepository.findById(dto.getIdSocio()).orElse(null);
            asistencia.setSocio(socio);
            asistenciaRepository.save(asistencia);
        }
    }

    public void eliminarPorId(Integer id) {
        asistenciaRepository.deleteById(id);
    }
}
