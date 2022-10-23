package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepo;
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
public class AdministradorTeatroTest {
    @Autowired
    private AdministradorTeatroRepo administradorTeatroRepoRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<AdministradorTeatro> lista = administradorTeatroRepoRepo.findAll();
        System.out.println(lista);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<AdministradorTeatro> buscado = administradorTeatroRepoRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        AdministradorTeatro guardado = administradorTeatroRepoRepo.findById(1).orElse(null);
        guardado.setEmail("Juan@email.com");

        AdministradorTeatro nuevo = administradorTeatroRepoRepo.save(guardado);
        Assertions.assertEquals("Juan@email.com", nuevo.getEmail());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        AdministradorTeatro buscado = administradorTeatroRepoRepo.findById(1).orElse(null);
        administradorTeatroRepoRepo.delete(buscado);

        Assertions.assertNull(administradorTeatroRepoRepo.findById(1).orElse(null));
    }

}