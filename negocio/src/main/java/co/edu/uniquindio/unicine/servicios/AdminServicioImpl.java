package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServicioImpl implements AdminServicio {


    private final CiudadRepo ciudadRepo;

    private final AdministradorRepo administradorRepo;
    private final AdministradorTeatroRepo administradorTeatroRepo;
    private final PeliculaRepo peliculaRepo;
    private final ConfiteriaRepo confiteriaRepo;
    private final CuponRepo cuponRepo;

    public AdminServicioImpl(CiudadRepo ciudadRepo,AdministradorRepo administradorRepo, AdministradorTeatroRepo administradorTeatroRepo, PeliculaRepo peliculaRepo, ConfiteriaRepo confiteriaRepo, CuponRepo cuponRepo) {
        this.administradorRepo = administradorRepo;
        this.ciudadRepo = ciudadRepo;
        this.administradorTeatroRepo = administradorTeatroRepo;
        this.peliculaRepo = peliculaRepo;
        this.confiteriaRepo = confiteriaRepo;
        this.cuponRepo = cuponRepo;
    }

    @Override
    public Administrador login( String email, String password) throws Exception {

        Administrador administrador = administradorRepo.comprobarAuntenticacion(email, password);

        if(administrador == null){
            throw new Exception("Los Datos de Autentificacion son INCORRECTOS");
        }
        return administrador;

    }


    @Override
    public Ciudad crearCiudad(Ciudad ciudad) {
        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {

        Optional<Ciudad> ciudad= ciudadRepo.findById(codigo);

        if(ciudad.isEmpty()){

                throw new Exception("La ciudad con este codigo no existe");
        }
        return null;
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {
        return null;
    }

    @Override
    public void eliminarCiudad(Integer codigo) throws Exception {

    }

    @Override
    public List<Ciudad> listarCiudad() {
        return null;
    }

    @Override
    public AdministradorTeatro crearAdministradorTeatros(AdministradorTeatro administradorTeatro) throws Exception {
        return null;
    }

    @Override
    public AdministradorTeatro obtenerAdministrador(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public AdministradorTeatro actualizarAdministradorTeatros(AdministradorTeatro administradorTeatro) throws Exception {
        return null;
    }

    @Override
    public void eliminarAdministradorTeatros(Integer cedula) throws Exception {

    }

    @Override
    public List<AdministradorTeatro> listarAdministradorTeatros() {
        return null;
    }

    @Override
    public Pelicula crearPeliculas(Pelicula pelicula) {
        return null;
    }

    @Override
    public Pelicula obtenerPelicula(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Pelicula actualizarPeliculas(Pelicula pelicula) throws Exception {
        return null;
    }

    @Override
    public void eliminarPeliculas(Integer codigo) throws Exception {

    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return null;
    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) {
        return null;
    }

    @Override
    public Confiteria obtenerConfiteria(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception {
        return null;
    }

    @Override
    public void eliminarConfiteria(Integer codigo) throws Exception {

    }

    @Override
    public List<Confiteria> listarConfiteria() {
        return null;
    }

    @Override
    public Cupon crearCupones(Cupon cupon) {
        return null;
    }

    @Override
    public Cupon obtenerCupones(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Cupon actualizarCupones(Cupon cupon) throws Exception {
        return null;
    }

    @Override
    public void eliminarCupones(Integer codigo) throws Exception {

    }

    @Override
    public List<Cupon> listarCupones() {
        return null;
    }
}
