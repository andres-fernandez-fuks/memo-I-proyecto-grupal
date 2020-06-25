package TestsProyecto;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.ProyectoDeImplementacion;
import modelo.ProyectosRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefCrearProyectoDeImplementacion {
    private ProyectoDeImplementacion proyecto;
    private String tipoDevuelto;

    @Given("un proyecto de implementación creado con id {int} y nombre {string}")
    public void crearProyectoDeImplementacion(long id,String nombre) {
        proyecto = new ProyectoDeImplementacion(id,nombre);
    }

    @When("pregunto el tipo de proyecto")
    public void obtenerTipoDeProyecto() {
        tipoDevuelto = proyecto.getTipoDeProyecto();
    }

    @Then("se me devuelve {string}")
    public void seDevuelveElTipoCorrecto(String tipoDeProyecto) {
        assertEquals(tipoDeProyecto,tipoDevuelto);
    }

}
