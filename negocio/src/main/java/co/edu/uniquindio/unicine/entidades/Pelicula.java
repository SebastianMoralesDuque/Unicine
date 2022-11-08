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
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false,length = 100)
    private String nombre;

    private String urlImagen;

    private String urlTrailer;

    private String sinopsis;

    private String reparto;

    @Column(nullable = false)
    private boolean estado;

    @ElementCollection
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private  List<Genero> generos;

    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;


    public Pelicula(int i, String purga, String rutaimagen, String rutatrailer, String terror, String leonardo, boolean b) {
    }
}
