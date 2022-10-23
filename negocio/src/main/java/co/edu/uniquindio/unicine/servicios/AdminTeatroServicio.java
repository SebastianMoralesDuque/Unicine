package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminTeatroServicio implements AdminTeatroServicioImpl {

    private final TeatroRepo teatroRepo;
    private final AdministradorTeatroRepo administradorTeatroRepo;
    private final HorarioRepo horarioRepo;
    private final FuncionRepo funcionRepo;
    private final SalaRepo salaRepo;

    public AdminTeatroServicio(TeatroRepo teatroRepo, AdministradorTeatroRepo administradorTeatroRepo, HorarioRepo horarioRepo, FuncionRepo funcionRepo, SalaRepo salaRepo) {
        this.teatroRepo = teatroRepo;
        this.administradorTeatroRepo = administradorTeatroRepo;
        this.horarioRepo = horarioRepo;
        this.funcionRepo = funcionRepo;
        this.salaRepo = salaRepo;
    }

    @Override
    public AdministradorTeatro login(String correo, String password) throws Exception {
        AdministradorTeatro a = administradorTeatroRepo.comprobarAutenticacion(correo, password);

        if(a == null){
            throw new Exception("Datos incorrectos");
        }
        return a;
    }

    @Override
    public Teatro crearTeatros(Teatro teatro) throws Exception {
        return null;
    }

    @Override
    public Teatro actualizarTeatros(Teatro teatro) throws Exception {
        return null;
    }

    @Override
    public void eliminarTeatros(Integer codigo) throws Exception {

    }

    @Override
    public List<Teatro> listarTeatros() {
        return null;
    }

    @Override
    public Horario crearHorarios(Horario horario) throws Exception {
        return null;
    }

    @Override
    public Horario obtenerHorario(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Horario actuaizarHorarios(Horario horario) throws Exception {
        return null;
    }

    @Override
    public void eliminarHorario(Integer codigo) throws Exception {

    }

    @Override
    public List<Horario> listarHorarios() {
        return null;
    }

    @Override
    public Funcion crearFunciones(Funcion funcion) throws Exception {
        return null;
    }

    @Override
    public Funcion obtenerFunciones(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Funcion actuaizarFunciones(Funcion funcion) throws Exception {
        return null;
    }

    @Override
    public void eliminarFuncion(Integer codigo) throws Exception {

    }

    @Override
    public List<Funcion> listarFuncion() {
        return null;
    }

    @Override
    public Sala crearSalas(Sala sala) {
        return null;
    }

    @Override
    public Sala obtenerSala(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Sala actualizarSala(Sala sala) throws Exception {
        return null;
    }

    @Override
    public void eliminarSala(Integer codigoSala) throws Exception {

    }

    @Override
    public List<Sala> listarSala() {
        return null;
    }
}
