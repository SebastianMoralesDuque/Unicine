package co.edu.uniquindio.unicine.test;
import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {
    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void login(){

        Administrador administrador = new Administrador(1234, "sara@email.com","sara123");
        Administrador guardado = administradorRepo.save(administrador);

        Assertions.assertEquals("",guardado.getEmail());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Administrador> lista = administradorRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Administrador> buscado = administradorRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Administrador guardado = administradorRepo.findById(1).orElse(null);
        guardado.setEmail("Juan@email.com");

        Administrador nuevo = administradorRepo.save(guardado);
        Assertions.assertEquals("Juan@email.com", nuevo.getEmail());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Administrador buscado = administradorRepo.findById(1).orElse(null);
        administradorRepo.delete(buscado);

        Assertions.assertNull(administradorRepo.findById(1).orElse(null));
    }

}