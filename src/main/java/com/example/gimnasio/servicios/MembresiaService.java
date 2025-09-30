package com.example.gimnasio.servicios;

import com.example.gimnasio.dto.MembresiaCrearDTO;
import com.example.gimnasio.modelos.Membresia;
import com.example.gimnasio.repositorios.IMembresiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor


public class MembresiaService {

    private IMembresiaRepository repository;



    public List<Membresia> buscarTodos(){
        return repository.findAll();
    }

    public Membresia buscarPorId(Integer id){
        Membresia membresia = repository.findById(id).orElse(null);
        return membresia;
    }

    public void crearMembresia(MembresiaCrearDTO dto){

        Membresia membresiaNueva = new Membresia();
        //membresiaNueva.setFechaInicio(dto.getFechaInicio());


    }

}

