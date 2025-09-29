package com.example.gimnasio;

import com.example.gimnasio.modelos.Socio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.gimnasio.repositorios.ISocioRepository;

import java.util.List;

@SpringBootTest
class GimnasioApplicationTests {

    @Autowired
    ISocioRepository socioRepository;

    @Test
    void contextLoads() {

        List<Socio> socios = socioRepository.findAll();
        for (Socio socio : socios) {
            System.out.println(socio.getNombre());
        }

    }

}
