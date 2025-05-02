package Prestamo.Cucumber;

import Prestamo.Prestamo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import java.util.Calendar;
import java.util.Date;

public class RenovarPrestamoSteps {

    private Prestamo prestamo;
    private boolean resultadoRenovacion;

    @Given("un préstamo con ID {int} y fecha de fin {string}")
    public void un_préstamo_con_id_y_fecha_de_fin(int id, String fechaFinStr) {
        prestamo = new Prestamo();
        prestamo.setId(id);
        String[] partes = fechaFinStr.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[2]));
        prestamo.setFechaFin(calendar.getTime());
        prestamo.setRenovado(false);
        prestamo.setRenovacionesRealizadas(0);
    }

    @When("se intenta renovar el préstamo")
    public void se_intenta_renovar_el_préstamo() {
        resultadoRenovacion = prestamo.renovar();
    }

    @Then("la renovación debería ser {string}")
    public void la_renovación_debería_ser(String esperado) {
        Assertions.assertEquals(Boolean.parseBoolean(esperado), resultadoRenovacion);
    }

    @Then("el estado de renovación del préstamo debería ser {string}")
    public void el_estado_de_renovación_del_préstamo_debería_ser(String esperado) {
        Assertions.assertEquals(Boolean.parseBoolean(esperado), prestamo.isRenovado());
    }

    @Then("el número de renovaciones realizadas debería ser {int}")
    public void el_número_de_renovaciones_realizadas_debería_ser(int esperado) {
        Assertions.assertEquals(esperado, prestamo.getRenovacionesRealizadas());
    }

    @Given("un préstamo ya renovado con ID {int} y fecha de fin {string}")
    public void un_préstamo_ya_renovado_con_id_y_fecha_de_fin(int id, String fechaFinStr) {
        prestamo = new Prestamo();
        prestamo.setId(id);
        String[] partes = fechaFinStr.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[2]));
        prestamo.setFechaFin(calendar.getTime());
        prestamo.setRenovado(true);
        prestamo.setRenovacionesRealizadas(1);
    }

    @Given("un préstamo vencido con ID {int} y fecha de fin {string}")
    public void un_préstamo_vencido_con_id_y_fecha_de_fin(int id, String fechaFinStr) {
        prestamo = new Prestamo();
        prestamo.setId(id);
        String[] partes = fechaFinStr.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[2]));
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        prestamo.setFechaFin(calendar.getTime());
        prestamo.setRenovado(false);
        prestamo.setRenovacionesRealizadas(0);
    }
}