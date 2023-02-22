
package com.MiPortfolio.Oscar.Security.Repository;

import com.MiPortfolio.Oscar.Security.Entity.Rol;
import com.MiPortfolio.Oscar.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
