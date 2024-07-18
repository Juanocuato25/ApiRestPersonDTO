package com.camilo.apirestful.apirestdto.Service;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PersonaDTO {

    Long id;
    String ubication;
    String position;
    String fullname;
    String image;


    public PersonaDTO() {
    }

    public PersonaDTO(Long id, String ubication, String position, String fullname, String image) {
        this.id = id;
        this.ubication = ubication;
        this.position = position;
        this.fullname = fullname;
        this.image = image;
    }


}
