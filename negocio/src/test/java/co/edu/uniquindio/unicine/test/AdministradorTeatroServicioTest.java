package co.edu.uniquindio.unicine.test;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

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
