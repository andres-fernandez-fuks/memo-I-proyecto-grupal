package servicio;

import modelo.Proyecto;
import persistencia.Conversor;
import persistencia.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProyectoService {
    @Autowired
    private ProyectosRepository proyectosRepository;

    private Conversor conversor = new Conversor();

    public List<Proyecto> findAll(){
        return conversor.obtenerProyectos(proyectosRepository.findAll());
    }

    public Proyecto save(Proyecto proyecto){
        proyectosRepository.save(conversor.obtenerEntidad(proyecto));
        return proyecto;
    }
    public void delete(Proyecto proyecto){
        proyectosRepository.delete(conversor.obtenerEntidad(proyecto));
    }

    @Transactional
    public Proyecto getOne(long id) {
        return conversor.obtenerProyecto(proyectosRepository.getOne(id));
    }

    public void deleteById(long id) {
        proyectosRepository.deleteById(id);
    }

    public void deleteAll() {
        proyectosRepository.deleteAll();
    }
}
