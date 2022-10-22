package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.dto.InformacionCompra;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface CompraRepo extends JpaRepository<Compra,Integer> {

    @Query("select e from Compra c join c.entradas e where c.codigo= :codigoCompra")
    List<Entrada> obtenerEntradas(int codigoCompra);

    @Query("select c.cliente.codigo, count(c) from Compra c where c.cuponCliente is not null group by c.cliente")
    List<Object[]> contarCuponesRedimidos();

    @Query("select sum(c.valorTotal) from Compra c where c.cliente.codigo = :codigoCliente")
    Float calcularTotalGastado(String codigoCliente);

    @Query("select c1.cliente, c1 from Compra c1 where c1.valorTotal = (select max(c.valorTotal)  from Compra  c)")
    List<Object[]> obtenerCompraMasCostosa();

    //  @Query("select new co.edu.uniquindio.unicine.dto.InformacionCompra ( c.valorTotal, c.fecha, c.funcion, (select sum(e.silla.precio) from Entrada  e where e.compra.codigo = c.codigo), (select sum(ee.precioTotal) from CompraConfiteria  ee where ee.compra.codigo = c.codigo)) from Compra c where c.cliente.codigo = :codigoCliente")
    // List<InformacionCompra>  obtenerInformacionCompras(Integer codigoCliente);

    @Query("select c.funcion.pelicula, count(c) from Compra  c where c.funcion.sala.teatro.ciudad.codigo = :codigoCiudad group by c.funcion.pelicula")
    List<Object[]> obtenerPeliculaMasVista(Integer codigoCiudad);

}
