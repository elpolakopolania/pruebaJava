package com.prueba.java.sprintboot.pruebaJava.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_inscription", nullable = false, unique = true)
    private Long id;

    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String lastname;
    @Column(length = 10)
    private Long identification;
    @Column(length = 2)
    private Integer age;

    @ManyToOne
    /*@JoinColumn(name ="id_house")
    @JsonBackReference*/
    private House house;

    public Inscription() {
    }

    public Inscription(Long id){
        this.id = id;
    }

    public Inscription(String name, String lastname, Long identification, Integer age, House house) {
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.age = age;
        this.house = house;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", identification=" + identification +
                ", age=" + age +
                ", house=" + house +
                '}';
    }
}
