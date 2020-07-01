package modelo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import excepciones.RestriccionDeEstadoException;
import modelo.Estado.EstadoProyecto;
import persistencia.EntidadProyecto;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "tipoDeProyecto")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProyectoDeDesarrollo.class, name = "Desarrollo"),
        @JsonSubTypes.Type(value = ProyectoDeImplementacion.class, name = "Implementación")
})
public abstract class Proyecto {

    protected EstadoProyecto estado;

    protected Long id;
    protected RegistroDeDatos registroDeDatos;
    protected String tipoDeProyecto;
    public Proyecto(String nombre){
        this.registroDeDatos = new RegistroDeDatos(nombre);
        this.estado = EstadoProyecto.NO_INICIADO;
    }
    public Proyecto(Long id, String nombre) {
        this.id = id;
        this.registroDeDatos = new RegistroDeDatos(nombre);
        this.estado = EstadoProyecto.NO_INICIADO;
    }
    public void modificar(Proyecto proyecto){
        registroDeDatos.setNombre(proyecto.getNombre());
        this.tipoDeProyecto = proyecto.getTipoDeProyecto();
    }
    public Long getId() {
        return id;
    }

    public String getTipoDeProyecto() { return tipoDeProyecto; }

    public String getNombre() {
        return registroDeDatos.getNombre();
    }
    public String getDescripcion() { return this.registroDeDatos.getDescripcion();}
    public Date getFechaDeInicio() { return this.registroDeDatos.getFechaDeInicio();}
    public Date getFechaDeFinalizacion() { return this.registroDeDatos.getFechaDeFinalizacion();}
    public String getEstado() {
        return estado.getNombre();
    }

    public void setNombre(String nombre) { this.registroDeDatos.setNombre(nombre);}
    public void setDescripcion(String descripcion) { this.registroDeDatos.setDescripcion(descripcion); }
    public void setFechaDeInicio(String fechaDeInicio) throws ParseException,RestriccionDeEstadoException {
        if (!estado.getNombre().equals("No iniciado")) {
            throw new RestriccionDeEstadoException("No se puede cambiar la fecha de inicio de un proyecto iniciado");
        }
        registroDeDatos.setFechaDeInicio(fechaDeInicio);
    }
    public void setFechaDeFinalizacion(String fechaDeFinalizacion) throws ParseException {
        this.registroDeDatos.setFechaDeFinalizacion(fechaDeFinalizacion);
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


    public EntidadProyecto obtenerEntidad() {
        if (id == null){
            return new EntidadProyecto(registroDeDatos.getNombre(), tipoDeProyecto);
        }
        return new EntidadProyecto(id, registroDeDatos.getNombre(), tipoDeProyecto);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void actualizar(Map<String, Object> parametros) throws ParseException {
        //No se puede cambiar el tipo de proyecto
        for (Map.Entry<String, Object> entrada : parametros.entrySet()) {
            if (entrada.getKey().equals("nombre")) {
                this.setNombre((String) entrada.getValue());
            } else if (entrada.getKey().equals("descripcion")) {
                this.setDescripcion((String) entrada.getValue());
            } else if (entrada.getKey().equals("fechaDeInicio")) {
                this.setFechaDeInicio((String) entrada.getValue());
            } else if (entrada.getKey().equals("fechaDeFinalizacion")) {
                this.setFechaDeFinalizacion((String) entrada.getValue());
            } else if (entrada.getKey().equals("estado")) {
                this.setEstado((String) entrada.getValue());
            }

        }
    }
}
