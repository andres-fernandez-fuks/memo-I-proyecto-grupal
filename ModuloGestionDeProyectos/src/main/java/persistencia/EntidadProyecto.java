package persistencia;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Proyectos")
public class EntidadProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipoDeProyecto;
    private String nombre;
    private String descripcion;
    private String estado;
    private Date fechaDeInicio;
    private Date fechaDeFin;
    //Solo si es de implementacion
    private String cliente;

    public EntidadProyecto() {}

    public EntidadProyecto(long id, String nombre, String tipoDeProyecto) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Date getFechaDeFin() {
        return fechaDeFin;
    }

    public void setFechaDeFin(Date fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
