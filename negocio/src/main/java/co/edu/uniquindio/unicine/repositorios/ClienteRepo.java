package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,String> {

    @Query("select c from Cliente c where c.email = :correo and c.password = :password")
    Cliente comprobarAutenticacion(String correo, String password);

    Optional<Cliente> findByEmail(String correo);




}
