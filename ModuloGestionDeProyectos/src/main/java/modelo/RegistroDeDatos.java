package modelo;

import modelo.Estado.EstadoProyecto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroDeDatos {

    private String nombre;
    private Date fechaDeInicio;
    private Date fechaDeFinalizacion;
    private String descripcion;

    public RegistroDeDatos(String nombre) {
        this.setNombre(nombre);
    }

    public RegistroDeDatos() {

    }

    public String getNombre() { return nombre;}
    public String getDescripcion() { return descripcion;}
    public Date getFechaDeInicio() { return fechaDeInicio;}
    public Date getFechaDeFinalizacion() { return fechaDeFinalizacion;}

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}

    public void setFechaDeInicio(String fechaDeInicio) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaDeInicio = format.parse(fechaDeInicio);
    }

    public void setFechaDeFinalizacion(String fechaDeFinalizacion) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaDeFinalizacion = format.parse(fechaDeFinalizacion);
    }

    public boolean setEstado(String nombreDeEstado) {
        if (this.estado == EstadoProyecto.CANCELADO || this.estado == EstadoProyecto.FINALIZADO) { return false;}
        switch (nombreDeEstado) {
            case "No iniciado": this.estado = EstadoProyecto.NO_INICIADO;
            case "Activo": this.estado = EstadoProyecto.ACTIVO;
            case "Suspendido": this.estado = EstadoProyecto.SUSPENDIDO;
            case "Cancelado": this.estado = EstadoProyecto.CANCELADO;
            case "Finalizado": this.estado = EstadoProyecto.FINALIZADO;
        }
        return true;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public void setFechaDeFinalizacion(Date fechaDeFin) {
        this.fechaDeFinalizacion = fechaDeFin;
    }
}
