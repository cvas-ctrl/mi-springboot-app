package com.example.gimnasio.repositorios;
import org.springframework.stereotype.Repository;
import com.example.gimnasio.modelos.TipoMembresia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoMembresiaRepository extends JpaRepository<TipoMembresia, Integer> {
}