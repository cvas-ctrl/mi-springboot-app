package com.example.gimnasio.repositorios;

import com.example.gimnasio.modelos.Duracion;
import com.example.gimnasio.modelos.TipoMembresia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDuracionRepository extends JpaRepository<Duracion, Integer> {
}
