package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepo;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import co.edu.uniquindio.unicine.servicios.EmailServicio;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional

public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private EmailServicio emailServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest () throws Exception {
        Cliente nuevo = clienteServicio.login("sebas@email.com","passw1");
        Assertions.assertNotNull(nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest (){

        Cliente cliente = Cliente.builder().codigo("0006").email("juan@email.com").fechaNacimiento(LocalDate.of(2000,05,05)).nombre("Juanito").password("1234").url_foto("http..").build();

        try{
            Cliente nuevo = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e){
                Assertions.assertTrue(false);
            }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPassword () throws Exception {
        try{
            boolean nuevo = clienteServicio.cambiarPassword("sebas@email.com","nueva");
            Assertions.assertNotNull(nuevo);
        } catch (Exception e){
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest() {

        try {
            Cliente cliente = clienteServicio.obtenerClienteCodigo("0001");
            cliente.setNombre("Nuevo nombre");
            Cliente nuevoCliente = clienteServicio.actualizarCliente(cliente);

            Assertions.assertEquals("Nuevo nombre", nuevoCliente.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest() {

        try {
            clienteServicio.eliminarCliente("0001");
            Cliente cliente = clienteServicio.obtenerClienteCodigo("0001");
            Assertions.assertNull(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    @Sql("classpath:dataset.sql")
    public void listarClienteTest() {
        List<Cliente> listaClientes = clienteServicio.listarClientes();
        listaClientes.forEach(System.out::println);
    }

    @Test
    public void enviarCorreoTest(){
        emailServicio.enviarEmail("prueba de envio", "nidocine@gmail.com", "mensaje nuevo");

    }
}


