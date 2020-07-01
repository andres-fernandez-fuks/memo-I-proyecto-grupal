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

  Scenario: Asigno la fecha de inicio de un proyecto que no la tiene
    Given selecciono el proyecto 1
    When asigno la fecha de inicio a "10/7/2020"
    Then la fecha de inicio del proyecto es "10/7/2020"

  Scenario: Reasignar fecha de inicio lanza error
    Given selecciono un proyecto y le asigno la fecha de inicio "10/7/2020"
    And cambio el estado de proyecto a iniciado
    When asigno la fecha de inicio a "11/11/2020"
    Then se lanza un error indicando que la fecha de inicio no se puede modificar
    And la fecha de inicio del proyecto es "10/7/2020"

  Scenario: Asignar una fecha de inicio con formato inválido lanza un error
    Given selecciono un proyecto
    When asigno la fecha de inicio a "99/9a/2020"
    Then se lanza un error indicando que la fecha de inicio ingresada no es válida

  Scenario:  Modificar el nombre y descripción de un proyecto los cambia correctamente
    Given selecciono un proyecto con nombre "Prueba" y descripcion "Descripcion"
    When le cambio el nombre a "Posta" y descripcion "Esto no es una prueba"
    Then el nombre del proyecto es "Posta"
    And la descripción es "Esto no es una prueba"

  Scenario: Guardar un proyecto con una determinada fecha de inicio se guarda correctamente
    Given creo un proyecto con fecha de inicio "10/07/2020"
    When lo guardo en el repositorio
    Then la fecha se guardo correctamente
