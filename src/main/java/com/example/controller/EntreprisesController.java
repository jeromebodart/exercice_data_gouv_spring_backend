package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.entreprise.Entreprise;
import com.example.service.EntrepriseService;

@RestController
@RequestMapping("/entreprises")
public class EntreprisesController {
	@Autowired
	private EntrepriseService entrepriseService;

	@GetMapping
	public List<Entreprise> index() {
		return entrepriseService.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity show(@PathVariable Long id) {
		Entreprise entreprise =  entrepriseService.findOne(id);
		if (entreprise == null) {
			return new ResponseEntity("No Enterprise found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(entreprise, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity create(@RequestBody Entreprise entreprise) {
		entrepriseService.save(entreprise);
		return  new ResponseEntity(entreprise, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity update(@RequestBody Entreprise entreprise) {
		entrepriseService.update(entreprise);
		return  new ResponseEntity(entreprise, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity destroy(@PathVariable Long id) {
		entrepriseService.delete(id);
		if (entrepriseService.findOne(id) == null) {
			return new ResponseEntity("No Enterprise found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(id, HttpStatus.OK);
	}
}
