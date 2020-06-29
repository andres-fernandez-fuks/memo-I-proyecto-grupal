package TestsProyecto;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.*;
import persistencia.ProyectosRepository;

import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDefGestionarProyecto extends SpringTest {

    private Proyecto proyecto;
    private String estado;
    private Map<Long,Long> diccionario_idOriginal_idNuevo = new HashMap<Long,Long>();

    @Given("un listado con proyectos cargados")
    public void unListadoConProyectosCargados(DataTable dt) {
        List<Map<String,String>> listaDeMapas = dt.asMaps();
        for (Map<String, String> fila : listaDeMapas) {
            Proyecto proyecto;
            Proyecto proyecto_guardado;
            long id = Long.parseLong(fila.get("id"));
            String nombre = fila.get("nombre");
            if (fila.get("tipo").equals("Desarrollo")) {
                proyecto = new ProyectoDeDesarrollo(id,nombre);
            }
            else { proyecto = new ProyectoDeImplementacion(id,nombre); }
            proyecto_guardado = listadoDeProyectos.save(proyecto);
            diccionario_idOriginal_idNuevo.put(id,proyecto_guardado.getId());
        }
    }

    @Given("selecciono el proyecto {long}")
    public void seleccionoElProyecto(long idDeProyecto) {
        System.out.print(diccionario_idOriginal_idNuevo.get(idDeProyecto));
        Proyecto proyecto = listadoDeProyectos.getOne(diccionario_idOriginal_idNuevo.get(idDeProyecto));
        this.proyecto = proyecto;
    }

    @When("modifico su estado a {string}")
    public void modificoSuEstadoA(String nuevoEstado) {
        this.proyecto.setEstado(nuevoEstado);
        this.estado = nuevoEstado;
    }

    @Then("el estado del proyecto es el correcto")
    public void elEstadoDelProyectoEsElCorrecto() {
        assertEquals(estado,proyecto.getEstado());
    }
}
