package com.ciclo3.recuperacion.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.recuperacion.model.Cancion;
import com.ciclo3.recuperacion.service.CancionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Artista")
public class CancionController {
    @Autowired
    private CancionService cancionService;
    @GetMapping("/all")
    public List<Cancion> getCancion() {
        return cancionService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Cancion> getCancion(@PathVariable("id") int id){
        return cancionService.getCancion(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cancion save(@RequestBody Cancion cancion){
        return cancionService.save(cancion);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cancion update(@RequestBody Cancion cancion) {
        return cancionService.update(cancion);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return cancionService.deleteCancion(id);
    }

}
