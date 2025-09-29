package modelos;


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


    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;


    @Column(name = "fecha_fin")
    private LocalDate fechaFin;


    @Column(name = "estado", length = 20)
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_socio", referencedColumnName = "id")
    private Socio socio;


    @ManyToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    private TipoMembresia tipoMembresia;
}
