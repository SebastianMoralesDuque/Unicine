package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,String> {

    @Query("select c from Cliente c where c.email = :correo and c.password = :password")
    Cliente comprobarAutenticacion(String correo, String password);

    Optional<Cliente> findByEmail(String correo);

    @Query("select cliente.nombre, cliente.email, comp from Cliente cliente left join cliente.compraList comp")
    List<Object[]> obtenerCompraTodos();

    @Query("select c from Compra c where c.cliente.codigo = :cedula")
    List<Compra> obtenerComprasCliente (String cedula);

}
