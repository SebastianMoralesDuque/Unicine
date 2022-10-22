package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.EntradaRepo;
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
public class EntradaTest {
    @Autowired
    private EntradaRepo entradaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Entrada> lista = entradaRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Entrada> buscado = entradaRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Entrada guardado = entradaRepo.findById(1).orElse(null);
        guardado.setCodigo(99);

        Entrada nuevo = entradaRepo.save(guardado);
        Assertions.assertEquals(99, nuevo.getCodigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Entrada buscado = entradaRepo.findById(1).orElse(null);
        entradaRepo.delete(buscado);

        Assertions.assertNull(entradaRepo.findById(1).orElse(null));
    }

}