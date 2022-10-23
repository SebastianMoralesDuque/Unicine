package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepo;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepo;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
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
    private AdministradorTeatroRepo administradorTeatroRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest () throws Exception {

            AdministradorTeatro nuevo = administradorTeatroRepo.comprobarAutenticacion("juana@email.com","jinua23");
            Assertions.assertNotNull(nuevo);

    }



}
