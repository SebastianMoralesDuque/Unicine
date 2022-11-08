package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepo;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
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

public class AdministradorTeatroServicioTest {
    @Autowired
    private AdministradorRepo administradorRepo;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @Autowired
    private AdminServicio administradorServicio;
    @Autowired
    private AdministradorTeatroRepo administradorTeatroRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest () throws Exception {

            AdministradorTeatro nuevo = administradorTeatroRepo.comprobarAutenticacion("juana@email.com","jinua23");
            Assertions.assertNotNull(nuevo);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearTeatros() throws Exception {
        try {
            List<Teatro> teatros = null;
            Ciudad ciudad = new Ciudad("colombia");
            Administrador administrador = new Administrador(1234,"felipe@gmail.com","0991");
            Teatro teatro = new Teatro("t123","calle123");
            Teatro teatroCreado = adminTeatroServicio.crearTeatros(teatro);
            Assertions.assertNotNull(teatroCreado);
            System.out.println(teatroCreado.getDireccion());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerTeatroTest() throws Exception {
        try {
            Teatro teatroCreado= adminTeatroServicio.obtenerTeatro(3);
            Assertions.assertNotNull(teatroCreado);
            System.out.println(teatroCreado.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTeatrosTeatro() throws Exception {

        try {
            Teatro teatroGuardado = adminTeatroServicio.obtenerTeatro(4);
            System.out.println(teatroGuardado.getNombre());
            teatroGuardado.setNombre("Gold Cine");
            Teatro teatroActualizado = adminTeatroServicio.actualizarTeatros(teatroGuardado);
            Assertions.assertNotNull(teatroActualizado);
            System.out.println(teatroActualizado.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTeatrosTest() throws Exception {

        try {
            adminTeatroServicio.eliminarTeatros(4);
            Teatro teatro = adminTeatroServicio.obtenerTeatro(4);
            Assertions.assertNull(teatro);
        }catch (Exception e){
            throw new Exception(e);
        }


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTeatrosTest()  {
        List<Teatro> teatros = adminTeatroServicio.listarTeatros();
        teatros.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearHorariosTest() throws Exception {

        try {
            Horario horario = new Horario("sabado","5:20",  LocalDate.now(),LocalDate.of(2022,05,05));
            Horario horarioCreado = adminTeatroServicio.crearHorarios(horario);
            Assertions.assertNotNull(horarioCreado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHorarioTest() throws Exception {

        try {
            Horario horarioCreado = adminTeatroServicio.obtenerHorario(3);
            Assertions.assertNotNull(horarioCreado);
            System.out.println(horarioCreado.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actuaizarHorariosTest() throws Exception {

        try {
            Horario horarioGuardado = adminTeatroServicio.obtenerHorario(3);
            Horario horarioOActualziado = adminTeatroServicio.actuaizarHorarios(horarioGuardado);
            Assertions.assertNotNull(horarioGuardado);
            System.out.println(horarioGuardado.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHorarioTest() throws Exception {

        try {
            adminTeatroServicio.eliminarHorario(3);
            Horario horario = adminTeatroServicio.obtenerHorario(3);
            Assertions.assertNull(horario);
        }catch (Exception e){
            throw new Exception(e);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHorariosTest() {

        List<Horario> horarios = adminTeatroServicio.listarHorarios();
        horarios.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerFuncionTest() throws Exception {

        try {
            Funcion funcionCreado = adminTeatroServicio.obtenerFunciones(3);
            Assertions.assertNotNull(funcionCreado);
            System.out.println(funcionCreado.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actuaizarFuncionTest() throws Exception {

        try {
            Funcion funcionGuardado = adminTeatroServicio.obtenerFunciones(3);
            Funcion funcionActualizada = adminTeatroServicio.actuaizarFunciones(funcionGuardado);
            Assertions.assertNotNull(funcionActualizada);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFuncionTest() throws Exception {

        try {
            adminTeatroServicio.eliminarFuncion(3);
            Funcion funcion = adminTeatroServicio.obtenerFunciones(3);
            Assertions.assertNull(funcion);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarFuncionTest() {
        List<Funcion> funciones = adminTeatroServicio.listarFuncion();
        funciones.forEach(System.out::println);
    }


    //-----------------------------------SALAS-------------------------------------

    @Test
    @Sql("classpath:dataset.sql")
    public void crearSalasTest() {

        try {
            Teatro teatro = null;
            Sala sala = new Sala(1,"teatro1",teatro,null,null);
            Sala salaCreada = adminTeatroServicio.crearSalas(sala);
            Assertions.assertNotNull(salaCreada);
            System.out.println(salaCreada.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerSalaTest() throws Exception {

        try {
            Sala salaCreada = adminTeatroServicio.obtenerSala(3);
            Assertions.assertNotNull(salaCreada);
            System.out.println(salaCreada.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarSalaTest() throws Exception {

        try {
            Sala salaGuardada = adminTeatroServicio.obtenerSala(3);
            System.out.println(salaGuardada.getNombre());
            salaGuardada.setNombre("Sala 3 RE ULTRAVIP");
            Sala salaActualizada = adminTeatroServicio.actualizarSala(salaGuardada);
            Assertions.assertNotNull(salaActualizada);
            System.out.println(salaActualizada.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarSalaTest() throws Exception {

        try {
            adminTeatroServicio.eliminarSala(3);
            Sala sala = adminTeatroServicio.obtenerSala(3);
            Assertions.assertNull(sala);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarSalaTest() {
        List<Sala> salas = adminTeatroServicio.listarSala();
        salas.forEach(System.out::println);
    }

}
