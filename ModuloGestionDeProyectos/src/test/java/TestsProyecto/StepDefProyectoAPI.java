package TestsProyecto;

import controladores.ProyectoController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

@WebMvcTest(ProyectoController.class)
public class StepDefProyectoAPI extends SpringTest{
    @Autowired
    private MockMvc mvc;

    @When("tengo el listado de proyectos")
    public void tengoUnListadoDeProyectos() {
    }


    @When("Creo un proyecto con nombre, descripción y tipo")
    public void creoUnProyectoConNombreDescripciónYTipo(DataTable dt) {
        List<Map<String,String>> lista = dt.asMaps();
        for (Map<String, String> fila : lista) {
        }
    }
}
