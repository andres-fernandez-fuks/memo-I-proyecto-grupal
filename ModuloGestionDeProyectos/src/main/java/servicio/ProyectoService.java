package servicio;

import excepciones.ParametrosInvalidosException;
import excepciones.ProyectoNotFoundException;
import modelo.Proyecto;
import persistencia.Conversor;
import persistencia.EntidadProyecto;
import persistencia.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public class ProyectoService {
    @Autowired
    private ProyectosRepository proyectosRepository;

    private Conversor conversor = new Conversor();

    public List<Proyecto> findAll(){
        return conversor.obtenerProyectos(proyectosRepository.findAll());
    }

    public Proyecto save(Proyecto proyecto){
        EntidadProyecto entidad = proyectosRepository.save(conversor.obtenerEntidad(proyecto));
        return conversor.obtenerProyecto(entidad);
    }

    @Transactional
    public Proyecto saveNew(Proyecto proyecto){
        if ((proyecto.getId() != null) && proyectosRepository.existsById(proyecto.getId())){
            proyecto.setId(null);
        }
        EntidadProyecto entidad = proyectosRepository.save(conversor.obtenerEntidad(proyecto));
        return conversor.obtenerProyecto(entidad);
    }
    public void delete(Proyecto proyecto){
        proyectosRepository.delete(conversor.obtenerEntidad(proyecto));
    }

    @Transactional
    public Proyecto getOne(long id) {
        if (!proyectosRepository.existsById(id)){
            throw new ProyectoNotFoundException("Proyecto con id: " + id + " no encontrado");
        }
        EntidadProyecto entidad = proyectosRepository.getOne(id);
        return conversor.obtenerProyecto(entidad);
    }

    public void deleteById(long id) {
        proyectosRepository.deleteById(id);
    }

    public void deleteAll() {
        proyectosRepository.deleteAll();
    }

    public void update(Proyecto proyecto, Map<String, Object> parametros) {
        try{
            proyecto.actualizar(parametros);
        } catch (ParseException e){
            throw new ParametrosInvalidosException(e.getMessage());
        }
        proyectosRepository.save(conversor.obtenerEntidad(proyecto));
    }

}
