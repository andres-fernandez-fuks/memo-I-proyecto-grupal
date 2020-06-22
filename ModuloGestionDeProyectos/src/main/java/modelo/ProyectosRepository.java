package modelo;

import java.util.*;

public class ProyectosRepository {
    private final Map<Long,Proyecto> proyectos = new HashMap<Long, Proyecto>();

    public ProyectosRepository() {
        Proyecto inicial = new Proyecto(0, "inicial");
        proyectos.put(inicial.getId(), inicial);
    }

    public Map<Long,Proyecto> findAll() {
        return proyectos;
    }

    public Proyecto obtenerProyecto(long id){
        return proyectos.get(id);
    }

    public Proyecto save(Proyecto proyecto) {
        proyectos.put(proyecto.getId(), proyecto);
        return proyectos.get(proyecto.getId());
    }

    public Proyecto modificar(long id, String nombre) {
        Proyecto aux = proyectos.get(id);
        if(aux != null){
            aux.modificar(nombre);
        } else {
            proyectos.put(id, new Proyecto(id, nombre));
        }
        return proyectos.get(id);
    }

    public void borrar(long id) {
        proyectos.remove(id);
    }
}
