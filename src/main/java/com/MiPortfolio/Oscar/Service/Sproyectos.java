
package com.MiPortfolio.Oscar.Service;

import com.MiPortfolio.Oscar.Entity.Proyectos;
import com.MiPortfolio.Oscar.Repository.Rproyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class Sproyectos {
   @Autowired Rproyectos rproyectos;
   
   public List<Proyectos> list(){
       return rproyectos.findAll();
   }
   public Optional<Proyectos> getOne(int id){
     return rproyectos.findById(id); 
   }
   public Optional<Proyectos> getByNombre(String nombre){
       return rproyectos.findByNombre(nombre);
   }
   public void save(Proyectos proyecto){
       rproyectos.save(proyecto);
   }
   public void delete(int id){
       rproyectos.deleteById(id);
   }
   public boolean existsById(int id){
       return rproyectos.existsById(id);
   }
   public boolean existsByNombre(String nombre){
       return rproyectos.existsByNombre(nombre);
   }
   
    
}
