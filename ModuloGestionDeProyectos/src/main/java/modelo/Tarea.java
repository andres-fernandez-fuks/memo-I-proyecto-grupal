package modelo;

import com.fasterxml.jackson.annotation.JsonTypeId;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarea {

    private @JsonTypeId final long id;
    private String nombre;
    private String descripcion;
    private String responsable;
    private Date fechaDeInicio;
    private Date fechaDeFinalizacion;
    private String estado;

    public Tarea(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setFechaDeInicio(String fechaDeInicio) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaDeInicio = format.parse(fechaDeInicio);
    }

    public void setFechaDeFinalizacion(String fechaDeFinalizacion) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaDeFinalizacion = format.parse(fechaDeFinalizacion);
    }


}
