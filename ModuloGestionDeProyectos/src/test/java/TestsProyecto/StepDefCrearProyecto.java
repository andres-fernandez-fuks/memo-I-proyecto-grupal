package TestsProyecto;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefCrearProyecto {
    private ListadoDeProyectos listado;
    @Given("un listado de proyectos vacio")
    public void unListadoDeProyectosVacio() {
        listado = new ListadoDeProyectos();
    }

    @When("creo un proyecto con nombre {string}")
    public void creoUnProyectoConNombreYDescripcion(String nombre) {
        listado.crearProyecto(nombre);
    }

    @Then("el listado de proyectos pasa a tener {int} elemento.")
    public void elProyectoSeCreaYSeAgregaAlListadoDeProyectos(int cantElementos) {
        assertEquals(cantElementos, listado.cantElementos());
    }

    @When("creo algunos proyectos con nombre e id")
    public void creoUnProyectoConNombreEId(DataTable dt) {
        List<List<String>> lista = dt.asLists();
        for (List<String> proyectos : lista) {
            listado.crearProyecto(proyectos.get(1));
        }
    }
}
