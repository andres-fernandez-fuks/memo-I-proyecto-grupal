Feature: Eliminación de un proyecto

  Scenario: Borro un proyecto existente
    Given existe un proyecto llamado "Proyecto 1"
    When elimino el proyecto "Proyecto 1"
    Then "Proyecto 1" ya no existe en el listado de proyectos.

  Scenario: Borro multiples proyectos
    Given existen 10 proyectos cargados en el sistema
    When elimino 5 proyectos
    Then quedan 5 elementos cargados en el sistema
