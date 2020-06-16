package modelo;

import com.fasterxml.jackson.annotation.JsonTypeId;

public class Proyecto {
    private @JsonTypeId long id;
    private String nombre;

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
}
