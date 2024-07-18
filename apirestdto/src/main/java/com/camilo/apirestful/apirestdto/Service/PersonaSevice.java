package com.camilo.apirestful.apirestdto.Service;


import com.camilo.apirestful.apirestdto.Model.Persona;
import com.camilo.apirestful.apirestdto.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaSevice {

    @Autowired
    PersonaRepository personaRepository;

    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public void borrarPersona(Long id){
        personaRepository.deleteById(id);
    }

    public List<Persona> listarPersonas(){
        return personaRepository.findAll();
    }

    public Persona buscarPersonaPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    public Persona modificarPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Persona modificarAtributoPersona(Persona persona){

        //if (persona.getId() == )
        return personaRepository.save(persona);
    }

    public PersonaDTO login(String user, String password){
      Persona persona = personaRepository.findByUserAndPassword(user, password);
      PersonaDTO personaDTO = new PersonaDTO(persona.getId(),persona.getUbication(),persona.getPosition(),persona.getFullname(),persona.getImage());
      return personaDTO;
    }
}
