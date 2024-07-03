@OrderMasc
Feature: Orden Tienda Mascotas

  @CrearOrder
  Scenario Outline: Crear Orden de Compra de Mascota
    Given llega una nueva orden de compra de mascota
    When creo la orden con el id de orden <ID>, id de mascota <petId>, cantidad <quantity>, estado <status>, y si esta completada <complete>
    Then valido que el status code sea <code>
    And valido que en el body el estado de la orden sea <status>
    And valido que en el body el id de la mascota sea <petId>

    Examples:
      | ID  | petId | quantity | status       | complete   | code |
      | 701 | 10    | 2        | "pendiente"  | "false"    | 200  |
      | 702 | 32    | 1        | "placed"     | "true"     | 200  |
      | 703 | 77    | 3        | "pendiente"  | "false"    | 200  |

  @ConsultarOrder
  Scenario Outline: Consultar Orden de Compra de Mascota
    Given se desea consultar una orden de compra
    When consulto la orden de compra de id <ID>
    Then valido que el status code sea <code>
    And valido que en el body la cantidad sea <quantity>
    And valido en el body si la orden esta completada <complete>
    And valido que en el body el id de la mascota sea <petId>

    Examples:
      |  ID   | code | quantity | complete   | petId |
      | "701" | 200  | 2        | "false"    | 10    |
      | "702" | 200  | 1        | "true"     | 32    |
      | "703" | 200  | 3        | "false"    | 77    |





