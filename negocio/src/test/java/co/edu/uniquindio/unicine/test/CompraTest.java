package co.edu.uniquindio.unicine.test;
import co.edu.uniquindio.unicine.dto.InformacionCompra;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.CuponCliente;
import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.repositorios.CompraRepo;
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
public class CompraTest {
    @Autowired
    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void Registrar(){
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Listar(){

        List<Compra> lista = compraRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Obtener(){

        Optional<Compra> buscado = compraRepo.findById(1);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Actualizar(){

        Compra guardado = compraRepo.findById(1).orElse(null);
        guardado.setValorTotal(29000);

        Compra nuevo = compraRepo.save(guardado);
        Assertions.assertEquals(29000, nuevo.getValorTotal());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Eliminar(){

        Compra buscada = compraRepo.findById(1).orElse(null);
        compraRepo.delete(buscada);

        Assertions.assertNull(compraRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void contarCuponesRedimidos(){

        List<Object[]> contar = compraRepo.contarCuponesRedimidos();
        String aux = contar.toString();
        System.out.println(aux);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerEntradas(){

        List<Entrada> entradas = compraRepo.obtenerEntradas(1);
        System.out.println(entradas);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void calcularTotalGastado(){

        Float calcularTotalGastado = compraRepo.calcularTotalGastado("0001");
        System.out.println(calcularTotalGastado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompraMasCostosa(){

        List<Object[]> compraMasCostosa = compraRepo.obtenerCompraMasCostosa();
        System.out.println(compraMasCostosa);
    }

    //@Test
    // @Sql("classpath:dataset.sql")
    // public void obtenerInformacionCompras(){
    //    List<InformacionCompra> informacionCompras = compraRepo.obtenerInformacionCompras(0001);
    //    System.out.println(informacionCompras);
    // }



}