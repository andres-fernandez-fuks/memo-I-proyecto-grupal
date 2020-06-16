Feature: Creacion de un proyecto

  Scenario: Creo el primer proyecto del sistema
    Given un listado de proyectos vacio
    When creo un proyecto con nombre "ProyectoPrueba"
    Then el listado de proyectos pasa a tener un elemento.

  Scenario: Creo un proyecto con un nombre, y lo pregunto
    Given un proyecto creado con cierto nombre "Nuevo Proyecto"
    When pregunto el nombre del proyecto
    Then se me devuelve el nombre correcto