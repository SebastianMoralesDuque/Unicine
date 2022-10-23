package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,Integer> {

    @Query("select a from Administrador a where a.email = :email and a.password = :password")
    Administrador comprobarAuntenticacion(String email, String password);


    Optional<Administrador> findByCodigo(Integer codigo);
    Optional<Administrador> findByEmail(String correo);
}
