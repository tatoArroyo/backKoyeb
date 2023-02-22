


package com.MiPortfolio.Oscar.Controller;

import com.MiPortfolio.Oscar.Dto.dtoProyectos;
import com.MiPortfolio.Oscar.Entity.Proyectos;
import com.MiPortfolio.Oscar.Security.Controller.Mensaje;
import com.MiPortfolio.Oscar.Service.Sproyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://CarpetaFrontend.web.app")
@RequestMapping("proyectos")
public class CProyectos {
     @Autowired
    Sproyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
         List<Proyectos> list = sProyectos.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos>getById(@PathVariable("id")int id){
       if(!sProyectos.existsById(id)){
           return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
       } 
       Proyectos proyectos = sProyectos.getOne(id).get();
    return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
            
            
            
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);            
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
        
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Proyectos proyectos){
//        if(StringUtils.isBlank(dtoproyectos.getNombre())){
//        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//    }
//
//        if(sProyectos.existsByNombre(dtoproyectos.getNombre())){
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        }
//
//         Proyectos proyectos = new Proyectos(dtoproyectos.getNombre(), dtoproyectos.getAcercaproyec());
         sProyectos.save(proyectos);
         return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Proyectos proye){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sProyectos.existsByNombre(proye.getNombre())&& sProyectos.getByNombre(proye.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
            }
        if(StringUtils.isBlank(proye.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }     
        if(StringUtils.isBlank(proye.getAcercaproyec())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }      
        
    Proyectos proyectos = sProyectos.getOne(id).get();
    proyectos.setNombre(proye.getNombre());
    proyectos.setAcercaproyec(proye.getAcercaproyec());
    sProyectos.save(proyectos);
    return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
}
}
