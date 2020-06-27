package TestsProyecto;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.Proyecto;
import modelo.ProyectoDeImplementacion;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefEliminarProyectos extends SpringTest{

    @Given("existen {int} proyectos cargados en el sistema")
    public void existenProyectosCargadosEnElSistema(int cantidadDeProyectos) {
        Proyecto proyecto;
        for (int i = 1; i <= cantidadDeProyectos; i++) {
            proyecto = new ProyectoDeImplementacion(i,"Proyecto "+i);
            listadoDeProyectos.save(proyecto);
        }
    }

    @When("elimino {int} proyectos")
    public void eliminoProyectos(int cantidadAEliminar) {
        List<Proyecto> lista = listadoDeProyectos.findAll();
        for (int i = 1; i <= cantidadAEliminar; i++) {
            listadoDeProyectos.delete(lista.get(i));
        }
    }

    @Then("quedan {int} elementos cargados en el sistema")
    public void quedanElementosCargadosEnElSistema(int cantidadDeProyectosRestantes) {
        assertEquals(cantidadDeProyectosRestantes,listadoDeProyectos.findAll().size());
    }

}
