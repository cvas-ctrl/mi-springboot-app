package com.example.gimnasio;

import com.example.gimnasio.enumerados.NombreDuracion;
import com.example.gimnasio.modelos.Duracion;
import com.example.gimnasio.modelos.Membresia;
import com.example.gimnasio.modelos.Socio;
import com.example.gimnasio.modelos.TipoMembresia;
import com.example.gimnasio.repositorios.IDuracionRepository;
import com.example.gimnasio.repositorios.IMembresiaRepository;
import com.example.gimnasio.repositorios.ITipoMembresiaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.gimnasio.repositorios.ISocioRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class GimnasioApplicationTests {

    @Autowired
    private ISocioRepository socioRepository;

    @Autowired
    private ITipoMembresiaRepository tipoMembresiaRepository;

    @Autowired
    private IDuracionRepository duracionRepository;

    @Autowired
    private IMembresiaRepository membresiaRepository;

    // --- 1️⃣ Crear un socio ---
    @Test
    void crearSocioCompletoTest() {
        System.out.println("--- CREANDO DURACION ---");
        Duracion duracion = new Duracion();
        duracion.setNombre(NombreDuracion.SEMANAL);
        duracionRepository.save(duracion);

        System.out.println("--- CREANDO TIPO DE MEMBRESIA ---");
        TipoMembresia tipo = new TipoMembresia();
        tipo.setPrecio(50.0);
        tipo.setDuracion(duracion);
        tipoMembresiaRepository.save(tipo);

        System.out.println("--- CREANDO SOCIO ---");
        Socio socio = new Socio();
        socio.setNombre("Carla");
        socio.setTelefono("600112233");
        socio.setCorreo("carla@gim.com");
        socioRepository.save(socio);

        System.out.println("--- CREANDO MEMBRESIA PARA CARLA ---");
        Membresia membresia = new Membresia();
        membresia.setNombre("Yoga Octubre");
        membresia.setFechaInicio(LocalDate.of(2025,10,1));
        membresia.setFechaFin(LocalDate.of(2025,10,31));
        membresia.setEstado("ACTIVA");
        membresia.setTipoMembresia(tipo);
        membresia.setSocio(socio);
        membresiaRepository.save(membresia);

        // --- Verificaciones simples ---
        assert(socioRepository.findById(socio.getId()).isPresent());
        assert(membresiaRepository.findById(membresia.getId()).isPresent());
        assert(tipoMembresiaRepository.findById(tipo.getId()).isPresent());
        assert(duracionRepository.findById(duracion.getId()).isPresent());

        System.out.println("Socio '" + socio.getNombre() + "' creado con membresía '"
                + membresia.getNombre() + "', tipo: " + tipo.getId()
                + ", duración: " + duracion.getNombre());
    }

    @Test
    void borrarTodoTest() {
        System.out.println("--- BORRANDO MEMBRESIAS ---");
        membresiaRepository.deleteAll();
        System.out.println("Membresías borradas.");

        System.out.println("--- BORRANDO SOCIOS ---");
        socioRepository.deleteAll();
        System.out.println("Socios borrados.");

        System.out.println("--- BORRANDO TIPOS DE MEMBRESIA ---");
        tipoMembresiaRepository.deleteAll();
        System.out.println("Tipos de membresía borrados.");

        System.out.println("--- BORRANDO DURACIONES ---");
        duracionRepository.deleteAll();
        System.out.println("Duraciones borradas.");

        System.out.println("✅ Todo borrado correctamente.");
    }

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
        nuevoSocio.setNombre("Chino");
        nuevoSocio.setTelefono("611223344");
        nuevoSocio.setCorreo("chino@safa.com");

        socioRepository.save(nuevoSocio);
        System.out.println("Socio '" + nuevoSocio.getNombre() + "' guardado con éxito.");
    }

    @Test
    void editarSocioTest() {
        System.out.println("--- EDITANDO UN SOCIO ---");
        Socio socio = socioRepository.findById(1).orElse(null);

        if (socio != null) {
            socio.setCorreo("nu.correo@example.com");
            socioRepository.save(socio);
            System.out.println("Correo del socio actualizado con éxito.");
        }
    }

    @Test
    void eliminarSocioTest() {
        System.out.println("--- ELIMINANDO ---");
        socioRepository.deleteById(4);
    }

}
