package TestsProyecto;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SetpDefEliminarProyecto {
    private ListadoDeProyectos listadoDeProyectos;

    @Given("existe un proyecto llamado {string}")
    public void existeUnProyecto(String nombre) {
        listadoDeProyectos = new ListadoDeProyectos();
        listadoDeProyectos.crearProyecto(nombre);
    }
    @When("elimino el proyecto {string}")
    public void eliminoElProyecto(String nombre) {
        listadoDeProyectos.eliminarProyecto(nombre);
    }
    @Then("{string} ya no existe en el listado de proyectos.")
    public void elProyectoEliminadoYaNoExiste(String nombre){
        assertEquals(0, listadoDeProyectos.cantElementos());
    }

}
