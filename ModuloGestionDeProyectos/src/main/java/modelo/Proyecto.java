package modelo;

public class Proyecto {
    private long id;
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
