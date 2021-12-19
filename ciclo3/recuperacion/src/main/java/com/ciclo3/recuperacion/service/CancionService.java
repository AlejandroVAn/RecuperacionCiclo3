package com.ciclo3.recuperacion.service;

import java.util.List;
import java.util.Optional;

import com.ciclo3.recuperacion.model.Cancion;
import com.ciclo3.recuperacion.repository.CancionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancionService {
    @Autowired
    private CancionRepository cancionRepository;
    public List<Cancion> getAll(){
        return cancionRepository.getAll();
    }
    public Optional<Cancion> getCancion(int id){
        return cancionRepository.getCancion(id);
    }
    public Cancion save(Cancion cancion) {
        if (cancion.getId() == null){
            return cancionRepository.save(cancion);
        } else {
            Optional<Cancion> cancionOptional=cancionRepository.getCancion(cancion.getId());
            if (cancionOptional.isEmpty()){
                return cancionRepository.save(cancion);
            } else {
                return cancion;
            }
        }
    }
    public Cancion update(Cancion cancion) {
        if(cancion.getId() != null){
            Optional<Cancion> cancionOptional = cancionRepository.getCancion(cancion.getId());
            if(!cancionOptional.isEmpty()){
                if (cancion.getName()!=null) {
                    cancionOptional.get().setName(cancion.getName());
                }
                if (cancion.getAlbum()!=null) {
                    cancionOptional.get().setAlbum(cancion.getAlbum());
                }
                if (cancion.getIdArtista()!=null) {
                    cancionOptional.get().setIdArtista(cancion.getIdArtista());
                }
                if (cancion.getYear()!=null) {
                    cancionOptional.get().setYear(cancion.getYear());
                }
                return cancionRepository.save(cancionOptional.get());
            }
        }
        return cancion;
    }
    public boolean deleteCancion(int id) {
        Boolean cancionDelete=getCancion(id).map(cancion ->{
            cancionRepository.delete(cancion);
            return true;
        }).orElse(false);
        return cancionDelete;
    }
}
