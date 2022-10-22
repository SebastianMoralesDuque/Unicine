package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.CompraConfiteria;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.CompraConfiteriaRepo;
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
public class CompraConfiteriaTest {
    @Autowired
    private CompraConfiteriaRepo compraConfiteriaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<CompraConfiteria> lista = compraConfiteriaRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<CompraConfiteria> buscado = compraConfiteriaRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        CompraConfiteria guardado = compraConfiteriaRepo.findById(1).orElse(null);
        guardado.setPrecioTotal(30000);

        CompraConfiteria nuevo = compraConfiteriaRepo.save(guardado);
        Assertions.assertEquals(30000, nuevo.getPrecioTotal());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        CompraConfiteria buscado = compraConfiteriaRepo.findById(1).orElse(null);
        compraConfiteriaRepo.delete(buscado);

        Assertions.assertNull(compraConfiteriaRepo.findById(1).orElse(null));
    }

}