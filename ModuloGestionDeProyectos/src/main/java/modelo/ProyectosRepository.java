package modelo;

import java.util.*;

public class ProyectosRepository {

    private final Map<Long,Proyecto> proyectos = new HashMap<Long, Proyecto>();

    public Map<Long,Proyecto> findAll() {
        return proyectos;
    }

    public Proyecto obtenerProyecto(long id){
        return proyectos.get(id);
    }

    public int obtenerCantidadDeProyectos(){
        return proyectos.size();
    }

    public Proyecto agregarProyecto(Proyecto proyecto) {
        proyectos.put(proyecto.getId(), proyecto);
        return proyectos.get(proyecto.getId());
    }

    public Proyecto modificar(long id, String nombre) {
        Proyecto aux = proyectos.get(id);
        if(aux != null){
            aux.setNombre(nombre);
        } else {
            proyectos.put(id, new ProyectoDeImplementacion(id, nombre));
        }
        return proyectos.get(id);
    }

    public void borrar(long id) {
        proyectos.remove(id);
    }
}
