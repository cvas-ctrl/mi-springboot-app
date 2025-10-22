package com.example.gimnasio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AsistenciaCrearDTO {
    private LocalDate fecha;
    private Integer diasSemana;
    private Integer idSocio;
}
