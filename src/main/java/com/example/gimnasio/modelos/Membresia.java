package com.example.gimnasio.modelos;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "membresia", catalog = "postgres", schema = "gimnasio")
public class Membresia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;


    @Column(name = "fecha_fin")
    private LocalDate fechaFin;


    @Column(name = "estado")
    private String estado;

    @ManyToMany(mappedBy = "membresias")
    private Set<Socio> socios = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_tipo_membresia")
    private TipoMembresia tipoMembresia;
}
