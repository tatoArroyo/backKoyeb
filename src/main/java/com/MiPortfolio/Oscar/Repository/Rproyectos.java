
package com.MiPortfolio.Oscar.Repository;

import com.MiPortfolio.Oscar.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Rproyectos extends JpaRepository<Proyectos, Integer>{
    Optional<Proyectos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
