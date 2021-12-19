package com.ciclo3.recuperacion.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "cancion")
public class Cancion implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idArtista;
    private String name;
    private String album;
    private Integer year;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdArtista() {
        return idArtista;
    }
    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    

   
}
