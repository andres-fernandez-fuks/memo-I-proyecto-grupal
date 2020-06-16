## Como correr Spring  
Opción A:
> ./mvnw spring-boot:run  

Opción B:
> ./mvnw clean package  (esto genera un archivo JAR ejecutable)
> java -jar target/gs-rest-service-0.1.0.jar

Luego acceder a [http://localhost:8080/](http://localhost:8080/) con el endpoint correspondiente.

## Otros detalles  
Los controladores se marcan con la anotación `@RestController`.
Para vincular un determinado endpoint (url) se usan anotacion como `@GetMapping` para GET y `@PostMapping` para POST. Por ejemplo:
> http://localhost:8080/proyecto --> crea un proyecto nuevo con el id siguiente.  

Para recibir parámetros desde la url se usa `@RequestParam`
> http://localhost:8080/proyecto?nombre=Sistema de gestión --> crea un proyecto con el nombre sistema de gestión

Para visualizar los proyectos escribir esto en una terminal, no en la que se corre la API:
curl -v GET localhost:8080/proyectos

Para crear un nuevo proyecto escribir esto en una terminal, no en la que se corre la API:
curl -v POST localhost:8080/proyectos -H 'Content-type:application/json' -d '{"id":..., "nombre":"..."}'
