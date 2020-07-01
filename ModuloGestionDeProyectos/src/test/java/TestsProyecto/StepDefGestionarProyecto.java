package TestsProyecto;

import excepciones.RestriccionDeEstadoException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.*;
import persistencia.ProyectosRepository;

import io.cucumber.datatable.DataTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.*;

public class StepDefGestionarProyecto extends SpringTest {

    private Proyecto proyecto;
    private String estado;
    private Map<Long,Long> diccionario_idOriginal_idNuevo = new HashMap<Long,Long>();
    private Exception excepcion;

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

    @When("asigno la fecha de inicio a {string}")
    public void asignoLaFechaDeInicioA(String fecha) {
        try {
            proyecto.setFechaDeInicio(fecha);
        } catch (ParseException|RestriccionDeEstadoException e) {
            this.excepcion = e;
        }
    }

    @Then("la fecha de inicio del proyecto es {string}")
    public void laFechaDeInicioDelProyectoEs(String fecha) {
        try {
            assertEquals(proyecto.getFechaDeInicio(), new SimpleDateFormat("dd/MM/yyyy").parse(fecha));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Given("selecciono un proyecto y le asigno la fecha de inicio {string}")
    public void seleccionoUnProyectoYLeAsignoLaFechaDeInicio(String fecha) throws ParseException {
        this.proyecto = new ProyectoDeDesarrollo("Proyecto X");
        excepcion = null;
        this.proyecto.setFechaDeInicio(fecha);
    }

    @Then("se lanza un error indicando que la fecha de inicio no se puede modificar")
    public void seLanzaUnErrorIndicandoQueLaFechaDeInicioNoSePuedeModificar() {
        assertNotNull(excepcion);
        assertEquals(excepcion.getClass(), RestriccionDeEstadoException.class);
    }

    @Then("se lanza un error indicando que la fecha de inicio ingresada no es válida")
    public void seLanzaUnErrorIndicandoQueLaFechaDeInicioIngresadaNoEsVálida() {
        assertNotNull(excepcion);
        assertEquals(excepcion.getClass(), ParseException.class);
    }

    @Given("selecciono un proyecto")
    public void seleccionoUnProyecto() {
        this.proyecto = new ProyectoDeDesarrollo("Proyecto X");
        excepcion = null;
    }

    @Given("creo un proyecto con fecha de inicio {string}")
    public void creoUnProyectoConFechaDeInicio(String fecha) {
        this.proyecto = new ProyectoDeDesarrollo("Proyecto Y");
        try {
            this.proyecto.setFechaDeInicio(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @When("lo guardo en el repositorio")
    public void loGuardoEnElRepositorio() {
        proyecto = listadoDeProyectos.saveNew(proyecto);
    }

    @Then("la fecha se guardo correctamente")
    public void laFechaSeGuardoCorrectamente() {
        Proyecto proyectoGuardado = listadoDeProyectos.getOne(proyecto.getId());
        assertEquals(proyecto.getFechaDeInicio(),proyectoGuardado.getFechaDeFinalizacion());
    }
}
