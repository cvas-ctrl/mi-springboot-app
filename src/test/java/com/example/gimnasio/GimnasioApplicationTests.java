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
    void consultarTodosSocios() {

        List<Socio> socios = socioRepository.findAll();
        for (Socio socio : socios) {
            System.out.println(socio.getNombre());
        }

    }

    @Test
    void crearSocioTest() {
        System.out.println("--- CREANDO UN NUEVO SOCIO ---");
        Socio nuevoSocio = new Socio();
        nuevoSocio.setNombre("Carla Rodriguez AAAA");
        nuevoSocio.setTelefono("611223344");
        nuevoSocio.setCorreo("carla.r@example.com");

        socioRepository.save(nuevoSocio);
        System.out.println("Socio '" + nuevoSocio.getNombre() + "' guardado con éxito.");
    }

    @Test
    void editarSocioTest() {
        System.out.println("--- EDITANDO UN SOCIO ---");
        Socio socio = socioRepository.findById(1).orElse(null);

        if (socio != null) {
            socio.setCorreo("nuevo.correo@example.com");
            socioRepository.save(socio);
            System.out.println("Correo del socio actualizado con éxito.");
        }
    }

    @Test
    void eliminarSocioTest() {
        System.out.println("--- ELIMINANDO ---");
        socioRepository.deleteById(2);
    }

}
