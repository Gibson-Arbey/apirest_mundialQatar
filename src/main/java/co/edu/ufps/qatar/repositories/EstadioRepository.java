package co.edu.ufps.qatar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.qatar.entities.EstadioEntity;

public interface EstadioRepository extends JpaRepository<EstadioEntity,Integer> {
    
}
