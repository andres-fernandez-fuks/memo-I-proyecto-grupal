package pruebacucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class StepDefsCalcu {
    private int resultado;
    @Given("Una calculadora")
    public void unaCalculadora() {
        System.out.print("Cree la calculadora");
    }

    @When("Suma {int} y {int}")
    public void sumaY(int num1, int num2) {
        resultado = num1 + num2;
    }


    @Then("El resultado es {int}")
    public void elResultadoEs(int res) {
        assertEquals(res, resultado);
    }
}
