package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminTeatroServicio implements AdminTeatroServicioImpl {

    private final TeatroRepo teatroRepo;
    private final AdministradorTeatroRepo administradorTeatroRepo;
    private final HorarioRepo horarioRepo;
    private final FuncionRepo funcionRepo;
    private final SalaRepo salaRepo;

    private final PeliculaRepo peliculaRepo;

    public AdminTeatroServicio(TeatroRepo teatroRepo, AdministradorTeatroRepo administradorTeatroRepo, HorarioRepo horarioRepo, FuncionRepo funcionRepo, SalaRepo salaRepo, PeliculaRepo peliculaRepo) {
        this.teatroRepo = teatroRepo;
        this.administradorTeatroRepo = administradorTeatroRepo;
        this.horarioRepo = horarioRepo;
        this.funcionRepo = funcionRepo;
        this.salaRepo = salaRepo;
        this.peliculaRepo = peliculaRepo;
    }

    @Override
    public AdministradorTeatro loginTest(String correo, String password) throws Exception {
        AdministradorTeatro a = administradorTeatroRepo.comprobarAutenticacion(correo, password);

        if(a == null){
            throw new Exception("Datos incorrectos");
        }
        return a;
    }

    @Override
    public Teatro crearTeatros(Teatro teatro) throws Exception {
        boolean teatroExiste = teatroRepetido(teatro.getNombre());
        if(teatroExiste){
            throw new Exception("El teatro ya Existe");
        }
        return teatroRepo.save(teatro);
    }

    private boolean teatroRepetido(String nombre) {
        return teatroRepo.findByNombre(nombre).orElse(null) != null;
    }

    @Override
    public Teatro actualizarTeatros(Teatro teatro) throws Exception {
        Optional<Teatro> teatroGuardado = teatroRepo.findById(teatro.getCodigo());
        if (teatroGuardado.isEmpty()){
            throw new Exception("El teatro no existe");
        }
        return teatroRepo.save(teatroGuardado.get());
    }

    @Override
    public void eliminarTeatros(Integer codigo) throws Exception {
        Optional<Teatro> teatroGuardado = teatroRepo.findById(codigo);
        if (teatroGuardado.isEmpty()){
            throw new Exception("El teatro no existe");
        }
        teatroRepo.delete(teatroGuardado.get());
    }

    @Override
    public List<Teatro> listarTeatros() {
        return teatroRepo.findAll();
    }

    @Override
    public Horario crearHorarios(Horario horario) throws Exception {
        boolean horarioExiste = HorarioRepetido(horario.getCodigo());
        if(horarioExiste){
            throw new Exception("El horario ya EXISTE en el hora agregada");
        }
        return horarioRepo.save(horario);
    }

    private boolean HorarioRepetido(Integer hora) {
        return horarioRepo.findById(hora).orElse(null)!= null;
    }


    @Override
    public Horario obtenerHorario(Integer codigo) throws Exception {
        Optional<Horario> horario = horarioRepo.findById(codigo);
        if(horario.isEmpty()){
            throw new Exception("No existe el horario");
        }
        return horario.get();
    }

    @Override
    public Horario actuaizarHorarios(Horario horario) throws Exception {
        Optional<Horario> horarioGuardado = horarioRepo.findById(horario.getCodigo());
        if(horarioGuardado.isEmpty()){
            throw new Exception("El horario no existe");
        }
        return horarioRepo.save(horario);    }

    @Override
    public void eliminarHorario(Integer codigo) throws Exception {
        Optional<Horario> horarioGuardado = horarioRepo.findById(codigo);
        if(horarioGuardado.isEmpty()){
            throw new Exception("El horario no existe");
        }
        horarioRepo.delete(horarioGuardado.get());
    }

    @Override
    public List<Horario> listarHorarios() {
        return horarioRepo.findAll();
    }

    @Override
    public Funcion crearFunciones(Funcion funcion) throws Exception {

        if(funcion.getPelicula().isEstado()){
            throw new Exception("La pelicula no esta en cartelera");
        }
        return funcionRepo.save(funcion);
    }

    @Override
    public Funcion obtenerFunciones(Integer codigo) throws Exception {
        Optional<Funcion> funcion = funcionRepo.findById(codigo);
        if(funcion.isEmpty()){
            throw new Exception("No existe la funcion");
        }
        return funcion.get();
    }


    @Override
    public Funcion actuaizarFunciones(Funcion funcion) throws Exception {
        Optional<Funcion> funcionGuardada = funcionRepo.findById(funcion.getCodigo());
        if(funcionGuardada.isEmpty()){
            throw new Exception("La funcion no existe");
        }
        return funcionRepo.save(funcion);
    }

    @Override
    public void eliminarFuncion(Integer codigo) throws Exception {
        Optional<Funcion> funcionGuardada = funcionRepo.findById(codigo);
        if(funcionGuardada.isEmpty()){
            throw new Exception("La funcion no existe");
        }
        funcionRepo.delete(funcionGuardada.get());
    }

    @Override
    public List<Funcion> listarFuncion() {
        return funcionRepo.findAll();
    }

    @Override
    public Sala crearSalas(Sala sala) {
        return salaRepo.save(sala);
    }

    @Override
    public Sala obtenerSala(Integer codigo) throws Exception {
        Optional<Sala> sala = salaRepo.findById(codigo);
        if(sala.isEmpty()){
            throw new Exception("No existe la sala con ese codigo");
        }
        return sala.get();    }

    @Override
    public Sala actualizarSala(Sala sala) throws Exception {
        Optional<Sala> salaGuardada = salaRepo.findById(sala.getCodigo());
        if(salaGuardada.isEmpty()){
            throw new Exception("La sala no existe");
        }
        return salaRepo.save(sala);
    }

    @Override
    public void eliminarSala(Integer codigoSala) throws Exception {
        Optional<Sala> salaGuardada = salaRepo.findById(codigoSala);
        if(salaGuardada.isEmpty()){
            throw new Exception("La sala no existe");
        }
        salaRepo.delete(salaGuardada.get());
    }

    @Override
    public List<Sala> listarSala() {
        return salaRepo.findAll();
    }

    @Override
    public Teatro obtenerTeatro(Integer codigo) throws Exception {
        Optional<Teatro> teatro = teatroRepo.findById(codigo);
        if(teatro.isEmpty()){
            throw new Exception("No existe el teatro");
        }
        return teatro.get();
    }
}
