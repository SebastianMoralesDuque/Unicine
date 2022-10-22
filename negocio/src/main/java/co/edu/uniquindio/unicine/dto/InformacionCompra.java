package co.edu.uniquindio.unicine.dto;

import co.edu.uniquindio.unicine.entidades.Funcion;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class InformacionCompra {

    private Float precioTotal;
    private LocalDateTime fecha;
    private Funcion funcion;
    private Integer precioEntradas;
    private Integer precioConfiteria;
}
