package com.prueba.java.sprintboot.pruebaJava.entity;

import javax.persistence.*;

@Entity
@Table(name="house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_house", nullable = false, unique = true)
    private Long id;
    @Column(length = 20)
    private String name;

    /*@OneToOne(mappedBy="house")
    private Inscription inscription;*/

    @JoinColumn(name = "id_inscription")
    @OneToOne(fetch = FetchType.LAZY)
    private Inscription inscription;

    public House() {
    }

    public House(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
