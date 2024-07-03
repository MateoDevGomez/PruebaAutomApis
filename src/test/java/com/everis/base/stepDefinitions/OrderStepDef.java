package com.everis.base.stepDefinitions;

import com.everis.base.Steps.OrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class OrderStepDef {
    @Steps
    OrderStep orden;

    @Given("llega una nueva orden de compra de mascota")
    public void llegaUnaNuevaOrdenDeCompraDeMascota() {
    }

    @When("creo la orden con el id de orden {int}, id de mascota {int}, cantidad {int}, estado {string}, y si esta completada {string}")
    public void creoLaOrdenConElIdDeOrdenIDIdDeMascotaPetIdCantidadQuantityEstadoStatusYCompletadaComplete(int id,int petId, int cantidad,String status,String complete) {
        orden.crearOrden(id,petId, cantidad,status,Boolean.parseBoolean(complete));
    }

    @Then("valido que el status code sea {int}")
    public void validoQueElStatusCodeSeaCode(int code) {
        System.out.println(code);
        System.out.println(orden.getStatusCode());
        Assert.assertEquals(code, orden.getStatusCode());
    }

    @And("valido que en el body el estado de la orden sea {string}")
    public void validoQueEnElBodyElEstadoDeLaOrdenSeaStatus(String status) {
        System.out.println(status);
        System.out.println(orden.getOrderStatus());
        Assert.assertEquals(status, orden.getOrderStatus());
    }

    @And("valido que en el body el id de la mascota sea {int}")
    public void validoQueEnElBodyElIdDeLaMascotaSeaPetId(int id) {
        System.out.println(id);
        System.out.println(orden.getPetId());
        Assert.assertEquals(id, orden.getPetId());
    }

    @Given("se desea consultar una orden de compra")
    public void seDeseaConsultarUnaOrdenDeCompra() {
    }

    @When("consulto la orden de compra de id {string}")
    public void consultoLaOrdenDeCompraDeID(String id) {
        orden.consultarOrden(id);
    }

    @And("valido que en el body la cantidad sea {int}")
    public void validoQueEnElBodyLaCantidadSeaQuantity(int cant) {
        Assert.assertEquals(cant, orden.getQuantity());
    }

    @And("valido en el body si la orden esta completada {string}")
    public void validoQueEnElBodyLaOrdenEstéCompletaComplete(String complete) {
        Assert.assertEquals(Boolean.parseBoolean(complete), orden.getOrderComplete());
    }



}
