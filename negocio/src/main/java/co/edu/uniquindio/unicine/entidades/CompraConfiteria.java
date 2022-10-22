package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompraConfiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @PositiveOrZero
    private float precioTotal;

    @PositiveOrZero
    private Integer unidades;

    @ToString.Exclude
    @ManyToOne
    private Compra compra;

    @ToString.Exclude
    @ManyToOne
    private Confiteria confiteria;
}
