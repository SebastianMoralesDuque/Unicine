package co.edu.uniquindio.unicine.test;


import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {


    @Autowired
    private AdministradorRepo administradorRepo;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @Autowired
    private AdminServicio administradorServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void login() throws Exception{

        Administrador guardado = administradorRepo.comprobarAuntenticacion("sara@email.com","sara123");
        Assertions.assertNotNull(guardado);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void crearCiudadTest(){
        try {
            List<Teatro> teatro= null;
            Ciudad ciudad = new Ciudad(2,"pereira",teatro);
            Ciudad ciudadCreada = administradorServicio.crearCiudad(ciudad);
            Assertions.assertNotNull(ciudadCreada);
            System.out.println(ciudadCreada.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
