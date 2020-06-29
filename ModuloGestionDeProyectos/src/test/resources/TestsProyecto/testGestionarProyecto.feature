Feature: Gestionar Proyecto

  Background:
    Given un listado con proyectos cargados
      | id |         nombre        |      tipo      |
      | 1  | Sistema ERP Mulesoft  | Implementación |
      | 2  |          ERP          | Desarrollo     |
      | 3  |          BI           | Desarrollo     |
      | 4  | Sistema CRM MicroTec  | Implementación |

  Scenario: Modifico el estado de un proyecto recién cargado
    Given selecciono el proyecto 2
    When modifico su estado a "Finalizado"
    Then el estado del proyecto es el correcto

  #Scenario: Modifico el estado de un proyecto que estaba finalizado
    #Given selecciono el proyecto "ERP" con estado finalizado
    #When modifico su estado a "Activo"
    #Then el estado del proyecto sigue siendo finalizado

  #Scenario: Modifico el estado de un proyecto que estaba cancelado
    #Given selecciono el proyecto "BI" con estado cancelado
    #When modifico su estado a "No Iniciado"
    #Then el estado del proyecto sigue siendo cancelado
