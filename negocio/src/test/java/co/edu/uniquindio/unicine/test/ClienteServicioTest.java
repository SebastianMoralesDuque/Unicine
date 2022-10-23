package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import co.edu.uniquindio.unicine.repositorios.CuponClienteRepo;
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
import java.util.Optional;

@SpringBootTest
@Transactional

public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private EmailServicio emailServicio;

    private CuponClienteRepo cuponClienteRepo;

    private ClienteRepo clienteRepo;


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

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComprasCliente() throws Exception {



        try {
            List<Compra> compras= clienteRepo.obtenerComprasCliente("0001");
            compras.forEach(System.out::println);



        } catch (Exception e) {
            throw new Exception(e);
        }

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

    @Test
    @Sql("classpath:dataset.sql")
    public void hacerCompra() throws Exception{
       Compra compra = new Compra();
       Cliente cliente = new Cliente("0005","sebas","carlos@email.com","urlfoto","pass2d1", LocalDate.of(2022,05,05),true,null,null,null);
       Entrada entrada = new Entrada(7,null,compra.getCuponCliente().getCompra());
       Cliente nuevo = clienteServicio.login("sebas@email.com","passw1");
        try {
        if(nuevo==null)
        {
            throw new Exception("cliente no registrado");
        }
        if (!compra.getFuncion().getPelicula().isEstado())
        {
            throw new Exception("pelicula no disponible");
        }
        Optional<CuponCliente> buscado =cuponClienteRepo.findByCodigo(""+cliente.getCuponClienteList());
       if(buscado.isEmpty())
       {
           throw new Exception("el cupon no existe");
       }
       compra.setCliente(cliente);
       compra.setFecha(LocalDate.now().atStartOfDay());
       Assertions.assertNotNull(compra);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }



}


