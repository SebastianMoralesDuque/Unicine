package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorTeatroRepo extends JpaRepository<AdministradorTeatro,Integer> {

    @Query("select a from AdministradorTeatro a where a.email = :correo and a.password = :contrasena")
    AdministradorTeatro comprobarAutenticacion(String correo, String contrasena);
    Optional<AdministradorTeatro> findByCodigo(Integer codigo);
    Optional<AdministradorTeatro> findByEmail(String correo);

}
