package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.FuncionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {
    @Autowired
    private FuncionRepo funcionRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Funcion> lista = funcionRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Funcion> buscado = funcionRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Funcion guardado = funcionRepo.findById(1).orElse(null);
        guardado.setCodigo(99);

        Funcion nuevo = funcionRepo.save(guardado);
        Assertions.assertEquals(99, nuevo.getCodigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Funcion buscado = funcionRepo.findById(1).orElse(null);
        funcionRepo.delete(buscado);

        Assertions.assertNull(funcionRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerFuncionesSinCompras(){
        List<Funcion>  funcionesSinCompras= funcionRepo.obtenerFuncionesSinCompras(3);
        System.out.println(funcionesSinCompras);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerFuncionesTeatro(){
        List<Funcion>  funcionesTeatro= funcionRepo.obtenerFuncionesTeatro(1,LocalDate.of(2022,10,05),LocalDate.of(2022,10,05));
        System.out.println(funcionesTeatro);
    }

}