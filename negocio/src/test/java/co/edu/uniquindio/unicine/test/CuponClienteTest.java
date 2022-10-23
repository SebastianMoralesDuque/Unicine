package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.CuponCliente;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.CuponClienteRepo;
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
public class CuponClienteTest {
    @Autowired
    private CuponClienteRepo cuponClienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<CuponCliente> lista = cuponClienteRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<CuponCliente> buscado = cuponClienteRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        CuponCliente guardado = cuponClienteRepo.findById(1).orElse(null);
        guardado.setEstado("activo");

        CuponCliente nuevo = cuponClienteRepo.save(guardado);
        Assertions.assertEquals("activo", nuevo.getEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        CuponCliente buscado = cuponClienteRepo.findById(1).orElse(null);
        cuponClienteRepo.delete(buscado);

        Assertions.assertNull(cuponClienteRepo.findById(1).orElse(null));
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void redimirCupon() throws Exception{
        CuponCliente cuponGuardado = cuponClienteRepo.buscarCuponClientePorCodigoCupon(1);
        if(cuponGuardado == null) {
            throw new Exception("El cupon no existe");
        }
        cuponGuardado.setEstado(String.valueOf(true));
        cuponClienteRepo.save(cuponGuardado);

        cuponGuardado = cuponClienteRepo.buscarCuponClientePorCodigoCupon(1);
        System.out.println(cuponGuardado);
    }

}