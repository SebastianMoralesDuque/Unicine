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

    private final TeatroRepo teatroRepo;
    private final AdministradorTeatroRepo administradorTeatroRepo;
    private final PeliculaRepo peliculaRepo;
    private final ConfiteriaRepo confiteriaRepo;
    private final CuponRepo cuponRepo;

    public AdminServicioImpl(CiudadRepo ciudadRepo, AdministradorRepo administradorRepo, TeatroRepo teatroRepo, AdministradorTeatroRepo administradorTeatroRepo, PeliculaRepo peliculaRepo, ConfiteriaRepo confiteriaRepo, CuponRepo cuponRepo) {
        this.administradorRepo = administradorRepo;
        this.ciudadRepo = ciudadRepo;
        this.teatroRepo = teatroRepo;
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
        Optional<Ciudad> ciudadGuardado = ciudadRepo.findById(ciudad.getCodigo());
        if(ciudadGuardado.isEmpty()){
            throw new Exception("La ciudad NO EXISTE");
        }
        return ciudadRepo.save(ciudad);
    }

    @Override
    public void eliminarCiudad(Integer codigo) throws Exception {

        Optional<Ciudad> ciudadGuardado = ciudadRepo.findById(codigo);
        if(ciudadGuardado.isEmpty()){
            throw new Exception("La ciudad NO EXISTE");
        }
        ciudadRepo.delete(ciudadGuardado.get());

    }

    @Override
    public List<Ciudad> listarCiudad() {
        return null;
    }

    @Override
    public AdministradorTeatro crearAdministradorTeatros(AdministradorTeatro administradorTeatro) throws Exception {
        boolean administradorTeatrosExiste = AdministradorRepetido(administradorTeatro.getCodigo());
        if(administradorTeatrosExiste){
            throw new Exception("La cedula para el administrador ya Existe");
        }
        boolean administradorTeatrosExisteCorreo = AdministradorRepetidoCorreo(administradorTeatro.getEmail()) ;
        if(administradorTeatrosExisteCorreo){
            throw new Exception("El correo para el administrador ya Existe");
        }
        return administradorTeatroRepo.save(administradorTeatro);

    }


    private boolean AdministradorRepetidoCorreo(String email){
        return administradorTeatroRepo.findByEmail(email).orElse(null)!=null;
    }


    private boolean AdministradorRepetido(Integer codigoAdministrador) {
        return administradorTeatroRepo.findByCodigo(codigoAdministrador).orElse(null) != null;
    }
    @Override
    public AdministradorTeatro obtenerAdministrador(Integer codigo) throws Exception {
        Optional<AdministradorTeatro> administradorTeatro = administradorTeatroRepo.findById(codigo);
        if(administradorTeatro.isEmpty()){
            throw new Exception("No existe un administrador de teatros con ese codigo");
        }
        return administradorTeatro.get();
    }

    @Override
    public AdministradorTeatro actualizarAdministradorTeatros(AdministradorTeatro administradorTeatro) throws Exception {
        Optional<AdministradorTeatro> administradorGuardado = administradorTeatroRepo.findById(administradorTeatro.getCodigo());
        if(administradorGuardado.isEmpty()){
            throw new Exception("El administrador NO EXISTE");
        }
        return administradorTeatroRepo.save(administradorTeatro);
    }

    @Override
    public void eliminarAdministradorTeatros(Integer codigo) throws Exception {
        Optional<AdministradorTeatro> administradorGuardado = administradorTeatroRepo.findById(codigo);
        if(administradorGuardado.isEmpty()){
            throw new Exception("El administrador NO EXISTE");
        }
        administradorTeatroRepo.delete(administradorGuardado.get());

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
        Optional<Pelicula> pelicula = peliculaRepo.findById(codigo);
        if(pelicula.isEmpty()){
            throw new Exception("No existe la pelicula con ese codigo");
        }
        return pelicula.get();
    }

    @Override
    public Pelicula actualizarPeliculas(Pelicula pelicula) throws Exception {
        Optional<Pelicula> peliculaGuardada = peliculaRepo.findById(pelicula.getCodigo());
        if (peliculaGuardada.isEmpty()){
            throw new Exception("La pelicula NO EXISTE");
        }
        return peliculaRepo.save(peliculaGuardada.get());
    }

    @Override
    public void eliminarPeliculas(Integer codigo) throws Exception {

        Optional<Pelicula> peliculaGuardada = peliculaRepo.findById(codigo);
        if (peliculaGuardada.isEmpty()){
            throw new Exception("La pelicula NO EXISTE");
        }
        peliculaRepo.delete(peliculaGuardada.get());
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
        Optional<Confiteria> confiteria = confiteriaRepo.findById(codigo);
        if(confiteria.isEmpty()){
            throw new Exception("No existe la confiteria con ese codigo");
        }
        return confiteria.get();
    }

    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception {
        Optional<Confiteria> confiteriaGuardada = confiteriaRepo.findById(confiteria.getCodigo());
        if (confiteriaGuardada.isEmpty()){
            throw new Exception("El producto NO EXISTE");
        }
        return confiteriaRepo.save(confiteriaGuardada.get());
    }

    @Override
    public void eliminarConfiteria(Integer codigo) throws Exception {

        Optional<Confiteria> confiteriaGuardada = confiteriaRepo.findById(codigo);
        if (confiteriaGuardada.isEmpty()){
            throw new Exception("El producto NO EXISTE");
        }
        confiteriaRepo.delete(confiteriaGuardada.get());

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
        Optional<Cupon> cupon = cuponRepo.findById(codigo);
        if(cupon.isEmpty()){
            throw new Exception("No existe el cupon con ese codigo postal");
        }
        return cupon.get();
    }

    @Override
    public Cupon actualizarCupones(Cupon cupon) throws Exception {
        Optional<Cupon> cuponGuardado = cuponRepo.findById(cupon.getCodigo());
        if(cuponGuardado.isEmpty()){
            throw new Exception("El cupon NO EXISTE");
        }
        return cuponRepo.save(cuponGuardado.get());
    }

    @Override
    public void eliminarCupones(Integer codigo) throws Exception {

        Optional<Cupon> cuponGuardado = cuponRepo.findById(codigo);
        if(cuponGuardado.isEmpty()){
            throw new Exception("El cupon NO EXISTE");
        }
        cuponRepo.delete(cuponGuardado.get());

    }

    @Override
    public List<Cupon> listarCupones() {
        return null;
    }
}