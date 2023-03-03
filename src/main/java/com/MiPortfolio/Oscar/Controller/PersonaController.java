
package com.MiPortfolio.Oscar.Controller;

import com.MiPortfolio.Oscar.Dto.dtoPersona;
import com.MiPortfolio.Oscar.Entity.Persona;
import com.MiPortfolio.Oscar.Security.Controller.Mensaje;
import com.MiPortfolio.Oscar.Service.ImpPersonaService;

import java.sql.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//saque la barra delante de persona
@RequestMapping("personas")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://CarpetaFrontend.web.app")
public class PersonaController {
    @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
         List<Persona> list = personaService.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona>getById(@PathVariable("id")int id){
       if(!personaService.existsById(id)){
           return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
       } 
       Persona persona = personaService.getOne(id).get();
    return new ResponseEntity(persona, HttpStatus.OK);
    }
            
   /* @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);            
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
        
    }*/
    
   /* @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    } 
        
        if(personaService.existsByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
         Persona persona = new Persona(dtopersona.getNombreE(), dtopersona.getDescripcionE());
         personaService.save(persona);
         return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
        }*/
    @PreAuthorize("hasRole('ADMIN')")  
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre())&& personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
            }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(dtopersona.getDescripcion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getDomicilio())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
    if(StringUtils.isBlank(dtopersona.getApellido())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
    }

    Persona persona = personaService.getOne(id).get();
    persona.setNombre(dtopersona.getNombre());
    persona.setDescripcion(dtopersona.getDescripcion());
    persona.setApellido(dtopersona.getApellido());
    persona.setImg(dtopersona.getImg());
    persona.setCorreo(dtopersona.getCorreo());
    persona.setNacimiento(dtopersona.getNacimiento());
    persona.setDomicilio(dtopersona.getDomicilio());
    persona.setTelefono(dtopersona.getTelefono());
    //aca agrege cosas que faltaban
    personaService.save(persona);
    return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
}
}
