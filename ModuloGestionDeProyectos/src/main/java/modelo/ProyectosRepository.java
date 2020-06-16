package modelo;

import java.util.ArrayList;
import java.util.List;

public class ProyectosRepository {
    private final List<Proyecto> proyectos = new ArrayList();

    public ProyectosRepository() {
        Proyecto inicial = new Proyecto(0, "inicial");
        proyectos.add(inicial);
    }

    public List<Proyecto> findAll() {
        return proyectos;
    }

    public Proyecto obtenerProyecto(long id){
        for (int i = 0; i< proyectos.size(); i++){
            if (proyectos.get(i).getId() == id){
                return proyectos.get(i);
            }
        }
        return null;
    }
    public Proyecto save(Proyecto proyecto) {
        proyectos.add(proyecto);
        return proyectos.get(proyectos.size()-1);
    }
}
