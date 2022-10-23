package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio{

    private final ClienteRepo clienteRepo;
    private final EmailServicio emailServicio;

    private PeliculaRepo peliculaRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo, EmailServicio emailServicio) {
        this.clienteRepo = clienteRepo;
        this.emailServicio = emailServicio;
    }

    @Override
    public Cliente login(String correo, String password) throws Exception {
        Cliente cliente = clienteRepo.comprobarAutenticacion(correo,password);

        if(cliente==null){
            throw new Exception("Los datos de autenticacion son incorrectos");
        }
        return cliente;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {

        boolean correoExiste = esRepetido(cliente.getEmail());

        if (correoExiste){
            throw new Exception("El correo ya esta en uso");
        }
        return clienteRepo.save(cliente);
    }

    private boolean esRepetido (String correo){
    return clienteRepo.findByEmail(correo).orElse(null)!=null;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception{

        Optional<Cliente> guardado= clienteRepo.findById(cliente.getCodigo());

        if(guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(String codigoCliente) throws Exception {
        Optional<Cliente> guardado= clienteRepo.findById(""+codigoCliente);

        if(guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        clienteRepo.delete(guardado.get());

    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public List<Compra> listarHistorial(Compra compra) throws Exception {
        return null;
    }


    @Override
    public List<Compra> hacerCompra(Compra compra) throws Exception {
        return null;
    }


    @Override
    public boolean redimirCupon(Integer codigoCupon) throws Exception {
        return false;
    }

    public void enviarLinkRecuperacion(String correo){
        emailServicio.enviarEmail("Recuperacion contraseña", "Para recuperar la contraseña ingrese a..........", correo);
    }

    @Override
    public boolean cambiarPassword(String correo, String pNueva) throws Exception {

        Cliente cliente = clienteRepo.findByEmail(correo).orElse(null);
        enviarLinkRecuperacion(correo);

        if(cliente==null){
            throw new Exception("El cliente no se encontro");
        }

        cliente.setPassword(pNueva);
        clienteRepo.save(cliente);

        return true;
    }


    @Override
    public Cliente obtenerClienteCodigo(String codigoCliente) throws Exception {
        Optional<Cliente> guardado= clienteRepo.findById(""+codigoCliente);

        if(guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        return guardado.get();
    }
}
