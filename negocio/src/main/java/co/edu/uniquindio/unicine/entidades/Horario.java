package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 50)
    private String dia;

    @Positive
    @Column(nullable = false)
    private String hora;

    private LocalDate inicio;
    private LocalDate fin;

    @OneToMany(mappedBy = "horario")
    private List<Funcion> funciones;

    public Horario(String dia, String hora, LocalDate inicio, LocalDate fin) {
        this.dia = dia;
        this.hora = hora;
        this.inicio = inicio;
        this.fin = fin;
    }

}
