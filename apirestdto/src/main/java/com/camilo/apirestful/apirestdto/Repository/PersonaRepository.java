package com.camilo.apirestful.apirestdto.Repository;


import com.camilo.apirestful.apirestdto.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    /**
     *
     * @param user
     * @param password
     * @return the entity with the same data the user and password
     */
    public Persona findByUserAndPassword(String user, String password);

}
