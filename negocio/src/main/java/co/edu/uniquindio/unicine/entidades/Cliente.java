package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    @Column(length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @NonNull
    @Email
    @Column(unique = true, length = 150)
    private String email;

    private String url_foto;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    private Boolean estado;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compraList;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cuponClienteList;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Telefono> telefonos;


    @Builder

    public Cliente(String codigo, String nombre, @NonNull String email, String url_foto, String password, LocalDate fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.url_foto = url_foto;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }
}
