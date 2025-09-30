package com.example.gimnasio.modelos;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "duracion", catalog = "postgres", schema = "gimnasio")
public class Duracion{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    @Enumerated(EnumType.ORDINAL)
    private NombreDuracion nombre;

}