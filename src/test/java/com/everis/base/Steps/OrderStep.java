package com.everis.base.Steps;

import com.everis.base.models.Order;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.given;

public class OrderStep {

    private String URL_BASE = "https://petstore.swagger.io/v2";

    public void crearOrden(int id, int petId, int quantity,String status,boolean comp ) {
        Order orden = new Order(id,petId,quantity,status,comp);

        Order responseOrder =
                given()
                        .baseUri(URL_BASE)
                        .contentType("application/json")
                        .body(orden)
                        .log()
                        .all()
                        .when()
                        .post("store/order")
                        .then()
                        .log().all()
                        .extract()
                        .as(Order.class);

        System.out.println("ID de la Orden de Compra Creada: " + responseOrder.getId());
    }

    public void consultarOrden(String id){
        Order orden =
                given()
                        .baseUri(URL_BASE)
                        .log()
                        .all()
                        .when()
                        .get("store/order/"+id)
                        .then()
                        .log().all()
                        .extract()
                        .as(Order.class)
                ;


    }
    public int getStatusCode(){
        return SerenityRest.lastResponse().statusCode();
    }

    public String getOrderStatus(){

        return SerenityRest.lastResponse().body().path("status").toString();
    }

    public int getPetId(){
        return SerenityRest.lastResponse().body().path("petId");
    }
    public int getQuantity(){
        return SerenityRest.lastResponse().body().path("quantity");
    }
    public boolean getOrderComplete(){
        return SerenityRest.lastResponse().body().path("complete");
    }


}
