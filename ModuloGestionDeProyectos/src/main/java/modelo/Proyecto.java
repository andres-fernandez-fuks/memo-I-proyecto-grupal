package modelo;

import persistencia.EntidadProyecto;

import java.text.ParseException;
import java.util.Date;

public abstract class Proyecto {

    protected Long id;
    //protected String nombre;
    protected RegistroDeDatos registroDeDatos;
    protected String tipoDeProyecto;
    public Proyecto(Long id, String nombre) {
        this.id = id;
        this.registroDeDatos = new RegistroDeDatos(nombre);
    }
    public void modificar(Proyecto proyecto){
        //this.nombre = proyecto.getNombre();
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

    public void setNombre(String nombre) { this.registroDeDatos.setNombre(nombre);}
    public void setDescripcion(String descripcion) { this.registroDeDatos.setDescripcion(descripcion); }
    public void setFechaDeInicio(String fechaDeInicio) throws ParseException {
        this.registroDeDatos.setFechaDeInicio(fechaDeInicio);
    }
    public void setFechaDeFinalizacion(String fechaDeFinalizacion) throws ParseException {
        this.registroDeDatos.setFechaDeFinalizacion(fechaDeFinalizacion);
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
}
