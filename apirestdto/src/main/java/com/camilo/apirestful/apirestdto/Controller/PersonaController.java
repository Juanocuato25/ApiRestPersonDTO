package com.camilo.apirestful.apirestdto.Controller;


import com.camilo.apirestful.apirestdto.Model.Persona;
import com.camilo.apirestful.apirestdto.Service.PersonaDTO;
import com.camilo.apirestful.apirestdto.Service.PersonaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaSevice personaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Persona>> listarPersona(){
        return ResponseEntity.ok(personaService.listarPersonas());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> crearPersona(@RequestBody Persona persona){
        personaService.crearPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body("Persona creada satisfactoriamente: " + persona.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPersona(@PathVariable Long id){
        personaService.borrarPersona(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Persona buscarPersonaPorId(@PathVariable Long id){
        return personaService.buscarPersonaPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPersona(@RequestBody Persona persona){
        personaService.modificarPersona(persona);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public void modificarAtributoPersona(@RequestBody Persona persona){
        personaService.modificarAtributoPersona(persona);
    }

    @PostMapping("/login")
    public PersonaDTO login(@RequestBody Persona persona){
        return personaService.login(persona.getUser(), persona.getPassword());
    }

}
