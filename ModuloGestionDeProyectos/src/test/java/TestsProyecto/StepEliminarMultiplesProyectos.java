package TestsProyecto;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.Proyecto;
import modelo.ProyectosRepository;

import static org.junit.Assert.assertEquals;

public class StepEliminarMultiplesProyectos {

    private ProyectosRepository listadoDeProyectos = new ProyectosRepository();

    @Given("existen {int} proyectos cargados en el sistema")
    public void existenProyectosCargadosEnElSistema(int cantidadDeProyectos) {
        Proyecto proyecto;
        for (int i = 0; i < cantidadDeProyectos; i++) {
            proyecto = new Proyecto(i,"Proyecto "+i);
            listadoDeProyectos.save(proyecto);
        }
    }

    @When("elimino {int} proyectos")
    public void eliminoProyectos(int cantidadAEliminar) {
        for (int i = 0; i < cantidadAEliminar; i++) {
            listadoDeProyectos.borrar(i);
        }
    }

    @Then("quedan {int} elementos cargados en el sistema")
    public void quedanElementosCargadosEnElSistema(int cantidadDeProyectosRestantes) {
        assertEquals(cantidadDeProyectosRestantes,listadoDeProyectos.obtenerCantidadDeProyectos());
    }

}
