package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ToString.Exclude
    @ManyToOne
    private Sala sala;

    @ToString.Exclude
    @ManyToOne
    private Horario horario;

    @ToString.Exclude
    @ManyToOne
    private Pelicula pelicula;

    @OneToMany(mappedBy = "funcion")
    private List<Compra> compras;
}
