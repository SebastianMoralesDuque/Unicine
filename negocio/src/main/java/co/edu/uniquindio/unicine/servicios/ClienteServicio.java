package co.edu.uniquindio.unicine.servicios;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Pelicula;

import java.util.List;

public interface ClienteServicio {

    Cliente login(String correo, String password) throws Exception;

    Cliente registrarCliente (Cliente cliente) throws Exception;

    Cliente actualizarCliente (Cliente cliente)throws Exception;

    void eliminarCliente(String codigoCliente)throws Exception;

    List<Cliente> listarClientes();

    List<Compra> listarHistorial(Compra compra)throws Exception;

    List<Compra> hacerCompra(Compra compra)throws Exception;

    boolean redimirCupon (Integer codigoCupon)throws Exception;

    boolean cambiarPassword(Integer codigo);
    Cliente obtenerClienteCodigo(String codigo)throws Exception;
}
