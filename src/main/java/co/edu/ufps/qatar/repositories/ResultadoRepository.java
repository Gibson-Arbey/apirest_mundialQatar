package co.edu.ufps.qatar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.qatar.entities.ResultadoEntity;

public interface ResultadoRepository extends JpaRepository<ResultadoEntity, Integer> {
    
}
