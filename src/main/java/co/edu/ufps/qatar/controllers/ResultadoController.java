package co.edu.ufps.qatar.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.qatar.entities.ResultadoEntity;
import co.edu.ufps.qatar.repositories.ResultadoRepository;

@RestController
@RequestMapping("/resultados")
@Validated
public class ResultadoController {

    @Autowired
    ResultadoRepository resultadoRepository;

    @PostMapping
    public ResponseEntity<String> registrarResultado(@Valid @RequestBody ResultadoEntity resultadoEntity){
        resultadoRepository.save(resultadoEntity);
        return ResponseEntity.ok("Resultado resgistrado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarResultado(@PathVariable("id") Integer id, @Valid @RequestBody ResultadoEntity resultadoActualizado){
        Optional<ResultadoEntity> resultadoEntity = resultadoRepository.findById(id);
        if (resultadoEntity.isPresent()){
            ResultadoEntity resultadoFinal = resultadoEntity.get();
            resultadoFinal.setAmarillas(resultadoActualizado.getAmarillas());
            resultadoFinal.setRojas(resultadoActualizado.getRojas());
            resultadoFinal.setGoles(resultadoActualizado.getGoles());
            resultadoRepository.save(resultadoFinal);
            return ResponseEntity.ok("Resultado actualizado exitosamente");
        }else {
            String mensaje = "Resultado con id: " + id + " no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }
}
