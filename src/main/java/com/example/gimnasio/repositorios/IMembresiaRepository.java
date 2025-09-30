package com.example.gimnasio.repositorios;

import com.example.gimnasio.modelos.Membresia;
import com.example.gimnasio.modelos.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IMembresiaRepository extends JpaRepository<Membresia, Integer> {
}


