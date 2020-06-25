Feature: Atributos de un proyecto

  Scenario: Verifico el nombre de un proyecto
    Given un proyecto creado con cierto nombre "Nuevo Proyecto"
    When pregunto el nombre del proyecto
    Then se me devuelve el nombre correcto

  Scenario: Verifico los tipos de proyectos
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