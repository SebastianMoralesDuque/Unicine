package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;

    @PositiveOrZero
    private float valorTotal;

    @ToString.Exclude
    @ManyToOne
    private Funcion funcion;

    @ToString.Exclude
    @ManyToOne
    private Cliente cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<CompraConfiteria> compraConfiteriaList;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<Entrada> entradas;

    @ToString.Exclude
    @OneToOne(mappedBy = "compra")
    private CuponCliente cuponCliente;

    public Compra(LocalDateTime fecha, MedioPago medioPago, float valorTotal, Funcion funcion, Cliente cliente, List<CompraConfiteria> compraConfiteriaList, List<Entrada> entradas, CuponCliente cuponCliente) {
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.valorTotal = valorTotal;
        this.funcion = funcion;
        this.cliente = cliente;
        this.compraConfiteriaList = compraConfiteriaList;
        this.entradas = entradas;
        this.cuponCliente = cuponCliente;
    }
}
