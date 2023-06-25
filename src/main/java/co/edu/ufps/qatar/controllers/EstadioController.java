package co.edu.ufps.qatar.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.qatar.entities.EstadioEntity;
import co.edu.ufps.qatar.repositories.EstadioRepository;

@RestController
@RequestMapping("/estadio")
public class EstadioController {
    
    @Autowired
    EstadioRepository estadioRepository;

    @GetMapping
    public List<EstadioEntity> listarEstadios(){
        return estadioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstadio(@PathVariable("id") Integer id){
        Optional<EstadioEntity> estadioEntity = estadioRepository.findById(id);
        if(estadioEntity.isPresent()){
            estadioRepository.delete(estadioEntity.get());
            return ResponseEntity.ok("Estadio eliminado exitosamente");
        }else {
            String mensaje = "Estadio con id: " + id + " no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    } 
}
