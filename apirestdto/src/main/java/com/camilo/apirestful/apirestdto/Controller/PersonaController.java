package com.camilo.apirestful.apirestdto.Controller;


import com.camilo.apirestful.apirestdto.Model.Persona;
import com.camilo.apirestful.apirestdto.Service.PersonaDTO;
import com.camilo.apirestful.apirestdto.Service.PersonaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaSevice personaService;

    @GetMapping
    @ResponseBody
    public List<Persona> listarPersona(){
        return personaService.listarPersonas();
    }

    @PostMapping
    @ResponseBody
    public Persona crearPersona(@RequestBody Persona persona){
        return personaService.crearPersona(persona);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaService.borrarPersona(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Persona buscarPersonaPorId(@PathVariable Long id){
        return personaService.buscarPersonaPorId(id);
    }

    @PutMapping
    public void modificarPersona(@RequestBody Persona persona){
        personaService.modificarPersona(persona);
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
