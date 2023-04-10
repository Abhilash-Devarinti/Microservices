package com.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {

    private Integer id;
    @Size(min = 2)
    private String name;
    @Past
    private LocalDate birthDat;

    public User(Integer id, String name, LocalDate birthDat) {
        this.id = id;
        this.name = name;
        this.birthDat = birthDat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDat() {
        return birthDat;
    }

    public void setBirthDat(LocalDate birthDat) {
        this.birthDat = birthDat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDat=" + birthDat +
                '}';
    }
}
