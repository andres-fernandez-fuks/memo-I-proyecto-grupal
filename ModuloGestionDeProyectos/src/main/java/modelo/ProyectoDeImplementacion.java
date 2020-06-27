package modelo;

import persistencia.EntidadProyecto;

import javax.persistence.Entity;
import javax.persistence.Table;

public class ProyectoDeImplementacion extends Proyecto {

    private String cliente;
    public ProyectoDeImplementacion(long id, String nombre) {
        super(id,nombre);
        tipoDeProyecto = "Implementación";
    }

    public ProyectoDeImplementacion(EntidadProyecto proyecto) {
        super(proyecto.getId(), proyecto.getNombre());
        tipoDeProyecto = "Implementación";
    }

    public void asociarCliente(String nombreDeCliente) { cliente = nombreDeCliente;}

    public String getCliente() { return cliente; }
}
