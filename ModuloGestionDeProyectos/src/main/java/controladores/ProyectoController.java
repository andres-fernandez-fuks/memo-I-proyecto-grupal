package controladores;


import modelo.Proyecto;
import modelo.ProyectosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProyectoController {
    private final ProyectosRepository repositorio = new ProyectosRepository();
    //Grupal
    @GetMapping("/proyectos")
    Map<Long,Proyecto> all(){
        return repositorio.findAll();
    }

    @PostMapping("/proyectos")
    Proyecto newProyecto(@RequestBody Proyecto proyecto){
        return repositorio.save(proyecto);
    }
    //Individual
    @GetMapping("/proyectos/{id}")
    Proyecto obtenerProyecto(@PathVariable(value="id") long id){
        return repositorio.obtenerProyecto(id);
    }

    @PutMapping("/proyectos/{id}")
    Proyecto modificarProyecto(@PathVariable(value="id") long id, @RequestParam String nombre){
        return repositorio.modificar(id, nombre);
    }

    @DeleteMapping("proyectos/{id}")
    void borrarProyecto(@PathVariable(value="id") long id){
        repositorio.borrar(id);
    }
}
