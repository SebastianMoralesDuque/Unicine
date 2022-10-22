package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.ConfiteriaRepo;
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
public class ConfiteriaTest {
    @Autowired
    private ConfiteriaRepo confiteriaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Confiteria> lista = confiteriaRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Confiteria> buscado = confiteriaRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Confiteria guardado = confiteriaRepo.findById(1).orElse(null);
        guardado.setPrecio(21900);

        Confiteria nuevo = confiteriaRepo.save(guardado);
        Assertions.assertEquals(21900, nuevo.getPrecio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Confiteria buscado = confiteriaRepo.findById(1).orElse(null);
        confiteriaRepo.delete(buscado);

        Assertions.assertNull(confiteriaRepo.findById(1).orElse(null));
    }

}