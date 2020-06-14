Feature: Creacion de un proyecto

  Scenario: Creo el primer proyecto del sistema
    Given un listado de proyectos vacio
    When creo un proyecto con nombre "ProyectoPrueba"
    Then el listado de proyectos pasa a tener un elemento.
