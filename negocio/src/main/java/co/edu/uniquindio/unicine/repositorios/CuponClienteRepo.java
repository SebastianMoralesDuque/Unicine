package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.CuponCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuponClienteRepo extends JpaRepository<CuponCliente,Integer> {


    @Query("select cupCli.cliente.codigo, cupCli.cliente.nombre, cup from CuponCliente cupCli left join cupCli.cupon cup ")
    List<Object[]> obtenerCuponesTodosClientes();

    @Query("select cupCli from CuponCliente cupCli where cupCli.cupon.codigo = :codigoCupon")
    CuponCliente buscarCuponClientePorCodigoCupon(Integer codigoCupon);

    Optional<CuponCliente> findByCodigo(String codigo);



}
