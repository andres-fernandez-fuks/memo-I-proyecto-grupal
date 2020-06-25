package TestsProyecto;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.Proyecto;
import modelo.ProyectoDeDesarrollo;
import modelo.ProyectoDeImplementacion;
import modelo.ProyectosRepository;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDefTiposDeProyecto {

    private ProyectosRepository listadoDeProyectos;

    @Given("un listado de proyectos")
    public void unListadoVacio() { listadoDeProyectos = new ProyectosRepository(); }

    @When("creo proyectos de distinto tipo")
    public void creoProyectos(DataTable dt) {
        List<Map<String,String>> listaDeMapas = dt.asMaps();
        Proyecto proyecto;
        for (Map<String,String> fila: listaDeMapas) {
            if (fila.get("tipo").equals("Implementación")) {
                proyecto = new ProyectoDeImplementacion(Integer.parseInt(fila.get("id")),fila.get("nombre"));
                listadoDeProyectos.agregarProyecto(proyecto);
            }
            else {
                proyecto = new ProyectoDeDesarrollo(Integer.parseInt(fila.get("id")),fila.get("nombre"));
                listadoDeProyectos.agregarProyecto(proyecto);
            }
        }
    }

    @Then("se me devuelven los tipos correctos para cada proyecto")
    public void losTiposDeProyectoSonCorrectos(DataTable dt) {
        List<Map<String, String>> lista = dt.asMaps();
        int diferencias_encontradas = 0;
        for (Map<String, String> fila : lista) {
            Proyecto proyecto = listadoDeProyectos.obtenerProyecto(Integer.parseInt(fila.get("id")));
            if (!(fila.get("tipo").equals(proyecto.getTipoDeProyecto()))) {
                diferencias_encontradas = 1;
                break;
            }
        }
        assertEquals(0,diferencias_encontradas);
    }
}
