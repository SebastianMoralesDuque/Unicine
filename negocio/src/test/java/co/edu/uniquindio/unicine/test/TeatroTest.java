package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.TeatroRepo;
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
public class TeatroTest {
    @Autowired
    private TeatroRepo teatroRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Teatro> lista = teatroRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Teatro> buscado = teatroRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Teatro guardado = teatroRepo.findById(1).orElse(null);
        guardado.setNombre("teatro azul");

        Teatro nuevo = teatroRepo.save(guardado);
        Assertions.assertEquals("Jteatro azul", nuevo.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Teatro buscado = teatroRepo.findById(1).orElse(null);
        teatroRepo.delete(buscado);

        Assertions.assertNull(teatroRepo.findById(1).orElse(null));
    }

}