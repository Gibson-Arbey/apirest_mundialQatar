package co.edu.ufps.qatar.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.qatar.entities.PartidoEntity;
import co.edu.ufps.qatar.entities.ResultadoEntity;
import co.edu.ufps.qatar.repositories.PartidoRepository;

@RestController
@RequestMapping("/partidos")
@Validated
public class PartidoController {

    @Autowired
    PartidoRepository partidoRepository;

    @GetMapping
    public List<PartidoEntity> listar(){
        return partidoRepository.findAll();
    }

    @GetMapping("/{id}/resultados")
    public List<ResultadoEntity> listarResultados(@PathVariable("id") Integer id){
        Optional<PartidoEntity> partidoEntity = partidoRepository.findById(id);
        if(partidoEntity.isPresent()){        
            List<ResultadoEntity> resultados = partidoEntity.get().getResultado();
            return resultados;
        }
        
        return null;
    }
}
