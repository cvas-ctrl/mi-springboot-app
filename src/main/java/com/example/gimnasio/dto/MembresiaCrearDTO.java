package com.example.gimnasio.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
public class MembresiaCrearDTO {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private Integer idTipoMembresia;
    private Set<Integer> idsSocios;
}
