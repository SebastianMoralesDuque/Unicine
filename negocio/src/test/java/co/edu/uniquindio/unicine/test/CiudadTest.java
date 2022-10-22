package co.edu.uniquindio.unicine.test;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.repositorios.CiudadRepo;
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
public class CiudadTest {
    @Autowired
    private CiudadRepo ciudadRepo;

    //ffffffffffffffffffffffffffffffffffffffffff
    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Ciudad> lista = ciudadRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Ciudad> buscado = ciudadRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Ciudad guardado = ciudadRepo.findById(1).orElse(null);
        guardado.setNombre("Manizales");

        Ciudad nuevo = ciudadRepo.save(guardado);
        Assertions.assertEquals("Manizales", nuevo.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Ciudad buscada = ciudadRepo.findById(1).orElse(null);
        ciudadRepo.delete(buscada);

        Assertions.assertNull(ciudadRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void contarTeatros(){

        List<Object[]> teatros = ciudadRepo.contarTeatros();
        System.out.println(teatros);
    }

}