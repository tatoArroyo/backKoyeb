
package com.MiPortfolio.Oscar.Repository;

import com.MiPortfolio.Oscar.Entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Rhys extends JpaRepository <hys, Integer> {
    Optional<hys> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
