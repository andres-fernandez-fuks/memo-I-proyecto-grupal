package TestsProyecto;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @Then("el listado de proyectos pasa a tener un elemento.")
    public void elProyectoSeCreaYSeAgregaAlListadoDeProyectos() {
        assertEquals(1, listado.cantElementos());
    }
}
