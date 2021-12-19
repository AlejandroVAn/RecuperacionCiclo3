package com.ciclo3.recuperacion.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.ciclo3.recuperacion.model.Cancion;
import com.ciclo3.recuperacion.repository.crud.CancionRepositoryCrud;

@Repository
public class CancionRepository {
    @Autowired
    private CancionRepositoryCrud cancionRepositoryCrud;
    public List<Cancion> getAll(){
        return (List<Cancion>) cancionRepositoryCrud.findAll();
    }
    public Optional<Cancion> getCancion(int id){
        return cancionRepositoryCrud.findById(id);
    }
    public Cancion save(Cancion cancion){
        return cancionRepositoryCrud.save(cancion);
    }
    public void delete(Cancion cancion) {
        cancionRepositoryCrud.delete(cancion);
    }
}
