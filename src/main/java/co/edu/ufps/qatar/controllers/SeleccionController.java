package co.edu.ufps.qatar.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.qatar.entities.SeleccionEntity;
import co.edu.ufps.qatar.repositories.SeleccionRepository;

@RestController
@RequestMapping("/selecciones")
@Validated
public class SeleccionController {
    
    @Autowired
    SeleccionRepository seleccionRepository;

    @GetMapping
    public List<SeleccionEntity> listarSelecciones() {
        return seleccionRepository.findAll();
    }

    @PostMapping
	public ResponseEntity<String> registrarSeleccion(@Valid @RequestBody SeleccionEntity seleccion) {
		
		seleccionRepository.save(seleccion);
		
		return ResponseEntity.ok("Seleccion registrada exitosamente");
		
	}

    @GetMapping("/grupo/{grupo}")
	public List<SeleccionEntity> listarGrupos(@PathVariable("grupo") String grupo) {
		
        List<SeleccionEntity> seleccion = seleccionRepository.findByGrupo(grupo);
		
		if (!seleccion.isEmpty()) {
			return seleccion;
		}
		
		return null;
	}
}
