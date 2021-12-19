package com.ciclo3.recuperacion.repository;

import com.ciclo3.recuperacion.repository.crud.ArtistaRepositoryCrud;
import com.ciclo3.recuperacion.model.Artista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistaRepository {
    @Autowired
    private ArtistaRepositoryCrud artistaRepositoryCrud;
    public List<Artista> getAll(){
        return (List<Artista>) artistaRepositoryCrud.findAll();
    }
    public Optional<Artista> getArtista(int id){
        return artistaRepositoryCrud.findById(id);
    }
    public Artista save(Artista a){
        return artistaRepositoryCrud.save(a);
    }
    public void delete(Artista a) {
        artistaRepositoryCrud.delete(a);
    }
}
