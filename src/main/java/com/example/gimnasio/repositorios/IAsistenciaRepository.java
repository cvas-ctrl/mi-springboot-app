package com.example.gimnasio.repositorios;

import com.example.gimnasio.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsistenciaRepository extends JpaRepository<Asistencia, Integer> {
}