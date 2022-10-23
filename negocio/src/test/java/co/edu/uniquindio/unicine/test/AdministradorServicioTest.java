package co.edu.uniquindio.unicine.test;


import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {


    @Autowired
    private AdministradorRepo administradorRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void login() throws Exception{


        Administrador guardado = administradorRepo.comprobarAuntenticacion("sa@email.com","sara123");

        Assertions.assertNotNull(guardado);
    }
}
