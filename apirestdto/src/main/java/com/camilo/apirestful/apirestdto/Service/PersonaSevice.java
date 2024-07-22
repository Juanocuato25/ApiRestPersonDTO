package com.camilo.apirestful.apirestdto.Service;


import com.camilo.apirestful.apirestdto.Exceptions.ToDoExceptions;
import com.camilo.apirestful.apirestdto.Model.Persona;
import com.camilo.apirestful.apirestdto.Repository.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaSevice {

    @Autowired
    PersonaRepository personaRepository;

    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    @Transactional
    public void borrarPersona(Long id){
        Optional<Persona> personaOptional  = this.personaRepository.findById(id);
        if(personaOptional.isEmpty()){
            throw new ToDoExceptions("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
        personaRepository.deleteById(id);
    }

    public List<Persona> listarPersonas(){
        return personaRepository.findAll();
    }

    public Persona buscarPersonaPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void modificarPersona(Persona persona){
        Optional<Persona> personaOptional  = this.personaRepository.findById(persona.getId());
        if(personaOptional.isEmpty()){
            throw new ToDoExceptions("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
        personaRepository.save(persona);
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
