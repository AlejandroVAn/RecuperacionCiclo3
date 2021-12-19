package com.ciclo3.recuperacion.service;

import java.util.List;
import java.util.Optional;

import com.ciclo3.recuperacion.model.Artista;
import com.ciclo3.recuperacion.repository.ArtistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;
    public List<Artista> getAll(){
        return artistaRepository.getAll();
    }
    public Optional<Artista> getArtista(int id){
        return artistaRepository.getArtista(id);
    }
    public Artista save(Artista a) {
        if (a.getIdArtista() == null){
            return artistaRepository.save(a);
        } else {
            Optional<Artista> aOptional=artistaRepository.getArtista(a.getIdArtista());
            if (aOptional.isEmpty()){
                return artistaRepository.save(a);
            } else {
                return a;
            }
        }
    }
    public Artista update(Artista a) {
        if(a.getIdArtista() != null){
            Optional<Artista> aOptional = artistaRepository.getArtista(a.getIdArtista());
            if(!aOptional.isEmpty()){
                if (a.getName()!=null) {
                    aOptional.get().setName(a.getName());
                }
                if (a.getPais()!=null) {
                    aOptional.get().setPais(a.getPais());
                }
                return artistaRepository.save(aOptional.get());
            }
        }
        return a;
    }
    public boolean deleteArtista(int id) {
        Boolean artistaDelete=getArtista(id).map(artista ->{
            artistaRepository.delete(artista);
            return true;
        }).orElse(false);
        return artistaDelete;
    }
}
