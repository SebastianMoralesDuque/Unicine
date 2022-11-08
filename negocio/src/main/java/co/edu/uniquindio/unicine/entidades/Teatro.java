package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Teatro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    private String direccion;

    private String telefono;

    @ToString.Exclude
    @ManyToOne
    private Ciudad ciudad;

    @ToString.Exclude
    @ManyToOne
    private AdministradorTeatro administradorTeatro;

    @OneToMany(mappedBy = "teatro")
    private List<Sala> salas;

    @ManyToOne
    @JoinColumn(name = "administrador_codigo")
    private Administrador administrador;

    public Teatro(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
