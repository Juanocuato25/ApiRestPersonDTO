package com.camilo.apirestful.apirestdto.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Basic
    String ubication;
    String position;
    String fullname;
    String image;
    String user;
    String password;

    public Persona(Long id, String ubication, String position, String fullname, String image, String user, String password) {
        this.id = id;
        this.ubication = ubication;
        this.position = position;
        this.fullname = fullname;
        this.image = image;
        this.user = user;
        this.password  = password;
    }

    public Persona() {

    }
}
