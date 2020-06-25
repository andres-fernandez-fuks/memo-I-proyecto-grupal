package TestsProyecto;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.Proyecto;
import modelo.ProyectoDeDesarrollo;
import modelo.ProyectosRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefCrearProyecto {
    private ProyectosRepository listado;
    @Given("un listado de proyectos vacio")
    public void unListadoDeProyectosVacio() {
        listado = new ProyectosRepository();
    }

    @When("creo algunos proyectos con nombre e id")
    public void creoAlgunosProyectosConNombreEId(DataTable dt) {
        List<List<String>> lista = dt.asLists();
        Proyecto proyecto;
        for (List<String> proyectos : lista) {
            proyecto = new ProyectoDeDesarrollo(Integer.parseInt(proyectos.get(0)),proyectos.get(1));
            listado.agregarProyecto(proyecto);
        }
    }

    @Then("el listado de proyectos pasa a tener {int} elementos.")
    public void elProyectoSeCreaYSeAgregaAlListadoDeProyectos(int cantElementos) {
        assertEquals(cantElementos, listado.obtenerCantidadDeProyectos());
    }


}
