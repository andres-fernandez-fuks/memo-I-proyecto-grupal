package TestsProyecto;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.Proyecto;
import modelo.ProyectoDeDesarrollo;
import modelo.ProyectoDeImplementacion;
import persistencia.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDefTiposDeProyecto extends SpringTest{

    private Map<Long,Long> diccionario_idOriginal_idNuevo = new HashMap<Long,Long>();

    @Given("un listado de proyectos")
    public void unListadoVacio() { listadoDeProyectos.deleteAll(); }

    @When("creo proyectos de distinto tipo")
    public void creoProyectos(DataTable dt) {
        List<Map<String,String>> listaDeMapas = dt.asMaps();
        Proyecto proyecto;
        Proyecto proyecto_guardado;
        long id;
        for (Map<String,String> fila: listaDeMapas) {
            id = Long.parseLong(fila.get("id"));
            if (fila.get("tipo").equals("Implementación")) {
                proyecto = new ProyectoDeImplementacion(id,fila.get("nombre"));
            }
            else {
                proyecto = new ProyectoDeDesarrollo(id,fila.get("nombre"));
            }
            proyecto_guardado = listadoDeProyectos.save(proyecto);
            diccionario_idOriginal_idNuevo.put(id,proyecto_guardado.getId());
        }
    }

    @Then("se me devuelven los tipos correctos para cada proyecto")
    public void losTiposDeProyectoSonCorrectos(DataTable dt) {
        List<Map<String, String>> lista = dt.asMaps();
        int diferencias_encontradas = 0;
        for (Map<String, String> fila : lista) {
            long id_viejo = Long.parseLong(fila.get("id"));
            Proyecto proyecto = listadoDeProyectos.getOne(diccionario_idOriginal_idNuevo.get(id_viejo));
            assertEquals(fila.get("tipo"),proyecto.getTipoDeProyecto());
        }

    }
}
