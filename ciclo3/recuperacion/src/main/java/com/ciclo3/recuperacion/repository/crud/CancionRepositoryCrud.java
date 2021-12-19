package com.ciclo3.recuperacion.repository.crud;

import com.ciclo3.recuperacion.model.Cancion;

import org.springframework.data.repository.CrudRepository;

public interface CancionRepositoryCrud extends CrudRepository<Cancion, Integer> {
  
}
