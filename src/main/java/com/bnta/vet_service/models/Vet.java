package com.bnta.vet_service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vets")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "vet")
    @JsonIgnoreProperties({"vet"})

    private List<Pet> pets;

    //constructors (2)

    //constructor 1- default constructor
    //click select non- with no args
    public Vet() {
    }

    //constructor 2- with selected args
    public Vet( String name) {
        this.name = name;
        this.pets = new ArrayList<Pet>();
    }

    //Getters + Setters

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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
