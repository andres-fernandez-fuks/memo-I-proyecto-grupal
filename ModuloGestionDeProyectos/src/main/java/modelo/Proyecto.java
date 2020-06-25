package modelo;

import com.fasterxml.jackson.annotation.JsonTypeId;

public abstract class Proyecto {
    protected @JsonTypeId final long id;
    protected String nombre;
    protected String tipoDeProyecto;

    public Proyecto(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
