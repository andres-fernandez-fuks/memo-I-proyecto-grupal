package modelo;

import com.fasterxml.jackson.annotation.JsonTypeId;
import persistencia.EntidadProyecto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Proyecto {

    protected long id;
    protected String nombre;
    protected String tipoDeProyecto;
    public Proyecto(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public void modificar(Proyecto proyecto){
        this.nombre = proyecto.getNombre();
        this.tipoDeProyecto = proyecto.getTipoDeProyecto();
    }
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void modificar(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeProyecto() { return tipoDeProyecto; }


    public EntidadProyecto obtenerEntidad() {
        return new EntidadProyecto(id, nombre, tipoDeProyecto);
    }
}
