package com.prueba.java.sprintboot.pruebaJava.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_house", nullable = false, unique = true)
    private Long id;
    @Column(length = 20)
    private String name;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Inscription> inscriptions = new ArrayList<>();


    public House() {

    }

    public House(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public House(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
