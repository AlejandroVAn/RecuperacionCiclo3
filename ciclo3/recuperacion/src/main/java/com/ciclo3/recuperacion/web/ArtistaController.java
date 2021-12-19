package com.ciclo3.recuperacion.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.recuperacion.model.Artista;
import com.ciclo3.recuperacion.service.ArtistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Artista")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;
    @GetMapping("/all")
    public List<Artista> getArtistas() {
        return artistaService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Artista> getArtista(@PathVariable("id") int id){
        return artistaService.getArtista(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Artista save(@RequestBody Artista artista){
        return artistaService.save(artista);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Artista update(@RequestBody Artista artista) {
        return artistaService.update(artista);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return artistaService.deleteArtista(id);
    }

}
