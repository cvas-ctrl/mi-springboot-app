package com.example.gimnasio.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SocioCrearDTO {
    private String nombre;
    private String telefono;
    private String correo;
    private Set<Integer> idsMembresias;
}
