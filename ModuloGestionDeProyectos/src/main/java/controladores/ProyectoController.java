package controladores;


import modelo.Proyecto;
import modelo.ProyectosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProyectoController {
    //private final AtomicLong counter = new AtomicLong(1);
    private final ProyectosRepository repositorio = new ProyectosRepository();

    @GetMapping("/proyectos")
    List<Proyecto> all(){
        return repositorio.findAll();
    }

    @GetMapping("/proyectos/{id}")
    Proyecto obtenerProyecto(@PathVariable(value="id") long id){
        return repositorio.obtenerProyecto(id);
    }
    @PostMapping("/proyectos")
    Proyecto newProyecto(@RequestBody Proyecto proyecto){
        return repositorio.save(proyecto);
    }
    /*
    @GetMapping("/proyecto")
    public Proyecto greeting(@RequestParam(value = "nombre", defaultValue = "Sin título") String nombre) {
        return new Proyecto(counter.incrementAndGet(), nombre);
    }
*/

}
