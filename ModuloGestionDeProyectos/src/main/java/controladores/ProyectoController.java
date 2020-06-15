package controladores;


import modelo.Proyecto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProyectoController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/proyecto")
    public Proyecto greeting(@RequestParam(value = "nombre", defaultValue = "Sin título") String nombre) {
        return new Proyecto(counter.incrementAndGet(), nombre);
    }
}
