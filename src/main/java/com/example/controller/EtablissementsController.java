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

import com.example.domain.etablissement.Etablissement;
import com.example.service.EtablissementService;


@RestController
@RequestMapping("/etablissements")
public class EtablissementsController {
	 @Autowired
	    private EtablissementService etablissementService;
	    @GetMapping
	    public List<Etablissement> index() {
	    	return etablissementService.findAll();
	    }
	    
	    @GetMapping("{id}")
	    public ResponseEntity show(@PathVariable Long id) {
	    	Etablissement etablissement =  etablissementService.findOne(id);
			if (etablissement == null) {
				return new ResponseEntity("No Enterprise found for ID " + id, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(etablissement, HttpStatus.OK);
	    }
	    @PostMapping
		public ResponseEntity create(@RequestBody Etablissement etablissement) {
	    	etablissementService.save(etablissement);
			return  new ResponseEntity(etablissement, HttpStatus.OK);
		}

		@PutMapping("{id}")
		public ResponseEntity update(@RequestBody Etablissement etablissement) {
			etablissementService.update(etablissement);
			return  new ResponseEntity(etablissement, HttpStatus.OK);
		}

		@DeleteMapping("{id}")
		public ResponseEntity destroy(@PathVariable Long id) {
			etablissementService.delete(id);
			if (etablissementService.findOne(id) != null) {
				return new ResponseEntity("Deletion failed " + id, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(id, HttpStatus.OK);
		}
}
