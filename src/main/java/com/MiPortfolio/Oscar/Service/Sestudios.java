
package com.MiPortfolio.Oscar.Service;

import com.MiPortfolio.Oscar.Entity.Estudios;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MiPortfolio.Oscar.Repository.REstudios;

@Service
@Transactional
public class Sestudios {
    @Autowired
    REstudios rEstudios;
    public List<Estudios> list(){
        return rEstudios.findAll();
    }
    public Optional<Estudios> getOne(int id){
        return rEstudios.findById(id);
    }
    public Optional<Estudios> getByNombreE(String nombreE){
        return rEstudios.findByNombreE(nombreE);
    }
    public void save(Estudios estudios){
        rEstudios.save(estudios);
}
    public void delete(int id){
        rEstudios.deleteById(id);
    }
    public boolean existsById(int id){
        return rEstudios.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
        return rEstudios.existsByNombreE(nombreE);
    }
    
}
