package com.bnta.vet_service.models;

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String type;


    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;


    //constructors(2)

    //constructor 1- default constructor
    //click select non- with no args

    public Pet() {}

    //constructor 2- regular- with selected args

    //did not pass id because we don't want it to be in constructor, we will not be creating it ourselves- database will
    // handle that
    public Pet(String name, String type, Vet vet) {
        this.name = name;
        this.type = type;
        this.vet = vet;
    }

    //Getters + setters

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
