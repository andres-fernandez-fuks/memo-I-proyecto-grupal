package modelo;

public class ProyectoDeImplementacion extends Proyecto {

    private String cliente;

    public ProyectoDeImplementacion(long id, String nombre) {
        super(id,nombre);
        tipoDeProyecto = "Implementación";
    }

    public void asociarCliente(String nombreDeCliente) { cliente = nombreDeCliente;}

    public String getCliente() { return cliente; }
}
