package co.edu.uniquindio.unicine.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @OneToOne
    private Silla silla;

    @ToString.Exclude
    @ManyToOne
    private Compra compra;
}
