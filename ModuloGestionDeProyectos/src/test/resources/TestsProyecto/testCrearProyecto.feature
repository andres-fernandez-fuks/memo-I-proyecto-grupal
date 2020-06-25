Feature: Creacion de un proyecto

  Scenario: Creo un proyecto con un nombre, y lo pregunto
    Given un proyecto creado con cierto nombre "Nuevo Proyecto"
    When pregunto el nombre del proyecto
    Then se me devuelve el nombre correcto

  Scenario: Creo proyectos en el sistema
    Given un listado de proyectos vacio
    When creo algunos proyectos con nombre e id
      | 1 | prueba1 |
      | 2 | adada   |
      | 4 | adsjkla |
    Then el listado de proyectos pasa a tener 3 elementos.

  Scenario: Creo un proyecto de implementación
    Given un proyecto de implementación creado con id 1 y nombre "Proyecto de Implementación"
    When pregunto el tipo de proyecto
    Then se me devuelve "Implementación"
