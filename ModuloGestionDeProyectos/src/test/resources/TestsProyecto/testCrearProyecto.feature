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

  Scenario: Creo proyectos de distinto tipo
    Given un listado de proyectos
    When creo proyectos de distinto tipo
      | id | nombre |      tipo      |
      | 1  | imp_1  | Implementación |
      | 2  | des_1  | Desarrollo     |
      | 3  | des_2  | Desarrollo     |
      | 4  | imp_2  | Implementación |

    Then se me devuelven los tipos correctos para cada proyecto
      | id|     tipo       |
      | 1 | Implementación |
      | 2 | Desarrollo     |
      | 3 | Desarrollo     |
      | 4 | Implementación |