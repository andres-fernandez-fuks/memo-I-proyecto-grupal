package persistencia;

import javax.persistence.*;

@Entity
@Table(name = "Proyectos")
public class EntidadProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String nombre;
    protected String tipoDeProyecto;
    public EntidadProyecto() {}

    public EntidadProyecto(long id, String nombre, String tipoDeProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDeProyecto = tipoDeProyecto;
    }

    public EntidadProyecto(String nombre, String tipoDeProyecto) {
        this.nombre = nombre;
        this.tipoDeProyecto = tipoDeProyecto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeProyecto() {
        return tipoDeProyecto;
    }

    public void setTipoDeProyecto(String tipoDeProyecto) {
        this.tipoDeProyecto = tipoDeProyecto;
    }
}
