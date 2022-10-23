package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import co.edu.uniquindio.unicine.entidades.Cliente;
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
public class ClienteTest {
    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Cliente buscado = clienteRepo.findById("0001").orElse(null);
        clienteRepo.delete(buscado);

        Assertions.assertNull(clienteRepo.findById("0001").orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Cliente guardado = clienteRepo.findById("0002").orElse(null);
        guardado.setEmail("santiago@gmail.com");

        Cliente nuevo = clienteRepo.save(guardado);
        Assertions.assertEquals("santiago@gmail.com", nuevo.getEmail());
    }


    ///
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComprasTodo(){
        List<Object[]> listaCompras = clienteRepo.obtenerCompraTodos();
        listaCompras.forEach( o ->
                System.out.println(o [0] + "," + o[1] + "," + o[2])
        );
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComprasCliente() throws Exception {



        try {
            List<Compra> compras= clienteRepo.obtenerComprasCliente("0000");
            compras.forEach(System.out::println);



        } catch (Exception e) {
            throw new Exception(e);
        }




    }


    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Cliente> buscado = clienteRepo.findById("0003");
        Assertions.assertNotNull(buscado.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Cliente> lista = clienteRepo.findAll();
        System.out.println(lista);
    }
}
