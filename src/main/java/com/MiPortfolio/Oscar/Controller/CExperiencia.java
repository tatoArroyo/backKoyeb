package com.MiPortfolio.Oscar.Controller;

import com.MiPortfolio.Oscar.Dto.dtoExperiencia;
import com.MiPortfolio.Oscar.Entity.Experiencia;
import com.MiPortfolio.Oscar.Security.Controller.Mensaje;
import com.MiPortfolio.Oscar.Service.SExperiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "https://frontend1910-6bd06.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
        public ResponseEntity<Experiencia>getById(@PathVariable("id") int id){
    if (!sExperiencia.existsById(id))
        return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
    Experiencia experiencia = sExperiencia.getOne(id).get();
    return new ResponseEntity(experiencia, HttpStatus.OK);
}
    @PreAuthorize("hasRole('ADMIN')")  
        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody Experiencia exp){
//          if (StringUtils.isBlank (dtoexp.getNombreE())) {
//                return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//            }
//
//            if (sExperiencia.existsByNombreE(dtoexp.getNombreE())) {
//                return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
//            }
//            //no puede estar vacio
//            Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
            sExperiencia.save(exp);
            return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        }
        
        @PreAuthorize("hasRole('ADMIN')")  
        @PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Experiencia exp){
    //validamos si existeel ID
  if(!sExperiencia.existsById(id))
      return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

    if(sExperiencia.existsByNombreE(exp.getNombreE()) && sExperiencia.getByNombreE(exp.getNombreE()).get().getId() != id)
     return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);

if(StringUtils.isBlank(exp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

     Experiencia experiencia = sExperiencia.getOne(id).get();
     experiencia.setNombreE(exp.getNombreE());
     experiencia.setDescripcionE((exp.getDescripcionE()));


            //aca modifique por lo del servicio
     sExperiencia.edit(exp);
     return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
     
}
@PreAuthorize("hasRole('ADMIN')")  
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable("id")int id){
    //validamos si existe el ID
    if(!sExperiencia.existsById(id))
        return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
    
    sExperiencia.delete(id);
    return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    
}
    }
