package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepo;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepo;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import co.edu.uniquindio.unicine.servicios.EmailServicio;
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
            Ciudad ciudad = new Ciudad(8,"colombia",teatros);
            Administrador administrador = new Administrador(1234,"felipe@gmail.com","0991");
            Teatro teatro = new Teatro("t123","calle123");
            Teatro teatroCreado = adminTeatroServicio.crearTeatros(teatro);
            Assertions.assertNotNull(teatroCreado);
            System.out.println(teatroCreado.getDireccion());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
