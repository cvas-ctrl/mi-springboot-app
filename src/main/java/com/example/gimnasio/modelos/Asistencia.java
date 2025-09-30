package com.example.gimnasio.modelos;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "asistencia", catalog = "postgres", schema = "gimnasio")
public class Asistencia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //mapear un atributo de Java con una columna en la base de datos.
    @Column(name = "fecha")
    private LocalDate fecha;


    @Column(name = "dias_semana")
    private Integer diasSemana;


    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio;
}
