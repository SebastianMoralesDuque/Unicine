package co.edu.uniquindio.unicine.test;
import co.edu.uniquindio.unicine.dto.HorarioSalaDTO;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repositorios.CompraRepo;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepo;
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
public class PeliculaTest {
    @Autowired
    private PeliculaRepo peliculaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Pelicula buscada = peliculaRepo.findById(1).orElse(null);
        peliculaRepo.delete(buscada);

        Assertions.assertNull(peliculaRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Pelicula guardado = peliculaRepo.findById(1).orElse(null);
        guardado.setNombre("Spider man");

        Pelicula nuevo = peliculaRepo.save(guardado);
        Assertions.assertEquals("Spider man", nuevo.getNombre());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Pelicula> buscado = peliculaRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Pelicula> lista = peliculaRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPelicula(){

        List<Pelicula> lista = peliculaRepo.buscarPelicula("anabelle",true);
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPeliculaNombre(){

        List<Pelicula> lista = peliculaRepo.buscarPeliculaPorNombre("anabelle");
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHorarios(){

        List<HorarioSalaDTO> lista = peliculaRepo.listarHorarios(1,1);
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPeliculasPorGenero(){
        List<Pelicula> lista = peliculaRepo.listarPeliculas(Genero.ACCION);
        System.out.println(lista);
    }

}