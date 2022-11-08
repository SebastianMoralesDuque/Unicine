package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ToString.Exclude
    @OneToMany(mappedBy = "administrador")
    private List<Teatro> teatros;
    @Email
    @Column(unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    public Administrador(int i, String email, String password) {
        this.email = email;
        this.password = password;
    }
}
