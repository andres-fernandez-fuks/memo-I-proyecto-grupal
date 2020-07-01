package modelo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import excepciones.RestriccionDeEstadoException;
import modelo.Estado.EstadoProyecto;
import persistencia.EntidadProyecto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "tipoDeProyecto")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProyectoDeDesarrollo.class, name = "Desarrollo"),
        @JsonSubTypes.Type(value = ProyectoDeImplementacion.class, name = "Implementación")
})
public abstract class Proyecto {

    protected EstadoProyecto estado = EstadoProyecto.NO_INICIADO;

    protected Long id;
    protected RegistroDeDatos registroDeDatos = new RegistroDeDatos();
    protected String tipoDeProyecto;
    public Proyecto(String nombre){
        this.setNombre(nombre);
    }
    public Proyecto(Long id, String nombre) {
        this.id = id;
        this.setNombre(nombre);
    }

    public Proyecto(EntidadProyecto proyecto){
        this.id = proyecto.getId();
        this.setEstado(proyecto.getEstado());
        this.setNombre(proyecto.getNombre());
        this.setDescripcion(proyecto.getDescripcion());
        this.setFechaDeInicio(proyecto.getFechaDeInicio());
        this.setFechaDeFinalizacion(proyecto.getFechaDeFin());

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
    public void setFechaDeInicio(Date fechaDeInicio){ this.registroDeDatos.setFechaDeInicio(fechaDeInicio);}
    public void setFechaDeInicio(String fechaDeInicio) throws ParseException,RestriccionDeEstadoException {
        if (!estado.getNombre().equals("No iniciado")) {
            throw new RestriccionDeEstadoException("No se puede cambiar la fecha de inicio de un proyecto iniciado");
        }
        registroDeDatos.setFechaDeInicio(fechaDeInicio);
    }
    public void setFechaDeFinalizacion(String fechaDeFinalizacion) throws ParseException {
        this.registroDeDatos.setFechaDeFinalizacion(fechaDeFinalizacion);
    }
    private void setFechaDeFinalizacion(Date fechaDeFin) {
        registroDeDatos.setFechaDeFinalizacion(fechaDeFin);
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
        EntidadProyecto entidad = new EntidadProyecto();
        if (id != null){
            entidad.setId(id);
        }
        entidad.setTipoDeProyecto(tipoDeProyecto);
        entidad.setNombre(registroDeDatos.getNombre());
        entidad.setDescripcion(registroDeDatos.getDescripcion());
        entidad.setEstado(estado.getNombre());
        entidad.setFechaDeInicio(registroDeDatos.getFechaDeInicio());
        entidad.setFechaDeFin(registroDeDatos.getFechaDeFinalizacion());
        if (tipoDeProyecto.equals("Implementación")){
            ((ProyectoDeImplementacion)this).ingresarDatos(entidad);
        }
        return entidad;
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
