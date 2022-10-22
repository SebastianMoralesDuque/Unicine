package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface FuncionRepo extends JpaRepository<Funcion,Integer> {

    @Query("select f from Funcion f where f.sala.teatro.codigo= :codigoTeatro and f.compras is empty ")
    List<Funcion> obtenerFuncionesSinCompras (Integer codigoTeatro);

    @Query("select f from Funcion f where f.sala.teatro.codigo= :codigoTeatro and f.horario.inicio < :fechaFin or f.horario.fin > :fechaInicio")
    List<Funcion> obtenerFuncionesTeatro (Integer codigoTeatro, LocalDate fechaInicio, LocalDate fechaFin);

}
