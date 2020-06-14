package TestsProyecto;

import java.util.Vector;

public class ListadoDeProyectos {
    private Vector<String> proyectos = new Vector<String>();

    public int cantElementos() {
        return proyectos.size();
    }

    public void crearProyecto(String nombre) {
        proyectos.add(nombre);
    }
}
