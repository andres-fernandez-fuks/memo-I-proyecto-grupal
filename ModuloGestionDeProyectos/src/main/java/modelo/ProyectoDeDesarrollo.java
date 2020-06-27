package modelo;

import persistencia.EntidadProyecto;

import javax.persistence.Entity;
import javax.persistence.Table;


public class ProyectoDeDesarrollo extends Proyecto {

    public ProyectoDeDesarrollo(long id, String nombre) {
        super(id,nombre);
        tipoDeProyecto = "Desarrollo";
    }

    public ProyectoDeDesarrollo(EntidadProyecto proyecto) {
        super(proyecto.getId(), proyecto.getNombre());
        tipoDeProyecto = "Desarrollo";
    }
}
