package controladores;


import modelo.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import servicio.ProyectoService;

import java.util.List;

@RestController
public class ProyectoController {
    @Autowired
    private ProyectoService servicio;
    //Grupal
    @GetMapping("/proyectos")
    List<Proyecto> all(){
        return servicio.findAll();
    }

    @PostMapping("/proyectos")
    Proyecto newProyecto(@RequestBody Proyecto proyecto){
        return servicio.save(proyecto);
    }
    //Individual
    @GetMapping("/proyectos/{id}")
    Proyecto obtenerProyecto(@PathVariable(value="id") long id){
        return servicio.getOne(id);
    }

    @PutMapping("/proyectos/{id}")
    Proyecto modificarProyecto(@PathVariable(value="id") long id, @RequestBody Proyecto proyecto){
        Proyecto actual =  servicio.getOne(id);
        actual.modificar(proyecto);
        return actual;
    }

    @DeleteMapping("proyectos/{id}")
    void borrarProyecto(@PathVariable(value="id") long id){
        servicio.deleteById(id);
    }
}
