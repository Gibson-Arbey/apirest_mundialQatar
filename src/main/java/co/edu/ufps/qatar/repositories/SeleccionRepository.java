package co.edu.ufps.qatar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.qatar.entities.SeleccionEntity;

public interface SeleccionRepository extends JpaRepository<SeleccionEntity, Integer> {
    public List<SeleccionEntity> findByGrupo(String grupo);
}
