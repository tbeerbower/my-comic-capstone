package com.techelevator.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Creator {
    @Id
    @Column(
        updatable = false
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;


    private String name;


    public Creator() {
    }

    public Creator(Long id, String name) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creator creator = (Creator) o;
        return id.equals(creator.id) && name.equals(creator.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
