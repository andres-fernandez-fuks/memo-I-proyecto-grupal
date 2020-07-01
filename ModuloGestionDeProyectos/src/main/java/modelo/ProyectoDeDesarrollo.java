package modelo;

import org.springframework.util.ReflectionUtils;
import persistencia.EntidadProyecto;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.Map;


public class ProyectoDeDesarrollo extends Proyecto {

    public ProyectoDeDesarrollo(long id, String nombre) {
        super(id,nombre);
        tipoDeProyecto = "Desarrollo";
    }

    public ProyectoDeDesarrollo(EntidadProyecto proyecto) {
        super(proyecto.getId(), proyecto.getNombre());
        tipoDeProyecto = "Desarrollo";
    }

    public ProyectoDeDesarrollo(String nombre) {
        super(nombre);
        tipoDeProyecto = "Desarrollo";
    }

    public void actualizar(Map<String, Object> parametros) throws ParseException {
        super.actualizar(parametros);
    }
}
